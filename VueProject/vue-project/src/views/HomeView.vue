<template>
  <hello-world />
</template>

<script>
import HelloWorld from "../components/HelloWorld";
import axios from "axios";
export default {
  name: "HomeVue",
  created() {
    axios
      .get("https://jsonplaceholder.typicode.com/todos/1")
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  },
  components: {
    HelloWorld,
  },
};
</script>
