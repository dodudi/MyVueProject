//시작페이지번호, 끝페이지번호, 총 끝 페이지번호
let startPage;
let endPage;
let realEndPage;

//페이지에 대한 아이템 시작번호, 끝번호
let itemStart;
let itemEnd;

//페이징 다음, 이전 버튼 출력 여부
let next, prev;

function paging(total, pageLimit, pageInfo) {
  let pageNum = pageInfo.pageNum;
  let itemLimit = pageInfo.itemLimit;

  realEndPage = Math.ceil((total * 1.0) / itemLimit);
  endPage = Math.ceil((pageNum * 1.0) / pageLimit) * pageLimit;
  startPage = endPage - pageLimit + 1;

  if (endPage > realEndPage) endPage = realEndPage;

  itemEnd = pageNum * itemLimit;
  itemStart = itemEnd - itemLimit + 1;

  return { startPage, endPage, realEndPage, itemStart, itemEnd, next, prev };
}

function getDefaultPageInfo() {
  return { pageNum: 1, itemLimit: 10 };
}

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

export { paging, getHeader, getBody, getDefaultPageInfo };
