package org.lyi.mapper;

import java.util.ArrayList;

import org.lyi.model.MemberVO;

public interface MemberMapper {
	
	public void signup(MemberVO member);
	
	public ArrayList<MemberVO> memberlist();
	
	public MemberVO memberdetail(MemberVO member);
	
	public void membermodify(MemberVO member);
	
	public void resign(MemberVO member);
	
	public void login(MemberVO member);
}
