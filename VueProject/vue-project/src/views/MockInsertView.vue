<template>
  <v-row align="center" justify="space-around">
    <v-btn depressed @click="addUserMock"> user_mock </v-btn>
    <v-btn depressed @click="addProductMock"> product_mock </v-btn>
  </v-row>
</template>

<script>
import getUserMock from "../Mock/user_mock.json";
import getProductMock from "../Mock/product_mock.json";
import axios from "axios";
export default {
  data() {
    return {
      userMock: getUserMock,
      productMock: getProductMock,
    };
  },
  methods: {
    addUserMock() {
      axios
        .post("/addUserMock", this.userMock)
        .then((response) => {
          console.assert(
            response.data != -1,
            "User Mock 데이터 추가에 실패했습니다."
          );
        })
        .catch((error) => console.log(error));
    },
    addProductMock() {
      axios
        .post("/addProductMock", this.productMock)
        .then((response) => {
          console.assert(
            response.data != -1,
            "Product Mock 데이터 추가에 실패했습니다."
          );
        })
        .catch((error) => console.log(error));
    },
  },
};
</script>

<style></style>
