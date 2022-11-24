<template>
  <div>
    <div ref="editor"></div>
  </div>
</template>

<script>
import "@toast-ui/editor/dist/toastui-editor.css";
import Editor from "@toast-ui/editor";
import axios from "axios";
// import axios from "axios";
export default {
  data() {
    return {
      editor: {},
    };
  },
  mounted() {
    this.setEditor();
  },
  computed: {
    changeEditer() {
      return this.$emit("getEditerHTML", this.editor.getHTML());
    },
  },
  methods: {
    setEditor() {
      this.editor = new Editor({
        el: this.$refs.editor,
        initialEditType: "markdown",
        language: "ko",
        hooks: {
          addImageBlobHook: this.addImageBlobHook,
        },
      });
    },
    async addImageBlobHook(file, setText) {
      try {
        if (!file) return false;

        // 이미지 제외 막기 처리하기
        if (file && file.size > 5242880) {
          const size = (file.size / (1000 * 1000)).toFixed(1);
          alert(
            `최대 업로드 사이즈(5 MB)를 초과 하였습니다.\n현재 사이즈 ${size}MB`
          );

          return false;
        }
        // api 업로드 만들기
        const formData = new FormData();
        formData.append("file", file);

        //첨부된 이미지를 화면에 표시 (1 -> 경로?, 2 -> 이미지 alt)
        axios
          .post("/imageUpload", formData, {
            headers: {
              "Content-Type": "multipart/form-data",
            },
          })
          .then((response) => {
            console.log(response.data);
            console.log(file.name);
            setText(response.data + "김");
          });
        // 요청 보내고
        // 해당 부분은 구현해야한다
        // const { data } = await api.uploadImageFile(formData);
        //  if (data.success === true) {
        //setText(data.file_path, "image");
        // }
      } catch (e) {
        alert("파일 업로드에 실패하였습니다");
      }
    },
  },
};
</script>

<style></style>
