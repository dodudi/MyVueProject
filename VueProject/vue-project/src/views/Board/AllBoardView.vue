<template>
  <user-board-view :boardProps="{ pagingMethod, title }"></user-board-view>
</template>

<script>
import UserBoardView from "../../components/board/UserBoardView.vue";
export default {
  components: {
    UserBoardView,
  },
  data() {
    return {
      pagingMethod: "getBoards",
      title: "모든 게시판",
    };
  },
};
</script>

<style></style>
