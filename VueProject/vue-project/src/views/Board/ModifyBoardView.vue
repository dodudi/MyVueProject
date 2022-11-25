<template>
  <v-container style="width: 1000px">
    <v-form ref="form" v-model="valid" lazy-validation>
      <v-text-field
        v-model="newBoard.boardTitle"
        :counter="10"
        :rules="nameRules"
        label="Board Title"
        required
      ></v-text-field>

      <toast-editer
        :oldBoard="board"
        @getEditerHTML="getEditerHTML"
      ></toast-editer>
      <v-btn
        :disabled="!valid"
        color="success"
        class="mr-4"
        @click="createBoard"
      >
        Add
      </v-btn>

      <v-btn color="error" class="mr-4" @click="reset"> Reset Form </v-btn>
      <v-btn color="warning" @click="resetValidation"> Reset Validation </v-btn>
    </v-form>
    {{ newBoard.boardContent }}
  </v-container>
</template>

<script>
import ToastEditer from "../BoardToast/ToastEditerView.vue";
import axios from "axios";
export default {
  components: {
    ToastEditer,
  },
  props: ["board"],
  data() {
    return {
      newBoard: {
        boardTitle: this.board.boardTitle,
        boardContent: this.board.boardContent,
        memberId: this.board.memberId,
      },
      valid: true,
      nameRules: [
        (v) => !!v || "Name is required",
        (v) => (v && v.length <= 10) || "Name must be less than 10 characters",
      ],
    };
  },
  methods: {
    createBoard() {
      if (this.$refs.form.validate()) {
        axios
          .post("/addBoard", this.newBoard)
          .then((response) => {
            console.log(response);
            this.$router.push({ name: "allBoardView" });
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
    getEditerHTML(value) {
      this.newBoard.boardContent = value;
      console.log("AddBoardView Board Content : " + this.newBoard.boardContent);
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
