<template>
  <v-row align="center" justify="space-around">
    <v-btn depressed @click="addUserMock"> user_mock </v-btn>
    <v-btn depressed color="primary"> Primary </v-btn>
    <v-btn depressed color="error"> Error </v-btn>
    <v-btn depressed disabled> Disabled </v-btn>
  </v-row>
</template>

<script>
import getUserMock from "../Mock/user_mock.json";
import axios from "axios";
export default {
  data() {
    return {
      userMock: getUserMock,
    };
  },
  methods: {
    addUserMock() {
      axios
        .post("/addUserMock", this.userMock)
        .then((response) => {
          console.assert(
            response.data == -1,
            "User Mock 데이터 추가에 실패했습니다."
          );
        })
        .catch((error) => console.log(error));
    },
  },
};
</script>

<style></style>
