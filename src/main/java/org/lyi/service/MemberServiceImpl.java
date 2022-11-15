package org.lyi.service;

import java.util.ArrayList;

import org.lyi.mapper.MemberMapper;
import org.lyi.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired(required=false)
	MemberMapper mm;
	//회원가입
	public void signup(MemberVO member) {
		System.out.println("회원가입"+member);
		mm.signup(member);
	}
	
	public ArrayList<MemberVO> memberlist(){
		return mm.memberlist();
	}
	
	public MemberVO memberdetail(MemberVO member) {
		return mm.memberdetail(member);
	}
	
	public void membermodify(MemberVO member) {
		mm.membermodify(member);
	}
	
	public void resign(MemberVO member) {
		mm.resign(member);
	}
	
	public void login(MemberVO member) {
		System.out.println("로그인"+member);
		mm.login(member);
	}
	
}
