import Vue from "vue";
import VueRouter from "vue-router";

import BoardView from "../views/BoardView.vue";
import BoardDetail from "../views/BoardDetail.vue";
import LoginView from "../views/LoginView.vue";
import JoinView from "../views/JoinView.vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    redirect: "boardvue",
  },
  {
    path: "/boardvue",
    name: "boardvue",
    component: BoardView,
  },
  {
    path: "/boarddetailvue",
    name: "boarddetailvue",
    component: BoardDetail,
  },
  {
    path: "/checkrezervevue",
    name: "checkrezervevue",
    component: BoardDetail,
  },
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
