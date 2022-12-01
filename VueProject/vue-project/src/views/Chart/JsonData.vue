<template>
  <LineChart :datasetIdKey="datasetIdKey" :chartData="chartData" />
</template>

<script>
import LineChart from "./LineChart.vue";
import jsonTest from "./jsonTest.json";
export default {
  components: {
    LineChart,
  },
  data() {
    return {
      maxCount: 10,
      jsonData: jsonTest,
      datasetIdKey: "add_date",
      chartData: {
        labels: [],
        datasets: [
          {
            label: "count",
            backgroundColor: "#f87979",
            data: [],
          },
        ],
      },
    };
  },
  created() {
    console.log(this.maxCount);
    console.log("Json Data 가공시작");
    this.chartData.labels = this.getLabels(this.jsonData);
    this.chartData.datasets = [
      {
        label: "count",
        backgroundColor: "#f87979",
        data: this.getCount(this.jsonData),
      },
    ];
    console.log(this.chartData);
    this.$store.commit("SET_CHART_DATA", this.chartData);
  },
  methods: {
    getLabels(jsonData) {
      const addDate = [];

      for (let i = 0; i < jsonData.length; i++) {
        let index = addDate.indexOf(jsonData[i].add_date);
        if (index == -1) {
          addDate.push(jsonData[i].add_date);
        }
      }
      console.log(addDate);
      console.log(jsonData[0].add_date);
      console.log(new Date(jsonData[0].add_date));
      //addDate.splice(this.maxCount, addDate.length);
      return addDate.sort((a, b) => {
        console.log(a.add_date);
        return new Date(a.add_date) - new Date(b.add_date);
      });
    },
    getCount(jsonData) {
      const addDate = this.getLabels(jsonData);
      const count = [];
      for (let i = 0; i < addDate.length; i++) {
        count.push(0);
      }

      for (let i = 0; i < this.maxCount; i++) {
        for (let j = 0; j < Object.keys(jsonData).length; j++) {
          if (addDate[i] === jsonData[j].add_date) {
            count[i]++;
            jsonData.splice(j, 1);
            j--;
          }
        }
      }
      return count;
    },
  },
};
</script>

<style></style>
