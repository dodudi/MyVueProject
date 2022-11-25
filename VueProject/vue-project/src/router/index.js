import Vue from "vue";
import VueRouter from "vue-router";

import LoginView from "../views/LoginView.vue";
import JoinView from "../views/JoinView.vue";
import AllBoardView from "../views/Board/AllBoardView.vue";
import ShowBoardView from "../views/Board/ShowBoardView.vue";
import ManageBoardView from "../views/BoardAdmin/ManageBoardView.vue";
import AddBoardView from "../views/Board/AddBoardView.vue";
import ModifyBoardView from "../views/Board/ModifyBoardView.vue";
import DetailBoardView from "../views/Board/DetailBoardView.vue";
Vue.use(VueRouter);

const routes = [
  //Board
  {
    path: "/",
    redirect: "allBoardView",
  },
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
  //Login, Join
  {
    path: "/loginView",
    name: "loginView",
    component: LoginView,
  },
  {
    path: "/joinView",
    name: "joinView",
    component: JoinView,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
