import Vue from "vue";
import VueRouter from "vue-router";

import BoardView from "../views/BoardView.vue";
import BoardDetail from "../views/BoardDetail.vue";
import LoginView from "../views/LoginView.vue";
import JoinView from "../views/JoinView.vue";
import BoardRezerveView from "../views/BoardRezerveView.vue";
import CheckRezerveVue from "../views/CheckRezerveVue.vue";
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
    props: true,
  },
  {
    path: "/checkrezervevue",
    name: "checkrezervevue",
    component: CheckRezerveVue,
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
  {
    path: "/boardRezerveView",
    name: "boardRezerveView",
    component: BoardRezerveView,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
