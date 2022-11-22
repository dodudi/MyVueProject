<template>
  <v-card>
    <v-card-title>
      게시판
      <v-spacer></v-spacer>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table
      :headers="headers"
      :items="boards"
      :search="search"
      @click:row="clickEvents"
    >
    </v-data-table>
  </v-card>
</template>

<script>
import axios from "axios";
export default {
  created() {
    axios
      .get("/getBoards")
      .then((response) => {
        this.boards = response.data;
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
    clickEvents(value) {
      this.$router.push({ name: "boarddetailvue", params: value });
      console.log(value);
      console.log("nice" + value);
    },
  },
  data() {
    return {
      search: "",
      headers: [
        { text: "글 번호", value: "boardNUMBER" },
        { text: "글 제목", value: "boardTITLE" },
        { text: "글 작성자", value: "memberID" },
        { text: "글 작성일", value: "boardDATE" },
        { text: "조회수", value: "boardReadCount" },
      ],
      boards: [],
    };
  },
};
</script>

<style></style>
