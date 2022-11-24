<template>
  <div>
    <v-data-table
      :headers="headers"
      :items="boards"
      :page.sync="pageInfo.pageNum"
      :items-per-page="pageInfo.itemLimit"
      hide-default-footer
      class="elevation-1"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>My CRUD</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <v-btn color="primary" dark @click.stop="dialogInfo.dialog = true">
            Add Item
          </v-btn>
          <v-dialog v-model="dialogInfo.dialog" max-width="290">
            <v-card>
              <v-card-title>
                <span class="text-h5">d</span>
              </v-card-title>

              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="12" sm="6" md="6">
                      <v-text-field
                        v-model="editedItem.boardTitle"
                        label="Board Title"
                      ></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="6">
                      <v-text-field
                        v-model="editedItem.boardContent"
                        label="Board Content"
                      ></v-text-field>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>

              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  color="blue darken-1"
                  text
                  @click.stop="dialogInfo.dialog = false"
                >
                  Cancel
                </v-btn>
                <v-btn
                  color="blue darken-1"
                  text
                  @click.stop="dialogInfo.dialog = false"
                >
                  Save
                </v-btn>
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
      editedItem: {
        boardNumber: 0,
        boardTitle: "",
        boardContent: "",
        memberId: "",
        boardDate: "",
        boardReadCount: "",
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
      ],
      boards: [],
    };
  },
  methods: {
    pageLoad() {
      axios
        .post("getShowBoards", this.pageInfo)
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
