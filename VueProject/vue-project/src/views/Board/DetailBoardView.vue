<template>
  <v-app>
    <v-main>
      <v-container style="width: 800px">
        <v-card>
          <v-responsive :aspect-ratio="16 / 9">
            <v-card-text>
              Board Number : {{ board.boardNumber }}
              <v-divider></v-divider>
              Board Title : {{ board.boardTitle }}
              <v-divider></v-divider>
              Member ID : {{ board.memberId || "null" }}
              <v-divider></v-divider>
              Board Date : {{ board.boardDate }}
              <v-divider></v-divider>
              Board ReadCount : {{ board.boardReadCount }}
              <v-divider class="mb-4"></v-divider>
              <viewer-editor-view
                :boardContent="board.boardContent"
              ></viewer-editor-view>
            </v-card-text>
          </v-responsive>
        </v-card>
        <v-row
          justify="end"
          class="mt-3"
          v-if="getId() === 'admin' || getId() === board.memberId"
        >
          <v-col cols="auto">
            <v-btn color="primary" dark @click="goModifyView">
              Modify Board
            </v-btn>
          </v-col>
          <v-col cols="auto">
            <v-btn color="error" dark @click="deleteDialog = true">
              Delete Board
            </v-btn>
          </v-col>
        </v-row>
        <v-dialog v-model="deleteDialog" max-width="500px">
          <!-- 삭제 dialog-->
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
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import ViewerEditorView from "../BoardToast/ViewerEditorView.vue";
import axios from "axios";
export default {
  data() {
    return {
      deleteDialog: false,
    };
  },
  props: ["board"],
  components: {
    ViewerEditorView,
  },
  watch: {
    sessionStorage: {
      handler() {
        console.log("로그아웃 된거같다");
      },
      deep: true,
    },
  },
  methods: {
    getId() {
      console.log(sessionStorage.getItem("memberId"));
      return sessionStorage.getItem("memberId");
    },
    goDelete() {
      axios
        .post("/delBoard", this.board)
        .then((response) => {
          console.log("삭제완료" + response);
          this.deleteDialog = false;
          this.$nextTick(function () {
            this.$router.push({ name: "allBoardView" });
          });
        })
        .catch((error) => {
          console.log("삭제에서 에러 발생ㅇㅇㅇㅇ" + error);
        });
      console.log("삭제");
    },
    goModifyView() {
      this.$router.push({
        name: "modifyBoardView",
        params: { board: this.board },
      });
    },
  },
};
</script>

<style></style>
