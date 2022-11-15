var code = "";				//이메일전송 인증번호 저장위한 코드

 /* 유효성 검사 통과유무 변수 */
var emailCheck = false;			// 이메일 체크
var emailckCheck = false;		// 이메일 중복 체크

var mailCheck = false;			// 이메일
var mainumCheck = false;		// 이메일 인증번호 확인
var mailnumCheck = false;		// 이메일 인증번호 확인

var idCheck = false;			// 아이디
var idckCheck = false;			// 아이디 중복 검사
var pwCheck = false;			// 비번
var pwckCheck = false;			// 비번 확인
var pwckcorCheck = false;		// 비번 확인 일치 확인
var nameCheck = false;			// 이름
var addrzipCheck = false; 		// 우편번호
var addr1Check = false;			// 도로명주소
var addr2Check = false;			// 세부주소
 
$(document).ready(function(){
	//회원가입 버튼(회원가입 기능 작동)
	$("#insert_insert").click(function(){
		
		/* 입력값 변수 */
		var id = $('.id_input').val(); 				// id 입력란
		var pw = $('.pw_input').val();				// 비밀번호 입력란
		var pwck = $('.pwck_input').val();			// 비밀번호 확인 입력란
		var name = $('.user_input').val();			// 이름 입력란
		var mail = $('.mail_input').val();			// 이메일 입력란
		var addr = $('.address_input_3').val();		// 주소 입력란
		
		/* 아이디 유효성검사 */
		if(id == ""){
			$('.final_id_ck').css('display','block');
			idCheck = false;
		}else{
			$('.final_id_ck').css('display', 'none');
			idCheck = true;
		}
		
		/* 비밀번호 유효성 검사 */
		if(pw == ""){
			$('.final_pw_ck').css('display','block');
			pwCheck = false;
		}else{
			$('.final_pw_ck').css('display', 'none');
			pwCheck = true;
		}
		
		/* 비밀번호 확인 유효성 검사 */
		if(pwck == ""){
			$('.final_pwck_ck').css('display','block');
			pwckCheck = false;
		}else{
			$('.final_pwck_ck').css('display', 'none');
			pwckCheck = true;
		}
		
		//$("#join_form").attr("action", "/member/join");
		//$("#join_form").submit();
		/* 이름 유효성 검사 */
		if(name == ""){
			$('.final_name_ck').css('display','block');
			nameCheck = false;
		}else{
			$('.final_name_ck').css('display', 'none');
			nameCheck = true;
		}		
		
		/* 이메일 유효성 검사 */
		if(mail == ""){
			$('.final_mail_ck').css('display','block');
			mailCheck = false;
		}else{
			$('.final_mail_ck').css('display', 'none');
			mailCheck = true;
		}		
		
		/* 주소 유효성 검사 */
		if(addr == ""){
			$('.final_addr_ck').css('display','block');
			addressCheck = false;
		}else{
			$('.final_addr_ck').css('display', 'none');
			addressCheck = true;
		}		
		
		/* 최종 유효성 검사 */
		if(idCheck&&idckCheck&&pwCheck&&pwckCheck&&pwckcorCheck&&nameCheck&&mailCheck&&mailnumCheck&&addressCheck ){
			$("#join_form").attr("action", "/member/join");
			$("#join_form").submit();			
			
		}		
		
		return false;
	});
});

//아이디 중복검사
 $('#user_id').on("click", function(){

		var user_id = $('#user_id').val();			// .id_input에 입력되는 값
		var data = {user_id : user_id}				// '컨트롤에 넘길 데이터 이름' : '데이터(.id_input에 입력되는 값)'
		
		$.ajax({
			type : "post",
			url : "/insertIdChk",
			data : data,
			success : function(result){
				if(result != 'fail'){
					$('.id_input_re_1').css("display","inline-block");
					$('.id_input_re_2').css("display", "none");				
				} else {
					$('.id_input_re_2').css("display","inline-block");
					$('.id_input_re_1').css("display", "none");				
				}
			}
		}); // ajax 종료
		
	});
 
 
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


/* 비밀번호 확인 일치 유효성 검사 */
$('.pwck_input').on("propertychange change keyup paste input", function(){
	
	var pw = $('.pw_input').val();
	var pwck = $('.pwck_input').val();
	$('.final_pwck_ck').css('display', 'none');
	
	if(pw == pwck){
		$('.pwck_input_re_1').css('display','block');
		$('.pwck_input_re_2').css('display','none');
		pwckcorCheck = true;
	}else{
		$('.pwck_input_re_1').css('display','none');
		$('.pwck_input_re_2').css('display','block');
		pwckcorCheck = false;
	}
	
	
});