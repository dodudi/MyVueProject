<template>
  <v-main>
    <v-container style="width: 40%">
      <v-form ref="form" v-model="valid" lazy-validation>
        <v-text-field
          v-model="memberId"
          :counter="10"
          @keydown="idCheck = false"
          :rules="idRules"
          label="아이디"
          required
        ></v-text-field>
        <v-text-field
          v-model="memberPass"
          :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
          :rules="passRules"
          :type="show1 ? 'text' : 'password'"
          label="비밀번호"
          :counter="20"
          @click:append="show1 = !show1"
          @keydown="passCheck = false"
        ></v-text-field>
        <v-checkbox
          v-model="checkbox"
          :rules="[(v) => !!v || 'You must agree to continue!']"
          label="Do you agree?"
          required
        ></v-checkbox>

        <v-btn color="warning" class="mr-4" @click="login"> 로그인 </v-btn>
        <v-btn color="error" @click="reset"> Reset Form </v-btn>
      </v-form>
    </v-container>
  </v-main>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      show1: false,
      valid: true,
      idCheck: false,
      passCheck: false,
      memberId: "",
      idRules: [
        (v) => !!v || "아이디를 입력해주세요.",
        (v) => (v && v.length <= 10) || "아이디는 10글자 이하입니다.",
        (v) => (v && this.idCheck == false) || "아이디가 존재하지 않습니다.",
      ],
      memberPass: "",
      passRules: [
        (v) => !!v || "비밀번호를 입력해주세요.",
        (v) => (v && v.length <= 20) || "비밀번호는 20글자 이하입니다.",
        (v) =>
          (v && this.passCheck == false) || "비밀번호가 일치하지 않습니다.",
      ],
      checkbox: false,
    };
  },
  methods: {
    async login() {
      let loginCheck = this.$refs.form.validate();
      if (loginCheck == true) {
        await axios
          .post("/memberLogin", {
            memberId: this.memberId,
            memberPass: this.memberPass,
          })
          .then((response) => {
            let result = response.data;
            //Login Success
            if (result == "") {
              sessionStorage.setItem("memberId", this.memberId);
              location.href = "/allBoardView";
              return;
            }

            //Login Fail
            this.idCheck = result == "errorId";
            this.passCheck = result == "errorPass";
            this.$refs.form.validate();
          })
          .catch((error) => console.log(error));
      }
    },
    reset() {
      this.$refs.form.reset();
    },
  },
};
</script>

<style></style>
