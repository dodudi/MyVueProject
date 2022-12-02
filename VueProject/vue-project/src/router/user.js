import LoginView from "../components/account/LoginView.vue";
import JoinView from "../components/account/JoinView.vue";

const user = [
  {
    path: "/account/loginView",
    name: "loginView",
    component: LoginView,
  },
  {
    path: "/account/joinView",
    name: "joinView",
    component: JoinView,
  },
];

export default user;
