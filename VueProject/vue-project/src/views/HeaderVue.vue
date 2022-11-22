<template>
  <v-app>
    <v-main>
      <v-app-bar>
        <v-toolbar-title style="overflow: unset"
          >Collapsing Bar</v-toolbar-title
        >
        <v-tabs align-with-title>
          <v-tab to="/boardvue" exact>모든 게시판 확인</v-tab>
          <v-tab to="/checkrezervevue" style="margin-right: auto"
            >게시판 예약 확인</v-tab
          >
          <template v-if="member_ID === null || member_ID === ''">
            <v-tab to="/loginView">로그인</v-tab>
            <v-tab to="/joinView">회원가입</v-tab>
          </template>
          <template v-else>
            <v-tab @click="logout">로그아웃</v-tab>
          </template>
          <template v-if="member_ID == 'admin'">
            <v-tab to="/boardRezerveView">예약 관리하기</v-tab>
          </template>
        </v-tabs>
      </v-app-bar>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
export default {
  data() {
    return {
      member_ID: null,
    };
  },
  methods: {
    logout() {
      sessionStorage.setItem("member_ID", null);
      this.member_ID = null;
      console.log("nice");
    },
  },
  mounted() {
    this.member_ID = sessionStorage.getItem("member_ID");
    console.log(this.member_ID);
  },
};
</script>

<style></style>
