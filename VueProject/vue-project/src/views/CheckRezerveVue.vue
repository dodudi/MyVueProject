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
          <v-toolbar-title>{{ pageInfo.pageNum }}</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <!--Add Item Dialog-->
          <v-dialog v-model="dialog" max-width="500px">
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                color="primary"
                dark
                class="mb-2 ml-5"
                v-bind="attrs"
                v-on="on"
              >
                Delete Select
              </v-btn>
              <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">
                New Item
              </v-btn>
            </template>
            <v-card>
              <v-card-title>
                <span class="text-h5">{{ formTitle }}</span>
              </v-card-title>

              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="12" sm="6" md="12">
                      <v-text-field
                        v-model="editedItem.board_TITLE"
                        label="board_TITLE"
                      ></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="12">
                      <v-textarea
                        name="input-7-1"
                        label="board_CONTENT"
                        v-model="editedItem.board_CONTENT"
                        hint="Hint text"
                      ></v-textarea>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>

              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="close">
                  Cancel
                </v-btn>
                <v-btn color="blue darken-1" text @click="save"> Save </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
          <!--End Add Item Dialog-->

          <!--Remove Item Dialog-->
          <v-dialog v-model="dialogDelete" max-width="500px">
            <v-card>
              <v-card-title class="text-h5"
                >Are you sure you want to delete this item?</v-card-title
              >
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="closeDelete"
                  >Cancel</v-btn
                >
                <v-btn color="blue darken-1" text @click="deleteItemConfirm"
                  >OK</v-btn
                >
                <v-spacer></v-spacer>
              </v-card-actions>
            </v-card>
          </v-dialog>
          <!--End Remove Item Dialog-->
        </v-toolbar>
      </template>
      <template v-slot:[`item.actions`]="{ item }">
        <v-icon small class="mr-2" @click="editItem(item)"> mdi-pencil </v-icon>
        <v-icon small @click="deleteItem(item)"> mdi-delete </v-icon>
      </template>
      <template v-slot:no-data>
        <v-btn color="primary" @click="initialize"> Reset </v-btn>
      </template>
    </v-data-table>

    <div class="text-center pt-2">
      <v-pagination
        v-model="pageInfo.pageNum"
        :length="pageCalc.realEndPage"
        :total-visible="7"
      ></v-pagination>
    </div>
  </div>
</template>

<script>
import { getBoards, addBoard, delBoard } from "../api/BoardApi.js";
import {
  paging,
  getHeader,
  getBody,
  getDefaultPageInfo,
} from "../api/PageCalc.js";
import { formatDate } from "../api/FormatDate.js";
export default {
  data() {
    return {
      pageInfo: {},
      pageCalc: {},
      headers: [],
      boards: [],
      editedItem: {},
      defaultItem: {},
      selected: [],
      loginDialog: false,
      dialog: false,
      dialogDelete: false,
      editedIndex: -1,
    };
  },
  computed: {
    formTitle() {
      return this.editedIndex === -1 ? "New Item" : "Edit Item";
    },
  },
  watch: {
    pageInfo: {
      handler() {
        getBoards(this.pageInfo)
          .then((response) => {
            this.pageCalc = paging(101, 10, this.pageInfo);
            console.log(response.data);
            this.boards = response.data;
            this.defaultItem.member_ID = sessionStorage.getItem("member_ID");
            console.log(this.boards);
          })
          .catch((error) => {
            console.log(error);
          });
      },
      deep: true,
    },
    dialog(val) {
      val || this.close();
    },
    dialogDelete(val) {
      val || this.closeDelete();
    },
  },

  created() {
    this.initialize();
  },
  methods: {
    filters() {
      return formatDate();
    },
    paging() {
      this.pageCalc = this.paging(101, 10, this.pageInfo);
    },
    initialize() {
      this.pageInfo = getDefaultPageInfo();
      this.headers = getHeader();
      this.editedItem = getBody();
      this.defaultItem = getBody();
      this.pageCalc = paging(101, 10, this.pageInfo);
      console.log(this.pageInfo.pageNum);
      getBoards(this.pageInfo)
        .then((response) => {
          console.log(response.data);
          this.boards = response.data;
          this.defaultItem.member_ID = sessionStorage.getItem("member_ID");
          console.log(this.boards);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    //add, mod dialog 열기
    editItem(item) {
      if (
        this.defaultItem.member_ID != null &&
        this.defaultItem.member_ID == item.member_ID
      ) {
        this.editedIndex = this.boards.indexOf(item);
        this.editedItem = Object.assign({}, item);
        this.dialog = true;
      }
    },
    //delete dialog 열기
    deleteItem(item) {
      if (
        this.defaultItem.member_ID != null &&
        this.defaultItem.member_ID == item.member_ID
      ) {
        this.editedIndex = this.boards.indexOf(item);
        this.editedItem = Object.assign({}, item);
        this.dialogDelete = true;
      }
    },
    //아이템 삭제
    deleteItemConfirm() {
      delBoard(this.editedItem)
        .then((response) => {
          console.log(response.data);
          this.boards = response.data;
          this.boards.splice(this.editedIndex, 1);
          this.closeDelete();
        })
        .catch((error) => {
          console.log(error);
        });
    },

    close() {
      this.dialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    closeDelete() {
      this.dialogDelete = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },
    //아이템 추가 or 설정 저장
    async save() {
      if (this.editedIndex > -1) {
        //modify
        Object.assign(this.boards[this.editedIndex], this.editedItem);
      } else {
        //add
        this.editedItem.board_DATE = this.filters();
        this.editedItem.board_NUMBER = this.boards.length + 1;
        addBoard(this.editedItem)
          .then((response) => {
            console.log(response.data);
            this.boards = response.data;
            this.close();
          })
          .catch((error) => {
            console.log(error);
            alert("게시글 추가에 실패했습니다.");
          });
      }
    },
  },
};
</script>
