package org.lyi.mapper;

import java.util.ArrayList;

import org.lyi.model.BoardVO;
import org.lyi.model.CriteriaVO;

public interface BoardMapper {

	// 글쓰기에 해당되는 DB 작업 설계 
	public void write(BoardVO board);
	
	// 게시글 목록에 해당되는 DB 작업 설계 
	public ArrayList<BoardVO> list();
	
	public BoardVO detail(BoardVO board);
	
	public void modify(BoardVO board);
	
	public void remove(BoardVO board);
	
	public ArrayList<BoardVO> list(CriteriaVO cri);
	
	public int total();
	
	public void cntup(BoardVO board);
	
	public int total(CriteriaVO cri);
}

