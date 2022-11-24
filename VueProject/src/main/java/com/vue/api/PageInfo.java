package com.vue.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageInfo {
	private int pageNum;
	private int itemLimit;
	private int total;
	private int pageLimit;
	private int startPage;
	private int endPage;
	private int realEndPage;
	private int startItem;
	private int endItem;
	
	public PageInfo() {
		this(1, 10, 100, 10);
	}
	public PageInfo(int pageNum, int itemLimit, int total, int pageLimit) {
		this.pageNum = pageNum;
		this.itemLimit = itemLimit;
		this.total = total;
		this.pageLimit = pageLimit;
		pageCalculate();
	}
	@Override
	public String toString() {
		return "PageInfo [pageNum=" + pageNum + ", itemLimit=" + itemLimit + ", total=" + total + ", pageLimit="
				+ pageLimit + ", startPage=" + startPage + ", endPage=" + endPage + ", realEndPage=" + realEndPage
				+ ", startItem=" + startItem + ", endItem=" + endItem + "]";
	}
	
	public void pageCalculate() {
		realEndPage = (int)Math.ceil((total*1.0)/itemLimit);
		endPage =(int)Math.ceil((pageNum * 1.0)/pageLimit) * pageLimit;
		startPage = (endPage - pageLimit) + 1;
		
		if(endPage > realEndPage)
			endPage = realEndPage;
		
		endItem = (pageNum*itemLimit);
		startItem = endItem - itemLimit + 1;
	}
	
}
