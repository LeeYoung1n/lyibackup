package org.lyi.mapper;

import java.util.ArrayList;

import org.lyi.model.AttachFileVO;

public interface BoardAttachMapper {
	
	// 글쓰기 할 당시에 첨부파일 DB작업 설계
	public void insert(AttachFileVO attach);
	// 해당게시물의 첨부파일 조회
	public ArrayList<AttachFileVO> attachlist(int bno);
	
}
