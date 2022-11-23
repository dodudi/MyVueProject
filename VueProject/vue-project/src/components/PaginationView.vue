<template>
  <div class="text-center pt-2">
    <v-pagination
      v-model="getPageInfo.pageNum"
      :length="getPageCalc.realEndPage"
      :total-visible="7"
    ></v-pagination>
  </div>
</template>

<script>
import { getBoards } from "../api/BoardApi.js";
import { getDefaultPageInfo } from "../api/PageCalc.js";
export default {
  watch: {
    getPageInfo: {
      handler() {
        this.pageLoad();
      },
      deep: true,
    },
  },
  created() {
    this.initialize();
  },
  computed: {
    getPageInfo() {
      return this.$store.getters.getPageInfo;
    },
    getPageCalc() {
      return this.$store.getters.getPageCalc;
    },
  },
  methods: {
    initialize() {
      this.$store.commit("SET_PAGE_INFO", getDefaultPageInfo());
      this.pageLoad();
    },
    pageLoad() {
      getBoards(this.getPageInfo)
        .then((response) => {
          console.log(response.data);
          this.$store.commit("SET_BOARDS", response.data.boards);
          this.$store.commit("SET_PAGE_CALC", response.data.pageCalc);
          this.$store.commit("SET_PAGE_INFO", this.getPageInfo);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style></style>
