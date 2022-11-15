package org.lyi.controller;

import javax.servlet.http.HttpSession;

import org.lyi.model.BoardVO;
import org.lyi.model.MemberVO;
import org.lyi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	// 회원가입
	@RequestMapping(value = "/Member/signup", method = RequestMethod.GET)
	public String signup (MemberVO member) {
		return "Member/signup";
	}
	
	// 회원가입(insert)이루어짐
	@RequestMapping(value = "/Member/signup", method = RequestMethod.POST)
	public String signupPost (MemberVO member) {
		ms.signup(member);
		return "redirect:/Board/list";
	}
	
	@RequestMapping(value = "/Member/memberlist", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("memberlist", ms.memberlist());
		return "/Member/memberlist";
	}
	
	@RequestMapping(value = "/Member/memberdetail", method = RequestMethod.GET)
	public String detail (MemberVO member, Model model, HttpSession session) {
		ms.memberdetail(member);
		model.addAttribute("memberdetail", ms.memberdetail(member));
		return "Member/memberdetail";
	}
	
	@RequestMapping(value = "/Member/membermodify", method = RequestMethod.POST)
    public String modify(MemberVO member, RedirectAttributes rttr) {
    	ms.membermodify(member);
    	rttr.addAttribute("id", member.getId());
    	return "redirect:/Member/memberlist";
    }
	
	@RequestMapping(value = "/Board/resign", method = RequestMethod.POST)
    public String resign(MemberVO member) {
    	ms.resign(member);
    	return "redirect:/Member/signup";
    }
	
	
		// 로그인
		@RequestMapping(value = "/Member/login", method = RequestMethod.GET)
		public String login (MemberVO member) {
			return "Member/login";
		}
		
		// 로그인 서버
		@RequestMapping(value = "/Member/login", method = RequestMethod.POST)
		public String loginPost (MemberVO member, HttpSession session, RedirectAttributes rttr) {
			ms.login(member);
			session.setAttribute("id", member.getId());
			rttr.addAttribute("id", member.getId());			
			return "redirect:/Member/memberdetail";
		}
		
}
	

	
