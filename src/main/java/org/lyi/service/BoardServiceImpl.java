package org.lyi.service;

import java.util.ArrayList;

import org.lyi.mapper.BoardAttachMapper;
import org.lyi.mapper.BoardMapper;
import org.lyi.model.AttachFileVO;
import org.lyi.model.BoardVO;
import org.lyi.model.CriteriaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service	//Service 역할 선언 
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper bm;	//board 테이블 mapper
	
	@Autowired
	BoardAttachMapper bam; //ataach 테이블 mapper
	
	
	//BoardService에서 설계되어진 write 추상 메소드를 구현
	public void write(BoardVO board) {
		//BoardMapper에 있는 write메소드 호출
		//메소드의 매개변수를 통해 BoardVO값을
		//BoardMapper의 write메소드로 전달
		bm.write(board);
	
		board.getAttach().forEach(attach->{
			
		//AttachFileVO의 bno에 BoardVO의 bno를 저장
			attach.setBno(board.getBno());
		
			bam.insert(attach);
		});
	
	}
	
	
	
	public ArrayList<BoardVO> list() {
		return bm.list();
	}
	
	@Transactional
	public BoardVO detail(BoardVO board) {
		bm.cntup(board);
		return bm.detail(board);
	}
	
	public void modify(BoardVO board) {
		bm.modify(board);
	}
	
	public void remove(BoardVO board) {
		bm.remove(board);
	}
	
	public ArrayList<BoardVO> list(CriteriaVO cri){
		return bm.list(cri);
	}
	
	public int total(CriteriaVO cri) {
		return bm.total(cri);
	}
	
	// 첨부파일 조회 구현
	public ArrayList<AttachFileVO> attachlist(int bno){
		return bam.attachlist(bno);
	}
}
