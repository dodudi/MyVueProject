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
      .get("https://jsonplaceholder.typicode.com/todos/1")
      .then((response) => {
        console.log(response);
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
        { text: "글 번호", value: "BOARD_NUMBER" },
        { text: "글 제목", value: "BOARD_TITLE" },
        { text: "글 작성자", value: "MEMBER_ID" },
        { text: "글 작성일", value: "BOARD_DATE" },
        { text: "조회수", value: "BOARD_READCOUNT" },
      ],
      boards: [
        {
          BOARD_NUMBER: 1,
          BOARD_TITLE: "Board Title 01",
          MEMBER_ID: "user01",
          BOARD_DATE: "2022-10-10",
          BOARD_READCOUNT: 0,
        },
        {
          BOARD_NUMBER: 2,
          BOARD_TITLE: "Board Title 02",
          MEMBER_ID: "user02",
          BOARD_DATE: "2022-10-10",
          BOARD_READCOUNT: 0,
        },
        {
          BOARD_NUMBER: 3,
          BOARD_TITLE: "Board Title 01",
          MEMBER_ID: "user01",
          BOARD_DATE: "2022-10-10",
          BOARD_READCOUNT: 0,
        },
        {
          BOARD_NUMBER: 4,
          BOARD_TITLE: "Board Title 01",
          MEMBER_ID: "user01",
          BOARD_DATE: "2022-10-10",
          BOARD_READCOUNT: 0,
        },
        {
          BOARD_NUMBER: 5,
          BOARD_TITLE: "Board Title 01",
          MEMBER_ID: "user01",
          BOARD_DATE: "2022-10-10",
          BOARD_READCOUNT: 0,
        },
      ],
    };
  },
};
</script>

<style></style>
