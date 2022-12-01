import AllBoardView from "../views/Board/AllBoardView.vue";
import ShowBoardView from "../views/Board/ShowBoardView.vue";
import ManageBoardView from "../views/BoardAdmin/ManageBoardView.vue";
import AddBoardView from "../views/EditBoard/AddBoardView.vue";
import ModifyBoardView from "../views/EditBoard/ModifyBoardView.vue";
import DetailBoardView from "../views/Board/DetailBoardView.vue";

const board = [
  {
    path: "/menu/showBoardView",
    name: "showBoardView",
    component: ShowBoardView,
  },
  {
    path: "/menu/addBoardView",
    name: "addBoardView",
    component: AddBoardView,
  },
  {
    path: "/menu/modifyBoardView",
    name: "modifyBoardView",
    component: ModifyBoardView,
    props: true,
  },
  {
    path: "/menu/allBoardView",
    name: "allBoardView",
    component: AllBoardView,
  },
  {
    path: "/menu/detailBoardView",
    name: "detailBoardView",
    component: DetailBoardView,
    props: true,
  },
  {
    path: "/menu/manageBoardView",
    name: "manageBoardView",
    component: ManageBoardView,
  },
];

export default board;
