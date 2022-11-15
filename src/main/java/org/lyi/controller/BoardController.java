package org.lyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

import org.lyi.model.AttachFileVO;
import org.lyi.model.BoardVO;
import org.lyi.model.CriteriaVO;
import org.lyi.model.PageVO;
import org.lyi.service.BoardService;

@Controller
public class BoardController {
	
	//상속선언
	@Autowired
	BoardService bs; 
	
	// 게시판 글쓰기 페이지 (화면)
	@RequestMapping(value="/Board/write", method = RequestMethod.GET)
	public String write() {
		return "Board/write";
	}
	
	// 게시판 글쓰기 페이지(insert 이루어짐)
	@RequestMapping(value="/Board/write", method = RequestMethod.POST)
	public String writePost(BoardVO board) {
		//비즈니스 영역 연결 후 BoardService에 있는 write 메소드
		bs.write(board);
		return "redirect:/Board/list";
	}
	
	
	// 게시판 목록 리스트
	@RequestMapping(value="/Board/list", method = RequestMethod.GET)
	public String list(Model model, CriteriaVO cri) {
		// boardlist.jsp를 실행할 때 select 된 결과를 가져가라.
		model.addAttribute("list", bs.list(cri));
		int total = bs.total(cri);
		model.addAttribute("paging", new PageVO(cri, total));
		return "Board/list";
	}
	
	// 게시판 상세 페이지
	@RequestMapping(value = "/Board/detail", method = RequestMethod.GET)
    public String detail(BoardVO board, Model model) {
		System.out.println(board);
		model.addAttribute("detail", bs.detail(board));
    	return "Board/detail";
    }
	
	// 게시판 수정 및 삭제 페이지
	@RequestMapping(value = "/Board/modify", method = RequestMethod.POST)
    public String modify(BoardVO board, RedirectAttributes rttr) {
    	bs.modify(board);
    	rttr.addAttribute("bno", board.getBno());
    	// 수정하고 난 뒤 확인을 위해 상세페이지로 화면 이동
    	return "redirect:/Board/list";
    }
	
	@RequestMapping(value = "/Board/remove", method = RequestMethod.POST)
	public String remove (BoardVO board) {
		bs.remove(board);
		return "redirect:/Board/list";
	}
	
	// 해당 게시물의 첨부파일 데이터를 ajax로 전송
	@RequestMapping(value = "/attachlist", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<AttachFileVO>> uploadAjaxPost(int bno){
		// 								통신 상태가 원활하면(http~) ajax로 보내라
		return new ResponseEntity<>(bs.attachlist(bno),HttpStatus.OK);
	}
	
}
