package com.vue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vue.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	public List<BoardDTO> getShowBoards();
	public List<BoardDTO> getRezerveBoard();
}
