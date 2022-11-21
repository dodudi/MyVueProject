package com.vue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vue.dto.BoardDTO;
import com.vue.mapper.BoardMapper;

@RestController
public class BoardController {
	@Autowired
	private BoardMapper boardMapper;
	
	@GetMapping("/getShowBoards")
	public List<BoardDTO> getShowBoards(){
		return boardMapper.getShowBoards();
	}
	@GetMapping("/getRezerveBoards")
	public List<BoardDTO> getRezerveBoards(){
		return boardMapper.getRezerveBoard();
	}
}
