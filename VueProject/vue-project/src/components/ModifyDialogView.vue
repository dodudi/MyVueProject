<template>
  <v-dialog v-bind:value="getDialog" max-width="500px">
    <template v-slot:activator="{ on, attrs }">
      <v-btn color="primary" dark class="mb-2 ml-5" v-bind="attrs" v-on="on">
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
                v-model="boardTitle"
                label="board_TITLE"
              ></v-text-field>
            </v-col>
            <v-col cols="12" sm="6" md="12">
              <v-textarea
                name="input-7-1"
                label="board_CONTENT"
                v-model="boardContent"
                hint="Hint text"
              ></v-textarea>
            </v-col>
          </v-row>
        </v-container>
      </v-card-text>

      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue darken-1" text @click="close"> Cancel </v-btn>
        <v-btn color="blue darken-1" text @click="save"> Save </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import { formatDate } from "../api/FormatDate.js";
import { save, close } from "../api/DialogApi.js";
export default {
  data() {
    return {
      boardTitle: "",
      boardContent: "",
    };
  },
  computed: {
    getDefaultItem() {
      return this.$store.getters.getDefaultItem;
    },
    getEditedItem() {
      return this.$store.getters.getEditedItem;
    },
    getDialog() {
      return this.$store.getters.getDialog;
    },
    formTitle() {
      return this.editedIndex === -1 ? "New Item" : "Edit Item";
    },
  },
  methods: {
    filters() {
      return formatDate();
    },
    close() {
      close();
      // this.$store.commit("SET_DIALOG", false);
      // this.$nextTick(() => {
      //   this.$store.commit(
      //     "SET_EDITED_ITEM",
      //     Object.assign({}, this.getDefaultItem)
      //   );
      //   this.$store.commit("SET_EDITED_INDEX", -1);
      // });
    },
    //아이템 추가 or 설정 저장
    async save(boardTitle, boardContent) {
      save(boardTitle, boardContent);
      // if (this.editedIndex > -1) {
      //   //modify
      //   Object.assign(this.boards[this.editedIndex], this.editedItem);
      // } else {
      //   //add
      //   let editiedItem = this.$store.getters.getEditedItem;
      //   editiedItem.board_DATE = this.filters();
      //   editiedItem.board_NUMBER = this.$store.getters.getBoards.length + 1;
      //   addBoard(editiedItem)
      //     .then((response) => {
      //       console.log(response.data.boards);
      //       this.$store.commit("SET_BOARDS", response.data.boards);
      //       this.close();
      //     })
      //     .catch((error) => {
      //       console.log(error);
      //       alert("게시글 추가에 실패했습니다.");
      //     });
      // }
    },
  },
};
</script>

<style></style>
