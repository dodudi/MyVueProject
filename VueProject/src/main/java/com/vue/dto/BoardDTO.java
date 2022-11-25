package com.vue.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private int boardNumber;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private int boardReadCount;
	private String boardRezerveCheck;
	private String memberId;
	private String boardFilePath;
	@Override
	public String toString() {
		return "BoardDTO [boardNumber=" + boardNumber + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardDate=" + boardDate + ", boardReadCount=" + boardReadCount + ", boardRezerveCheck="
				+ boardRezerveCheck + ", memberId=" + memberId + ", boardFilePath=" + boardFilePath + "]";
	}


}
