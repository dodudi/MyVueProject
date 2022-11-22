package com.vue.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vue.dto.BoardDTO;

@SpringBootTest
public class BoardMapperTDD {
	private static final Logger log = LoggerFactory.getLogger(BoardMapperTDD.class);
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void getBoards() {
		List<BoardDTO> boards = boardMapper.getBoards();
		for (BoardDTO boardDTO : boards) {
			if(boardDTO != null)
				log.info(boardDTO.toString());
		}
	}
	
	@Test
	public void getShowBoards() {
		List<BoardDTO> boards = boardMapper.getShowBoards();
		
		for (BoardDTO boardDTO : boards) {
			if(boardDTO != null)
				log.info(boardDTO.toString());
		}
	}
	@Test
	public void getRezerveBoards() {
		List<BoardDTO> boards = boardMapper.getRezerveBoard();
		
		for (BoardDTO boardDTO : boards) {
			if(boardDTO != null)
				log.info(boardDTO.toString());
		}
	}
	
	@Test
	public void addBoard() {
		BoardDTO board = new BoardDTO();
		board.setBoardTitle("Add Title");
		board.setBoardContent("Add Content");
		board.setMemberId("user01");
		for(int i = 0 ; i < 305; i++) {
			boardMapper.addBoard(board);
		}
	}
}
