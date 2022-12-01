<template>
  <div class="text-center pt-2">
    <v-pagination
      v-model="pageNum"
      :length="getRealEndpage"
      :total-visible="7"
    ></v-pagination>
  </div>
</template>

<script>
export default {
  props: ["pagingMethod"],
  created() {
    this.$store.commit("SET_PAGE_INFO", { pageNum: 1 });
    this.$store.dispatch("pageLoad", this.pagingMethod);
  },
  watch: {
    pageNum() {
      console.log("Page Change");
      this.$store.commit("SET_PAGE_INFO", { pageNum: this.pageNum });
      this.$store.dispatch("pageLoad", this.pagingMethod);
    },
  },
  data() {
    return {
      pageNum: 1,
    };
  },
  computed: {
    getRealEndpage() {
      return this.$store.getters.getPageInfo.realEndPage;
    },
  },
};
</script>

<style></style>
