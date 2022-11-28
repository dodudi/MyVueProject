<template>
  <admin-board-view :boardProps="{ pagingMethod, title }"></admin-board-view>
</template>

<script>
import AdminBoardView from "../../components/AdminBoardView.vue";
export default {
  components: {
    AdminBoardView,
  },
  data() {
    return {
      pagingMethod: "getBoards",
      title: "게시판 관리하기",
    };
  },
};
</script>

<style></style>
