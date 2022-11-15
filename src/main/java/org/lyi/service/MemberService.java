package org.lyi.service;

import java.util.ArrayList;

import org.lyi.model.MemberVO;

public interface MemberService {
	
	//회원가입
	public void signup(MemberVO member);
	
	public ArrayList<MemberVO> memberlist();
	
	public MemberVO memberdetail(MemberVO member);
	
	public void membermodify(MemberVO member);
	
	public void resign(MemberVO member);
	
	public void login(MemberVO member);

}
