<template>
  <div ref="viewer"></div>
</template>

<script>
import "@toast-ui/editor/dist/toastui-editor-viewer.css";
import Viewer from "@toast-ui/editor/dist/toastui-editor-viewer";
export default {
  props: ["boardContent"],
  data() {
    return {
      viewer: null,
    };
  },
  mounted() {
    this.getViewer();
    this.viewer.setMarkdown(this.boardContent);
  },
  methods: {
    getViewer() {
      this.viewer = new Viewer({
        el: this.$refs.viewer,
        initialEditType: "markdown",
        language: "ko",
      });
    },
  },
};
</script>

<style></style>
