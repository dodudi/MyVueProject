<template>
  <div>
    <JsonData />
    <BarChart />
    <!-- //<LineChart /> -->
  </div>
</template>

<script>
import BarChart from "./BarChart.vue";
import JsonData from "./JsonData.vue";
export default {
  name: "App",
  components: {
    BarChart,
    JsonData,
  },
};
</script>
