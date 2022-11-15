package org.lyi.controller;

import java.util.Locale;

import org.lyi.model.SampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {
	@RequestMapping(value = "/Sample/getText", produces="text/plain; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<String> home(Locale locale, Model model){
		return new ResponseEntity<>("와아아아아아", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Sample/getSample", method = RequestMethod.GET)
	public ResponseEntity<SampleVO> getSample(){
		SampleVO sample = new SampleVO();
		sample.setNo(1);
		sample.setName("강포동");
		sample.setGender("남");
		
		ResponseEntity<SampleVO> result=null;
		result=ResponseEntity.status(HttpStatus.OK).body(sample);
		
		return result;
	}
	
	

}
