package com.vue.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vue.api.PageCalc;
import com.vue.api.PageInfo;
import com.vue.dto.BoardDTO;
import com.vue.mapper.BoardMapper;

@RestController
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardMapper boardMapper;
	@PostMapping("/getBoards")
	public Map<String, Object> getBoards(@RequestBody PageInfo pageInfo){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<BoardDTO> boards = boardMapper.getBoards();
		PageCalc pageCalc = new PageCalc(boards.size(), 10, pageInfo);
		
		resultMap.put("boards", boards);
		resultMap.put("pageCalc", pageCalc);
		return resultMap;
	}
	
	@PostMapping("/getShowBoards")
	public List<BoardDTO> getShowBoards(@RequestBody PageInfo pageInfo){
		return boardMapper.getShowBoards();
	}
	@PostMapping("/getRezerveBoards")
	public List<BoardDTO> getRezerveBoards(@RequestBody PageInfo pageInfo){
		return boardMapper.getRezerveBoard();
	}
	
	@PostMapping("addBoard")
	public List<BoardDTO> addBoard(@RequestBody BoardDTO board) {
		log.info(board.toString());
		int result = boardMapper.addBoard(board);
		return boardMapper.getRezerveBoard();
	}
	
	@PostMapping("delBoard")
	public int delBoard(@RequestBody BoardDTO board) {
		int result = boardMapper.delBoard(board);
		return result;
	}
}
