package com.vue.dto;

//회원 정보
public class MemberDTO {
	private int MEMBER_NUMBER;
	private String MEMBER_ID;
	private String MEMBER_PASS;
	private String MEMBER_NAME;
	
	public int getMEMBER_NUMBER() {
		return MEMBER_NUMBER;
	}
	public void setMEMBER_NUMBER(int mEMBER_NUMBER) {
		MEMBER_NUMBER = mEMBER_NUMBER;
	}
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}
	public String getMEMBER_PASS() {
		return MEMBER_PASS;
	}
	public void setMEMBER_PASS(String mEMBER_PASS) {
		MEMBER_PASS = mEMBER_PASS;
	}
	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}
	public void setMEMBER_NAME(String mEMBER_NAME) {
		MEMBER_NAME = mEMBER_NAME;
	}
	
	
}
