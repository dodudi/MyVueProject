<template>
  <div>
    <v-data-table
      v-model="selected"
      :headers="getTableHeaders"
      :items="getBoards"
      :page.sync="getPageInfo.pageNum"
      :items-per-page="getPageInfo.itemLimit"
      hide-default-footer
      item-key="boardNumber"
      show-select
      class="elevation-1"
      @click:row="goBoardDetail"
      :loading="getTableLoading"
      loading-text="Loading... Please wait"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>{{ title }}</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <v-btn color="primary" dark class="mr-5" @click="acceptOnDialog">
            Accept Selected Board
          </v-btn>
          <v-btn color="error" dark @click="deleteOnDialog">
            Delete Selected
          </v-btn>

          <delete-board-dialog :selected="selected"></delete-board-dialog>
          <accept-board-dialog-vue
            :selected="selected"
          ></accept-board-dialog-vue>
        </v-toolbar>
      </template>
    </v-data-table>
    <pagination-view :pagingMethod="pagingMethod"></pagination-view>
  </div>
</template>

<script>
import bus from "../views/EventBus/bus.js";
import PaginationView from "../views/Pagination/PaginationView.vue";
import AcceptBoardDialogVue from "../views/Dialog/AcceptBoardDialog.vue";
import DeleteBoardDialog from "../views/Dialog/DeleteBoardDialog.vue";
export default {
  components: {
    AcceptBoardDialogVue,
    PaginationView,
    DeleteBoardDialog,
  },
  computed: {
    getTableHeaders() {
      return this.$store.getters.getTableHeaders;
    },
    getBoards() {
      return this.$store.getters.getBoards;
    },
    getTableLoading() {
      return this.$store.getters.getTableLoading;
    },
    getPageInfo() {
      return this.$store.getters.getPageInfo;
    },
  },
  data() {
    return {
      selected: [],
    };
  },
  methods: {
    acceptOnDialog() {
      bus.$emit("acceptOnDialog");
    },
    deleteOnDialog() {
      bus.$emit("deleteOnDialog");
    },
    goBoardDetail(item) {
      this.$router.push({ name: "detailBoardView", params: { board: item } });
    },
  },
};
</script>

<style></style>
