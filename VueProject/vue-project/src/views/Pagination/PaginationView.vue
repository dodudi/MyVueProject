<template>
  <div class="text-center pt-2">
    <v-pagination
      v-model="pageNum"
      :length="pageInfo.realEndPage"
      :total-visible="7"
    ></v-pagination>
  </div>
</template>

<script>
import axios from "axios";
import bus from "../EventBus/bus.js";
export default {
  created() {
    bus.$on("pageLoad", this.pageLoad);
    this.pageInfo.pageNum = this.pageNum;
    bus.$emit("pageLoad");
  },
  beforeDestroy() {
    bus.$off("pageLoad", this.pageLoad);
  },
  watch: {
    pageNum: {
      handler() {
        this.pageInfo.pageNum = this.pageNum;
        bus.$emit("pageLoad");
      },
    },
  },
  data() {
    return {
      pageNum: 1,
      pageInfo: {},
    };
  },
  methods: {
    pageLoad() {
      axios
        .post("getBoards", this.pageInfo)
        .then((response) => {
          this.$emit("getBoard", {
            boards: response.data.boards,
            pageInfo: response.data.pageInfo,
          });
          this.pageInfo = response.data.pageInfo;
        })
        .catch((error) => console.log(error));
    },
  },
};
</script>

<style></style>
