package com.vue.api;

import lombok.Data;

@Data
public class PageCalc {
	//시작페이지번호, 끝페이지번호, 총 끝 페이지번호
	private int startPage;
	private int endPage;
	private int realEndPage;
	
	//페이지에 대한 아이템 시작번호, 끝번호
	private int itemStart;
	private int itemEnd;
	
	//페이징 다음, 이전 버튼 출력 여부
	private boolean next,prev;
	
	//아이템총수, 페이지제한, 현재 페이지 정보
	private int total;
	private int pageLimit;
	private PageInfo pageInfo;
	
	
	public PageCalc(int total, int pageLimit, PageInfo pageInfo) {
		this.total = total;
		this.pageLimit = pageLimit;
		this.pageInfo = pageInfo;
		
		int pageNum = pageInfo.getPageNum();
		int itemLimit = pageInfo.getItemLimit();
		
		realEndPage = (int)Math.ceil((total*1.0)/itemLimit);
		endPage =(int)Math.ceil((pageNum * 1.0)/pageLimit) * pageLimit;
		startPage = (endPage - pageLimit) + 1;
		
		if(endPage > realEndPage)
			endPage = realEndPage;
		
		itemEnd = (pageNum*itemLimit);
		itemStart = itemEnd - itemLimit + 1;		
	}

	@Override
	public String toString() {
		return "PageCalc [startPage=" + startPage + ", endPage=" + endPage + ", realEndPage=" + realEndPage
				+ ", itemStart=" + itemStart + ", itemEnd=" + itemEnd + ", next=" + next + ", prev=" + prev + ", total="
				+ total + ", pageLimit=" + pageLimit + ", pageInfo=" + pageInfo + "]";
	}
	
	
}
