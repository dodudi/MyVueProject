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
		int boardCount = boardMapper.getBoardCount();
		pageInfo.setTotal(boardCount);
		pageInfo.pageCalculate();
		List<BoardDTO> boards = boardMapper.getBoards(pageInfo);
		log.info(pageInfo.toString());
		resultMap.put("boards", boards);
		resultMap.put("pageInfo", pageInfo);
		return resultMap;
	}
	
	@PostMapping("/getShowBoards")
	public Map<String, Object> getShowBoards(@RequestBody PageInfo pageInfo){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		int boardCount = boardMapper.getShowBoardCount();
		pageInfo.setTotal(boardCount);
		pageInfo.pageCalculate();
		List<BoardDTO> boards = boardMapper.getShowBoards(pageInfo);
		log.info(pageInfo.toString());
		resultMap.put("boards", boards);
		resultMap.put("pageInfo", pageInfo);
		return resultMap;
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
	
	@PostMapping("acceptSelectedBoard")
	public int acceptSelectedBoard(@RequestBody List<BoardDTO> boards) {
		int result = 0;
		for (BoardDTO boardDTO : boards) {
			result+= boardMapper.acceptBoard(boardDTO);
		}
		return result;
	}
	
	@PostMapping("delSelectedBoard")
	public int delSelectedBoard(@RequestBody List<BoardDTO> boards) {
		int result = 0;
		for (BoardDTO boardDTO : boards) {
			result += boardMapper.delBoard(boardDTO);
		}
		return result;
	}
	@PostMapping("delBoard")
	public int delBoard(@RequestBody BoardDTO board) {
		int result = boardMapper.delBoard(board);
		return result;
	}

}
