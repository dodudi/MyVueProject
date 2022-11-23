function getDefaultPageInfo() {
  return { pageNum: 1, itemLimit: 10 };
}

//데이터 테이블 Header 컬럼 설정
function getHeader() {
  return [
    { text: "글 번호", value: "boardNumber" },
    { text: "글 제목", value: "boardTitle" },
    { text: "글 작성자", value: "memberId" },
    { text: "글 작성일", value: "boardDate" },
    { text: "조회수", value: "boardReadCount" },
    { text: "Actions", value: "actions", sortable: false },
  ];
}

//데이터 테이블 기본값 설정
function getBody() {
  return {
    boardNumber: 0,
    boardTitle: "",
    boardContent: "",
    boardDate: "",
    boardReadCount: 0,
    boardRezerveCheck: 0,
    memberId: "",
  };
}

export { getHeader, getBody, getDefaultPageInfo };
