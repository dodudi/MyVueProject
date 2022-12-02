import Vue from "vue";
import VueRouter from "vue-router";

import mock from "./mock.js";
import board from "./board.js";
import user from "./user.js";
import chart from "./chart.js";
import MenuView from "../views/MenuView.vue";
import UserAccountView from "../views/UserAccountView.vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    redirect: "menu/allBoardView",
  },
  {
    path: "/menu",
    name: "menuName",
    component: MenuView,
    children: [...mock, ...board, ...chart],
  },
  {
    path: "/account",
    name: "accountView",
    component: UserAccountView,
    children: [...user],
  },
];
const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
