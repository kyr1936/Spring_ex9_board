package com.yr.board;

import java.util.List;

import com.yr.util.PageMaker;

public interface BoardDAO {
	
	public int getTotalCount(PageMaker pageMaker) throws Exception;
	
	public int setDelete(int num) throws Exception;
	
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	//글 등록
	public int setWrite(BoardDTO boardDTO)  throws Exception;

	//글 리스트 (페이징처리  x)
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception;
	
	//글 하나
	public BoardDTO getSelect(int num) throws Exception;
}
