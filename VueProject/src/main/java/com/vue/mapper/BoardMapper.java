package com.vue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vue.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	public List<BoardDTO> getBoards();
 	public List<BoardDTO> getShowBoards();
	public List<BoardDTO> getRezerveBoard();
	
	public int getBoardCount();
	public int getShowBoardCount();
	public int getRezerveBoardCount();
	
	public int addBoard(BoardDTO board);
	public int delBoard(BoardDTO board);
}
