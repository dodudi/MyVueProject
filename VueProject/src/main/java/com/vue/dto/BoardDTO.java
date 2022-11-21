package com.vue.dto;

public class BoardDTO {
	private int BOARD_NUMBER;
	private String BOARD_TITLE;
	private String BOARD_CONTENT;
	private String BOARD_DATE;
	private int BOARD_READCOUNT;
	private String BOARD_REZERVE_CHECK;
	private String MEMBER_ID;
	
	public int getBOARD_NUMBER() {
		return BOARD_NUMBER;
	}
	public void setBOARD_NUMBER(int bOARD_NUMBER) {
		BOARD_NUMBER = bOARD_NUMBER;
	}
	public String getBOARD_TITLE() {
		return BOARD_TITLE;
	}
	public void setBOARD_TITLE(String bOARD_TITLE) {
		BOARD_TITLE = bOARD_TITLE;
	}
	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}
	public void setBOARD_CONTENT(String bOARD_CONTENT) {
		BOARD_CONTENT = bOARD_CONTENT;
	}
	public String getBOARD_DATE() {
		return BOARD_DATE;
	}
	public void setBOARD_DATE(String bOARD_DATE) {
		BOARD_DATE = bOARD_DATE;
	}
	public int getBOARD_READCOUNT() {
		return BOARD_READCOUNT;
	}
	public void setBOARD_READCOUNT(int bOARD_READCOUNT) {
		BOARD_READCOUNT = bOARD_READCOUNT;
	}
	public String getBOARD_REZERVE_CHECK() {
		return BOARD_REZERVE_CHECK;
	}
	public void setBOARD_REZERVE_CHECK(String bOARD_REZERVE_CHECK) {
		BOARD_REZERVE_CHECK = bOARD_REZERVE_CHECK;
	}
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}
	
}
