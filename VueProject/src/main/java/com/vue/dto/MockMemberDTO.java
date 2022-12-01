package com.vue.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class MockMemberDTO {
	private String userName; 
	private String userId; 
	private String userPass; 
	private String userPhone;
	private String userEmail; 
	private String userGender;
	private Date userRegDate;
	
}
