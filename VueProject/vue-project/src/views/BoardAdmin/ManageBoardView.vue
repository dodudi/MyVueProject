<template>
  <div>
    <v-data-table
      v-model="selected"
      :headers="headers"
      :items="boards"
      :page.sync="pageInfo.pageNum"
      :items-per-page="pageInfo.itemLimit"
      hide-default-footer
      item-key="boardNumber"
      show-select
      class="elevation-1"
      @click:row="goBoardDetail"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>게시판 관리하기</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <v-btn color="primary" dark class="mr-5" @click="acceptDialog = true">
            Accept Selected Board
          </v-btn>
          <v-btn color="primary" dark @click="deleteDialog = true">
            Delete Selected
          </v-btn>
          <!-- 삭제 dialog-->
          <v-dialog v-model="deleteDialog" max-width="500px">
            <v-card>
              <v-card-title class="text-h5"
                >Are you sure you want to delete this item?</v-card-title
              >
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="deleteDialog = false"
                  >Cancel</v-btn
                >
                <v-btn color="blue darken-1" text @click="goDelete">OK</v-btn>
                <v-spacer></v-spacer>
              </v-card-actions>
            </v-card>
          </v-dialog>
          <!-- 게시글 허용 Dialog-->
          <v-dialog v-model="acceptDialog" max-width="500px">
            <v-card>
              <v-card-title class="text-h5"
                >Are you sure you want to delete this item?</v-card-title
              >
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="acceptDialog = false"
                  >Cancel</v-btn
                >
                <v-btn color="blue darken-1" text @click="goAccept">OK</v-btn>
                <v-spacer></v-spacer>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-toolbar>
      </template>
    </v-data-table>
    <div class="text-center pt-2">
      <v-pagination
        v-model="pageNum"
        :length="pageInfo.realEndPage"
        :total-visible="7"
      ></v-pagination>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  created() {
    this.pageInfo.pageNum = this.pageNum;
    this.pageLoad();
  },
  watch: {
    pageNum: {
      handler() {
        this.pageInfo.pageNum = this.pageNum;
        this.pageLoad();
      },
    },
  },
  data() {
    return {
      //CheckList
      selected: [],
      singleSelect: false,
      //Delete Dialog Open or Close
      deleteDialog: false,
      acceptDialog: false,
      editedItem: {
        boardNumber: 0,
        boardTitle: "",
        boardContent: "",
        memberId: "",
        boardDate: "",
        boardReadCount: "",
        boardRezerveCheck: 0,
      },
      dialogInfo: {
        dialog: false,
      },
      pageNum: 1,
      pageInfo: {},
      headers: [
        { text: "글 번호", value: "boardNumber" },
        { text: "글 제목", value: "boardTitle" },
        { text: "글 작성자", value: "memberId" },
        { text: "글 작성일", value: "boardDate" },
        { text: "조회수", value: "boardReadCount" },
        { text: "예약상태", value: "boardRezerveCheck" },
      ],
      boards: [],
    };
  },
  methods: {
    goAccept() {
      axios
        .post("/acceptSelectedBoard", this.selected)
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    goDelete() {
      axios
        .post("/delSelectedBoard", this.selected)
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    goBoardDetail(item) {
      this.$router.push({ name: "detailBoardView", params: { board: item } });
    },
    pageLoad() {
      axios
        .post("getBoards", this.pageInfo)
        .then((response) => {
          console.log(response.data.boards);
          console.log(response.data.pageInfo);
          this.boards = response.data.boards;
          this.pageInfo = response.data.pageInfo;
        })
        .catch((error) => console.log(error));
    },
  },
};
</script>

<style></style>
