<template>
  <div>
    <v-data-table
      :headers="headers"
      :items="getBoards"
      hide-default-footer
      class="elevation-1"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>게시판</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <ModifyDialogView></ModifyDialogView>
          <RemoveDialogView></RemoveDialogView>
        </v-toolbar>
      </template>
      <template v-slot:[`item.actions`]="{ item }">
        <v-icon small class="mr-2" @click="editItem(item)"> mdi-pencil </v-icon>
        <v-icon small @click="deleteItem(item)"> mdi-delete </v-icon>
      </template>
      <template v-slot:no-data>
        <v-btn color="primary" @click="initialize"> Reset </v-btn>
      </template>
    </v-data-table>

    <PaginationView></PaginationView>
  </div>
</template>

<script>
import { getHeader } from "../api/PageCalc.js";
import PaginationView from "../components/PaginationView.vue";
import RemoveDialogView from "../components/RemoveDialogView.vue";
import ModifyDialogView from "../components/ModifyDialogView.vue";
export default {
  components: {
    PaginationView,
    RemoveDialogView,
    ModifyDialogView,
  },
  data() {
    return {
      headers: [],
      selected: [],
    };
  },
  created() {
    this.initialize();
  },
  computed: {
    getBoards() {
      return this.$store.getters.getBoards;
    },
  },
  methods: {
    initialize() {
      this.headers = getHeader();
    },
    //add, mod dialog 열기
    editItem(item) {
      this.$store.commit("SET_EDITED_INDEX", this.getBoards.indexOf(item));
      this.$store.commit("SET_EDITED_ITEM", Object.assign({}, item));
      this.$store.commit("SET_DIALOG", true);
    },
    //delete dialog 열기
    deleteItem(item) {
      this.$store.commit("SET_EDITED_INDEX", this.getBoards.indexOf(item));
      this.$store.commit("SET_EDITED_ITEM", Object.assign({}, item));
      this.$store.commit("SET_DELETE_DIALOG", true);
    },
  },
};
</script>
