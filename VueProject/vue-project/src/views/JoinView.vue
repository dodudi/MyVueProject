<template>
  <v-container style="width: 40%">
    <v-form ref="form" v-model="valid" lazy-validation>
      <v-text-field
        v-model="MEMBER_NAME"
        :counter="10"
        :rules="nameRules"
        label="이름"
        required
      ></v-text-field>
      <v-text-field
        v-model="MEMBER_ID"
        @keydown="dialog3 = false"
        :counter="10"
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
      ></v-text-field>
      <v-checkbox
        v-model="checkbox"
        :rules="[(v) => !!v || 'You must agree to continue!']"
        label="Do you agree?"
        required
      ></v-checkbox>
      <v-btn color="warning" class="mr-4" @click="join"> 회원가입 </v-btn>
      <v-btn color="error" @click="reset"> Reset Form </v-btn>
    </v-form>
  </v-container>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      dialog3: false,
      show1: false,
      valid: true,
      MEMBER_NAME: "",
      nameRules: [(v) => !!v || "이름을 입력해주세요."],
      MEMBER_ID: "",
      idRules: [
        (v) => !!v || "아이디를 입력해주세요.",
        (v) => (v && v.length <= 10) || "아이디는 10글자 이하입니다.",
        (v) => (v && this.dialog3 == false) || "이미 존재하는 아이디입니다.",
      ],
      MEMBER_PASS: "",
      passRules: [
        (v) => !!v || "비밀번호를 입력해주세요.",
        (v) => (v && v.length <= 20) || "비밀번호는 20글자 이하입니다.",
      ],
      checkbox: false,
    };
  },
  methods: {
    reset() {
      this.$refs.form.reset();
    },
    join() {
      let inputCheck = this.$refs.form.validate();
      if (inputCheck == true) {
        axios
          .post("/memberJoin", {
            member_ID: this.MEMBER_ID,
            member_PASS: this.MEMBER_PASS,
            member_NAME: this.MEMBER_NAME,
          })
          .then((response) => {
            console.log(response.data);
            if (response.data == "success") {
              this.$router.push({ name: "boardvue" });
            } else {
              this.dialog3 = true;
              console.log("가입 실패");
              this.$refs.form.validate();
            }
          })
          .catch((error) => console.log(error));
      }
    },
  },
};
</script>

<style></style>
