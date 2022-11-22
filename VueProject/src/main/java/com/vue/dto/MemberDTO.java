package com.vue.dto;
//TODO 카멜바꾸기
//TODO lombok

import lombok.Data;

@Data
public class MemberDTO {
	private String memberId;
	private String memberPass;
	private String memberName;
	
	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberPass=" + memberPass + ", memberName=" + memberName + "]";
	}
	
 
	
}
