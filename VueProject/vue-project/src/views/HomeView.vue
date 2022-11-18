<template>
  <hello-world />
</template>

<script>
import HelloWorld from "../components/HelloWorld";
export default {
  name: "HomeVue",
  created() {
    this.$axios
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
