const { defineConfig } = require("@vue/cli-service");
//const path = require("path");
module.exports = defineConfig({
  transpileDependencies: ["vuetify"],
  // indexPath: "../../templates/index.ftlh", // index.ftlh 만들어지는 위치
  // outputDir: path.resolve(__dirname, "../resources/static/dist"), // vue project 빌드 경로
  devServer: {
    port: 8080,
    proxy: "http://localhost:9000",
    //disableHostCheck: true,
  },
});
