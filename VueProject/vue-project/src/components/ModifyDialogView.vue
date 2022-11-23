<template>
  <v-dialog v-bind:value="getDialog" max-width="500px">
    <template v-slot:activator="{ on, attrs }">
      <v-btn color="primary" dark class="mb-2 ml-5" v-bind="attrs" v-on="on">
        Delete Select
      </v-btn>
      <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">
        New Item
      </v-btn>
    </template>
    <v-card>
      <v-card-title>
        <span class="text-h5">{{ formTitle }}</span>
      </v-card-title>

      <v-card-text>
        <v-container>
          <v-row>
            <v-col cols="12" sm="6" md="12">
              <v-text-field
                v-model="boardTitle"
                label="boardTitle"
              ></v-text-field>
            </v-col>
            <v-col cols="12" sm="6" md="12">
              <v-textarea
                name="input-7-1"
                label="boardContent"
                v-model="boardContent"
              ></v-textarea>
            </v-col>
          </v-row>
        </v-container>
      </v-card-text>

      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue darken-1" text @click="close"> Cancel </v-btn>
        <v-btn color="blue darken-1" text @click="save"> Save </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import { formatDate } from "../api/FormatDate.js";
import { save, close } from "../api/DialogApi.js";
export default {
  data() {
    return {
      boardTitle: "",
      boardContent: "",
    };
  },
  computed: {
    getDialog() {
      return this.$store.getters.getDialog;
    },
    formTitle() {
      return this.editedIndex === -1 ? "New Item" : "Edit Item";
    },
  },
  methods: {
    filters() {
      return formatDate();
    },
    close() {
      close();
    },
    //아이템 추가 or 설정 저장
    async save(boardTitle, boardContent) {
      save(boardTitle, boardContent);
    },
  },
};
</script>

<style></style>
