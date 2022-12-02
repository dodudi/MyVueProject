<template>
  <v-main>
    <v-row style="width: 100%; height: 100%">
      <menu-item-view></menu-item-view>
      <v-col cols="12" sm="8">
        <router-view></router-view>
      </v-col>
    </v-row>
  </v-main>
</template>

<script>
import MenuItemView from "./main/MenuItemView.vue";
export default {
  components: {
    MenuItemView,
  },
};
</script>

<style></style>
