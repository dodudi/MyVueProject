<!-- Menu를 선택 하는 Header -->
<template>
  <v-app-bar app>
    <v-toolbar-title style="overflow: unset">Collapsing Bar</v-toolbar-title>
    <v-tabs align-with-title>
      <v-tab to="/menu/allBoardView" exact>모든 게시판 확인</v-tab>
      <v-tab to="/menu/showBoardView" style="margin-right: auto"
        >관리자가 수락한 게시판 확인</v-tab
      >
      <template v-if="memberId === null || memberId === undefined">
        <v-tab to="/loginView">로그인</v-tab>
        <v-tab to="/joinView">회원가입</v-tab>
      </template>
      <template v-else>
        <v-tab @click="logout">로그아웃</v-tab>
      </template>
      <template v-if="memberId == 'admin'">
        <v-tab to="/manageBoardView">예약 관리하기</v-tab>
      </template>
    </v-tabs>
  </v-app-bar>
</template>

<script>
export default {
  data() {
    return {
      memberId: null,
    };
  },
  methods: {
    logout() {
      sessionStorage.removeItem("memberId");
      this.memberId = null;
      console.log(sessionStorage.removeItem("memberId"));
    },
  },
  mounted() {
    this.memberId = sessionStorage.getItem("memberId");
  },
};
</script>

<style></style>
