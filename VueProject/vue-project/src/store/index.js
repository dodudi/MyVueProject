import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    chartData: {},
    tableHeaders: [
      { text: "글 번호", value: "boardNumber" },
      { text: "글 제목", value: "boardTitle" },
      { text: "글 작성자", value: "memberId" },
      { text: "글 작성일", value: "boardDate" },
      { text: "조회수", value: "boardReadCount" },
      { text: "예약상태", value: "boardRezerveCheck" },
    ],
    tableLoading: true,
    pageInfo: { pageNum: 1 },
    boards: [],
  },
  getters: {
    //Test Chart
    getChartData(state) {
      return state.chartData;
    },
    getTableHeaders(state) {
      return state.tableHeaders;
    },
    getTableLoading(state) {
      return state.tableLoading;
    },
    getDeleteDialog(state) {
      return state.dialogDelete;
    },
    getBoards(state) {
      return state.boards;
    },
    getPageInfo(state) {
      return state.pageInfo;
    },
  },
  mutations: {
    SET_CHART_DATA(state, value) {
      state.chartData = value;
    },
    SET_TABLE_LOADING(state, value) {
      state.tableLoading = value;
    },
    SET_DELETE_DIALOG(state, value) {
      state.dialogDelete = value;
    },
    SET_PAGE_INFO(state, value) {
      state.pageInfo = value;
    },
    SET_BOARDS(state, value) {
      state.boards = value;
    },
  },
  actions: {
    changeDeleteDialog({ commit }, { value }) {
      commit("SET_DELETE_DIALOG", value);
    },
    async pageLoad({ commit }, data) {
      commit("SET_TABLE_LOADING", true);
      await axios
        .post(data, this.getters.getPageInfo)
        .then((response) => {
          commit("SET_PAGE_INFO", response.data.pageInfo);
          commit("SET_BOARDS", response.data.boards);
          commit("SET_TABLE_LOADING", false);
        })
        .catch((error) => {
          console.log("Store PageLoad에서 Error : " + error);
        });
    },
  },
  modules: {},
});
