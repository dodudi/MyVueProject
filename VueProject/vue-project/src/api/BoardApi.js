import axios from "axios";

//전체 게시글을 가져옵니다.
async function getBoards(pageInfo) {
  return await axios.post("/getBoards", pageInfo);
}

//관리자가 수락한 게시글을 가져옵니다.
async function getShowBoards(pageInfo) {
  return await axios.post("/getShowBoards", pageInfo);
}

//게시글을 추가합니다.
async function addBoard(board) {
  return await axios.post("addBoard", board);
}

//게시글을 삭제합니다.
async function delBoard(board) {
  return await axios.post("/delBoard", board);
}
export { getBoards, getShowBoards, addBoard, delBoard };
