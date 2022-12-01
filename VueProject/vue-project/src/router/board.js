import AllBoardView from "../views/Board/AllBoardView.vue";
import ShowBoardView from "../views/Board/ShowBoardView.vue";
import ManageBoardView from "../views/BoardAdmin/ManageBoardView.vue";
import AddBoardView from "../views/EditBoard/AddBoardView.vue";
import ModifyBoardView from "../views/EditBoard/ModifyBoardView.vue";
import DetailBoardView from "../views/Board/DetailBoardView.vue";

const board = [
  {
    path: "/showBoardView",
    name: "showBoardView",
    component: ShowBoardView,
  },
  {
    path: "/addBoardView",
    name: "addBoardView",
    component: AddBoardView,
  },
  {
    path: "/modifyBoardView",
    name: "modifyBoardView",
    component: ModifyBoardView,
    props: true,
  },
  {
    path: "/allBoardView",
    name: "allBoardView",
    component: AllBoardView,
  },
  {
    path: "/detailBoardView",
    name: "detailBoardView",
    component: DetailBoardView,
    props: true,
  },
  {
    path: "/manageBoardView",
    name: "manageBoardView",
    component: ManageBoardView,
  },
];

export default board;
