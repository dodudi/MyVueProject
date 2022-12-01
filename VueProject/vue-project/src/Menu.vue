<template>
  <v-app>
    <!-- Must have the app property -->
    <new-header-view></new-header-view>
    <body-view></body-view>
  </v-app>
</template>

<script>
import BodyView from "./components/layout1/BodyView.vue";
import NewHeaderView from "./components/layout1/NewHeaderView.vue";
export default {
  name: "App",
  components: {
    NewHeaderView,
    BodyView,
  },
};
</script>
