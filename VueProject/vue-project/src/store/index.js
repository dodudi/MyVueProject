import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    dialog: false,
    dialogDelete: false,
    editedItem: {},
    editedIndex: -1,
    defaultItem: {},
    boards: [],
    pageInfo: {},
    pageCalc: {},
  },
  getters: {
    getPageCalc(state) {
      return state.pageCalc;
    },
    getPageInfo(state) {
      return state.pageInfo;
    },
    getBoards(state) {
      return state.boards;
    },
    getEditedIndex(state) {
      return state.editedIndex;
    },
    getDefaultItem(state) {
      return state.defaultItem;
    },
    getEditedItem(state) {
      return state.editedItem;
    },
    getDialog(state) {
      return state.dialog;
    },
    getDeleteDialog(state) {
      return state.dialogDelete;
    },
  },
  mutations: {
    SET_PAGE_CALC(state, value) {
      state.pageCalc = value;
    },
    SET_PAGE_INFO(state, value) {
      state.pageInfo = value;
    },
    SET_BOARDS(state, value) {
      state.boards = value;
    },
    SET_EDITED_INDEX(state, value) {
      state.editedIndex = value;
    },
    SET_DEFAULT_ITEM(state, value) {
      state.defaultItem = value;
    },
    SET_EDITED_ITEM(state, value) {
      state.editedItem = value;
    },
    SET_DIALOG(state, value) {
      state.dialog = value;
    },
    SET_DELETE_DIALOG(state, value) {
      state.dialogDelete = value;
    },
  },
  actions: {
    changePageCalc({ commit }, { value }) {
      commit("SET_PAGE_CALC", value);
    },
    changePageInfo({ commit }, { value }) {
      commit("SET_PAGE_INFO", value);
    },
    changeBoards({ commit }, { value }) {
      commit("SET_BOARDS", value);
    },
    changeEdtiedIndex({ commit }, { value }) {
      commit("SET_EDITED_INDEX", value);
    },
    changeDefaultItem({ commit }, { value }) {
      commit("SET_DEFAULT_ITEM", value);
    },
    changeEditedItem({ commit }, { value }) {
      commit("SET_EDITED_ITEM", value);
    },
    changeDialog({ commit }, { value }) {
      commit("CHANGE_DIALOG", value);
    },
    changeDeleteDialog({ commit }, { value }) {
      commit("SET_DELETE_DIALOG", value);
    },
  },

  modules: {},
});
