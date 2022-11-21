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
      .get("/getShowBoards")
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
      this.$router.push({ name: "boarddetailvue" });
      console.log(value);
      console.log("nice" + value);
    },
  },
  data() {
    return {
      search: "",
      headers: [
        { text: "글 번호", value: "board_NUMBER" },
        { text: "글 제목", value: "board_TITLE" },
        { text: "글 작성자", value: "member_ID" },
        { text: "글 작성일", value: "board_DATE" },
        { text: "조회수", value: "board_READCOUNT" },
      ],
      boards: [],
    };
  },
};
</script>

<style></style>
