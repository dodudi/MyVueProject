<template>
  <v-container style="width: 40%">
    <v-form ref="form" v-model="valid" lazy-validation>
      <v-text-field
        v-model="MEMBER_ID"
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
        name="input-10-1"
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

      <v-btn :disabled="!valid" color="success" class="mr-4" @click="validate">
        Validate
      </v-btn>

      <v-btn color="error" class="mr-4" @click="reset"> Reset Form </v-btn>

      <v-btn color="warning" @click="resetValidation"> Reset Validation </v-btn>
    </v-form>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    show1: false,
    valid: true,
    MEMBER_ID: "",
    idRules: [
      (v) => !!v || "아이디를 입력해주세요.",
      (v) => (v && v.length <= 10) || "아이디는 10글자 이하입니다.",
    ],
    MEMBER_PASS: "",
    passRules: [
      (v) => !!v || "비밀번호를 입력해주세요.",
      (v) => (v && v.length <= 20) || "비밀번호는 20글자 이하입니다.",
    ],
    checkbox: false,
  }),

  methods: {
    validate() {
      this.$refs.form.validate();
    },
    reset() {
      this.$refs.form.reset();
    },
    resetValidation() {
      this.$refs.form.resetValidation();
    },
  },
};
</script>

<style></style>
