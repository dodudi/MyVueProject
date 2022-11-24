<template>
  <v-container style="width: 1000px">
    <v-form ref="form" v-model="valid" lazy-validation>
      <v-text-field
        v-model="boardTitle"
        :counter="10"
        :rules="nameRules"
        label="Board Title"
        required
      ></v-text-field>

      <toast-editer @getEditerHTML="getEditerHTML"></toast-editer>
      <v-btn :disabled="!valid" color="success" class="mr-4" @click="validate">
        Validate
      </v-btn>

      <v-btn color="error" class="mr-4" @click="reset"> Reset Form </v-btn>
      <v-btn color="warning" @click="resetValidation"> Reset Validation </v-btn>
    </v-form>
    {{ boardContent }}
  </v-container>
</template>

<script>
import ToastEditer from "./ToastEditerView.vue";
export default {
  components: {
    ToastEditer,
  },
  data() {
    return {
      valid: true,
      boardTitle: "",
      nameRules: [
        (v) => !!v || "Name is required",
        (v) => (v && v.length <= 10) || "Name must be less than 10 characters",
      ],
      boardContent: "",
      emailRules: [
        (v) => !!v || "E-mail is required",
        (v) => /.+@.+\..+/.test(v) || "E-mail must be valid",
      ],
    };
  },
  methods: {
    getEditerHTML(value) {
      this.boardContent = value;
    },
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
