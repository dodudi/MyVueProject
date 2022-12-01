import Vue from "vue";
import VueRouter from "vue-router";

import mock from "./mock.js";
import board from "./board.js";
import user from "./user.js";
import chart from "./chart.js";
import menu from "../Menu.vue";
Vue.use(VueRouter);
console.log(mock);
console.log(process.env.BASE_URL);
const routes = [
  {
    path: "/",
    redirect: "menu/allBoardView",
  },
  {
    path: "/menu",
    name: "menuName",
    compontent: menu,
    children: [...mock, ...board, ...chart],
  },
  ...user,
];
console.log(routes);
const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
