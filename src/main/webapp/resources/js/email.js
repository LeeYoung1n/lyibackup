/**
 * 
 */


/* 인증번호 이메일 전송 */
$(".mail_check_button").click(function(){
	
	var email = $(".mail_input").val();			// 입력한 이메일
	var cehckBox = $(".mail_check_input");		// 인증번호 입력란
	var boxWrap = $(".mail_check_input_box");	// 인증번호 입력란 박스
	
	$.ajax({
		
		type:"GET",
		url:"mailCheck?email=" + email,
		success:function(data){
			
			//console.log("data : " + data);
			cehckBox.attr("disabled",false);
			boxWrap.attr("id", "mail_check_input_box_true");
			code = data;
			
		}
				
	});
	
});
/* 인증번호 비교 */
$(".mail_check_input").blur(function(){
	
	var inputCode = $(".mail_check_input").val();		// 입력코드	
	var checkResult = $("#mail_check_input_box_warn");	// 비교 결과 	
	
	if(inputCode == code){							// 일치할 경우
		checkResult.html("인증번호가 일치합니다.");
		checkResult.attr("class", "correct");		
		mailnumCheck = true;
	} else {											// 일치하지 않을 경우
		checkResult.html("인증번호를 다시 확인해주세요.");
		checkResult.attr("class", "incorrect");
		mailnumCheck = false;
	}	
	
});