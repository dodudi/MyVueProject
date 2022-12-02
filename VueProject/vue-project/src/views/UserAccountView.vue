<template>
  <v-app>
    <new-header-view></new-header-view>
    <router-view></router-view>
  </v-app>
</template>

<script>
import NewHeaderView from "../components/layout1/NewHeaderView.vue";
export default {
  components: {
    NewHeaderView,
  },
};
</script>

<style></style>
