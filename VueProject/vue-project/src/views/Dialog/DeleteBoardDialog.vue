<template>
  <v-dialog v-model="deleteDialog" max-width="500px">
    <v-card>
      <v-card-title class="text-h5"
        >게시물 등록을 허용하시겠습니까?</v-card-title
      >
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue darken-1" text @click="closeDialog">Cancel</v-btn>
        <v-btn color="blue darken-1" text @click="goDelete">OK</v-btn>
        <v-spacer></v-spacer>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import bus from "../EventBus/bus.js";
import axios from "axios";
export default {
  props: ["selected"],
  created() {
    bus.$on("deleteOnDialog", this.openDialog);
    bus.$on("deleteOffDialog", this.closeDialog);
  },
  beforeDestroy() {
    bus.$off("deleteOnDialog", this.openDialog);
    bus.$off("deleteOffDialog", this.closeDialog);
  },
  data() {
    return {
      deleteDialog: false,
    };
  },
  methods: {
    closeDialog() {
      this.deleteDialog = false;
    },
    openDialog() {
      this.deleteDialog = true;
    },
    goDelete() {
      axios
        .post("/delSelectedBoard", this.selected)
        .then((response) => {
          console.log(response.data);
          bus.$emit("pageLoad");
          this.deleteDialog = false;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style></style>
