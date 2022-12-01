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
      pagingMethod: "getShowBoards",
      title: "유저 게시판",
    };
  },
};
</script>

<style></style>
