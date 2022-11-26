<template>
  <v-dialog v-model="acceptDialog" max-width="500px">
    <v-card>
      <v-card-title class="text-h5"
        >Are you sure you want to delete this item?</v-card-title
      >
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue darken-1" text @click="acceptDialog = false"
          >Cancel</v-btn
        >
        <v-btn color="blue darken-1" text @click="goAccept">OK</v-btn>
        <v-spacer></v-spacer>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import bus from "../EventBus/bus.js";
import axios from "axios";
export default {
  created() {
    bus.$on("acceptOnDialog", this.openDialog);
    bus.$on("acceptOffDialog", this.closeDialog);
  },
  beforeDestroy() {
    bus.$off("acceptOnDialog", this.openDialog);
    bus.$off("acceptOffDialog", this.closeDialog);
  },
  data() {
    return {
      acceptDialog: false,
    };
  },
  methods: {
    closeDialog() {
      this.acceptDialog = false;
    },
    openDialog() {
      this.acceptDialog = true;
    },
    goAccept() {
      axios
        .post("/acceptSelectedBoard", this.selected)
        .then((response) => {
          console.log(response.data);
          //this.$emit("pageLoad");
          this.pageLoad();
          this.acceptDialog = false;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style></style>
