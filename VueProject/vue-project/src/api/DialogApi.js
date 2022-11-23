import { addBoard, delBoard, getBoards } from "./BoardApi.js";
import { formatDate } from "../api/FormatDate.js";
import store from "../store";
import Vue from "vue";
//추가, 수정 다이얼로그 열기
function editItem(item) {
  store.commit("SET_EDITED_INDEX", this.boards.indexOf(item));
  store.commit("SET_EDITED_ITEM", Object.assign({}, item));
  store.commit("SET_DIALOG", true);
}

//수정, 추가 다이얼로그 닫기
function close() {
  store.commit("SET_DIALOG", false);
  Vue.nextTick(() => {
    store.commit(
      "SET_EDITED_ITEM",
      Object.assign({}, store.getters.getDefaultItem)
    );
    store.commit("SET_EDITED_INDEX", -1);
  });
}

//수정, 추가 다이얼로그 저장
async function save(boardTitle, boardContent) {
  if (store.getters.getEditedIndex > -1) {
    //modify
    Object.assign(
      this.boards[store.getters.getEditedIndex],
      store.getters.getEditedItem
    );
  } else {
    //add
    let boards = store.getters.getBoards;
    let editiedItem = store.getters.getEditedItem;
    editiedItem.boardTitle = boardTitle;
    editiedItem.boardContent = boardContent;
    editiedItem.boardDate = formatDate();
    editiedItem.boardNumber = boards.length + 1;
    console.log(editiedItem);
    addBoard(editiedItem)
      .then((response) => {
        console.log(response.data);
        boards = boards.push(editiedItem);
        store.commit("SET_BOARDS", boards);
        close();
      })
      .catch((error) => {
        console.log(error);
        alert("게시글 추가에 실패했습니다.");
      });
  }
}

//삭제 다이얼로그 열기
function deleteItem(item) {
  store.commit("SET_EDITED_INDEX", this.boards.indexOf(item));
  store.commit("SET_EDITED_ITEM", Object.assign({}, item));
  store.commit("SET_DELETE_DIALOG", true);
}

//삭제 다이얼로그 종료
function closeDelete() {
  store.commit("SET_DELETE_DIALOG", false);
  Vue.nextTick(() => {
    store.commit(
      "SET_DEFAULT_ITEM",
      Object.assign({}, store.getters.getDefaultIte)
    );
    store.commit("SET_EDITED_INDEX", Object.assign({}, -1));
  });
}

//삭제 다이얼로그 삭제
function deleteItemConfirm() {
  delBoard(store.getters.getEditedItem)
    .then((response) => {
      if (response.data == 1) {
        getBoards(store.getters.getPageInfo)
          .then((response) => {
            console.log(response.data);
            store.commit("SET_BOARDS", response.data.boards);
            store.commit("SET_PAGE_CALC", response.data.pageCalc);
          })
          .catch((error) => {
            console.log(error);
          });
      }
      closeDelete();
    })
    .catch((error) => {
      console.log(error);
    });
}

export { save, close, deleteItemConfirm, closeDelete, editItem, deleteItem };
