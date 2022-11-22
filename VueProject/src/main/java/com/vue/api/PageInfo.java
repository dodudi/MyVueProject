package com.vue.api;


public class PageInfo {
	//현재 페이지 번호
	private int pageNum;
	//보여줄 아이템 제한
	private int itemLimit;
	
	public PageInfo() {
		this(1, 10);
	}
	
	public PageInfo(int pageNum, int itemLimit) {
		this.pageNum = pageNum;
		this.itemLimit = itemLimit;
	}

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getItemLimit() {
		return itemLimit;
	}
	public void setItemLimit(int itemLimit) {
		this.itemLimit = itemLimit;
	}

	@Override
	public String toString() {
		return "PageInfo [pageNum=" + pageNum + ", itemLimit=" + itemLimit + "]";
	}
}
