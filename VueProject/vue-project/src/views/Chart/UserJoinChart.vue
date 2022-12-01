<template>
  <line-chart :chartData="chartData"></line-chart>
</template>

<script>
import LineChart from "./LineChart.vue";
export default {
  components: {
    LineChart,
  },
  data() {
    return {
      chartData: {},
      tableHeader: [
        { text: "글 번호", value: "boardNumber" },
        { text: "글 제목", value: "boardTitle" },
        { text: "글 작성자", value: "memberId" },
        { text: "글 작성일", value: "boardDate" },
        { text: "조회수", value: "boardReadCount" },
        { text: "예약상태", value: "boardRezerveCheck" },
      ],
    };
  },
};
</script>

<style></style>
