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
<!-- 
CREATE TABLE TABLE_BOARD(
	BOARD_NUMBER INTEGER,
	BOARD_TITLE VARCHAR(1000),
	BOARD_CONTENT VARCHAR(3000),
	BOARD_DATE DATE DEFAULT NOW(),
	BOARD_READCOUNT INTEGER DEFAULT 0,
	BOARD_REZERVE_CHECK INTEGER DEFAULT 0,
	MEMBER_ID VARCHAR(1000)
);
insert into TABLE_BOARD VALUES(
	(select COALESCE(MAX(BOARD_NUMBER), 0)+1 from TABLE_BOARD),
	'TITLE',
	'CONTENT',
	NOW(),
	0
);
SELECT * FROM TABLE_BOARD;

drop table TABLE_BOARD;
select COALESCE(MAX(BOARD_NUMBER), 0)+1 from TABLE_BOARD;

select T1.* 
from (select ROW_NUMBER() OVER(ORDER BY board_number DESC) as row,* from TABLE_BOARD where BOARD_REZERVE_CHECK = 0 limit 100 ) AS T1 
where row > 3;
COMMIT;

select * from TABLE_BOARD; -->
