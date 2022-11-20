<template>
  <v-app>
    <v-main>
      <v-app-bar>
        <v-toolbar-title style="overflow: unset"
          >Collapsing Bar</v-toolbar-title
        >
        <v-tabs align-with-title>
          <v-tab to="/boardvue" exact>게시판 확인</v-tab>
          <v-tab to="/checkrezervevue" style="margin-right: auto"
            >게시판 예약 확인</v-tab
          >
          <v-tab to="/loginView">로그인</v-tab>
          <v-tab to="/joinView">회원가입</v-tab>
        </v-tabs>
      </v-app-bar>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
export default {};
</script>

<style></style>
