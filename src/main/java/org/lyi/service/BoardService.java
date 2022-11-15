package org.lyi.service;
import java.util.ArrayList;

import org.lyi.model.AttachFileVO;
import org.lyi.model.BoardVO;
import org.lyi.model.CriteriaVO;
import org.springframework.stereotype.Service;

public interface BoardService {

	public void write(BoardVO board); 
	
	public ArrayList<BoardVO> list();
	
	public BoardVO detail(BoardVO board);
	
	public void modify(BoardVO board);
	
	public void remove(BoardVO board);
	
	public ArrayList<BoardVO> list(CriteriaVO cri);

	public int total(CriteriaVO cri);


	public ArrayList<AttachFileVO> attachlist(int bno);
	
	

}
