<template>
  <v-col cols="12" sm="4" style="height: 100%">
    <v-card class="mx-auto" style="height: 100%">
      <v-list>
        <v-list-item-group v-model="model">
          <v-list-item v-for="(item, i) in menuItems" :key="i">
            <v-list-item-icon>
              <v-icon v-text="item.icon"></v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title v-text="item.text"></v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-card>
  </v-col>
</template>

<script>
export default {
  props: {
    menuItems: {
      type: Object,
      default() {
        return {};
      },
    },
  },
  data() {
    return {
      model: 1,
    };
  },
  //   data: () => ({
  //     items: [
  //       {
  //         icon: "mdi-inbox",
  //         text: "Inbox",
  //       },
  //       {
  //         icon: "mdi-star",
  //         text: "Star",
  //       },
  //       {
  //         icon: "mdi-send",
  //         text: "Send",
  //       },
  //       {
  //         icon: "mdi-email-open",
  //         text: "Drafts",
  //       },
  //     ],
  //     model: 1,
  //   }),
};
</script>

<style></style>
