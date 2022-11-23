<template>
  <!--Remove Item Dialog-->
  <v-dialog v-bind:value="getDeleteDialog" max-width="500px">
    <v-card>
      <v-card-title class="text-h5"
        >Are you sure you want to delete this item?</v-card-title
      >
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue darken-1" text @click="closeDelete">Cancel</v-btn>
        <v-btn color="blue darken-1" text @click="deleteItemConfirm">OK</v-btn>
        <v-spacer></v-spacer>
      </v-card-actions>
    </v-card>
  </v-dialog>
  <!--End Remove Item Dialog-->
</template>

<script>
import { deleteItemConfirm, closeDelete } from "../api/DialogApi.js";
export default {
  computed: {
    getDeleteDialog() {
      return this.$store.getters.getDeleteDialog;
    },
  },
  methods: {
    //아이템 삭제
    deleteItemConfirm() {
      deleteItemConfirm();
    },
    closeDelete() {
      closeDelete();
    },
  },
};
</script>

<style></style>
