<template>
  <v-container style="width: 40%">
    <v-form ref="form" v-model="valid" lazy-validation>
      <v-text-field
        v-model="MEMBER_ID"
        :counter="10"
        @keydown="idCheck = false"
        :rules="idRules"
        label="아이디"
        required
      ></v-text-field>
      <v-text-field
        v-model="MEMBER_PASS"
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
      MEMBER_ID: "",
      idRules: [
        (v) => !!v || "아이디를 입력해주세요.",
        (v) => (v && v.length <= 10) || "아이디는 10글자 이하입니다.",
        (v) => (v && this.idCheck == false) || "아이디가 존재하지 않습니다.",
      ],
      MEMBER_PASS: "",
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
            member_ID: this.MEMBER_ID,
            member_PASS: this.MEMBER_PASS,
          })
          .then((response) => {
            let result = response.data;
            if (result == "id") {
              this.idCheck = true;
              this.$refs.form.validate();
            } else if (result == "pass") {
              this.passCheck = true;
              this.$refs.form.validate();
            } else {
              sessionStorage.setItem("member_ID", this.MEMBER_ID);
              location.href = "/boardvue";
              //this.$router.push({ name: "boardvue" });
            }
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
