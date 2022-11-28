<template>
  <div>
    <v-data-table
      :headers="getTableHeaders"
      :items="getBoards"
      :page.sync="getPageInfo.pageNum"
      :items-per-page="getPageInfo.itemLimit"
      hide-default-footer
      class="elevation-1"
      @click:row="goBoardDetail"
      :loading="getTableLoading"
      loading-text="Loading... Please wait"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>{{ boardProps.title }}</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <v-btn color="primary" dark @click="goAddBoard"> Add Board </v-btn>
        </v-toolbar>
      </template>
    </v-data-table>
    <pagination-view :pagingMethod="boardProps.pagingMethod"></pagination-view>
  </div>
</template>

<script>
import PaginationView from "../views/Pagination/PaginationView.vue";
export default {
  components: {
    PaginationView,
  },
  props: ["boardProps"],
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
  methods: {
    goBoardDetail(item) {
      this.$router.push({ name: "detailBoardView", params: { board: item } });
    },
    goAddBoard() {
      this.$router.push({ name: "addBoardView" });
    },
  },
};
</script>

<style></style>
