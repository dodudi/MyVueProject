import LoginView from "../views/LoginView.vue";
import JoinView from "../views/JoinView.vue";

const user = [
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

export default user;
