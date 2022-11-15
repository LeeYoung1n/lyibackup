/**
 * 
 */
$("#user_repw").on("blur", function(){

	var user_pw = $("#user_pw").val();
	var user_repw = $("#user_repw").val();
	
	
	//비밀번호 형식이 맞음
	if(pwFormCheck(user_pw)){
		//그리고 일치함
		if(user_pw == user_repw){
			$('.insert_pwNone').css('display', 'none');
			$('.insert_pwFalse').css('display', 'none');
			$('.insert_pwTrue').css('display','block');
			$('.insert_repwNone').css('display','none');
			$('.insert_repwFalse').css('display','none');
			//회원가입 가능
			repwckCheck = true;
		//그러나 일치하지 않음
		}else if(user_pw != user_repw){
			$('.insert_pwNone').css('display', 'none');
			$('.insert_pwFalse').css('display', 'none');
			$('.insert_pwTrue').css('display','none');
			$('.insert_repwNone').css('display','none');
			$('.insert_repwFalse').css('display','block');
			//회원가입 불가
			repwckCheck = false;
		//혹은 비밀번호 확인을 하지 않음
		}else if(user_repw == ""){
			$('.insert_pwNone').css('display', 'none');
			$('.insert_pwFalse').css('display', 'none');
			$('.insert_pwTrue').css('display','none');
			$('.insert_repwNone').css('display','block');
			$('.insert_repwFalse').css('display','none');
			//회원가입 불가
			repwckCheck = false;
		}
	//비밀번호 형식이 틀림
	}else if(!pwFormCheck(user_pw)){
		//일치하든 일치하지 않든 입력 불가
		$('.insert_pwNone').css('display', 'none');
		$('.insert_pwFalse').css('display', 'block');
		$('.insert_pwTrue').css('display','none');
		$('.insert_repwNone').css('display','none');
		$('.insert_repwFalse').css('display','none');
		repwckCheck = false;
	}	
});








//비밀번호 일치 및 형식 검사
$("#user_pw").on("blur", function(){
	
	var user_pw = $("#user_pw").val();
	var user_repw = $("#user_repw").val();
	
	// 비밀번호 형식이 맞고 일치할 때 
	if(user_pw == user_repw && pwFormCheck(user_pw) ){
		$('.insert_pwNone').css('display', 'none');
		$('.insert_pwFalse').css('display', 'none');
		$('.insert_pwTrue').css('display','block');
		$('.insert_repwNone').css('display','none');
		$('.insert_repwFalse').css('display','none');
		repwckCheck = true;
		
	// 비밀번호 형식이 틀렸을 때 (일치하든 안되든 틀리면 무조건 입력되면 안됨)
	}else if(user_pw == user_repw && !pwFormCheck(user_pw)){
		$('.insert_pwNone').css('display', 'none');
		$('.insert_pwFalse').css('display', 'block');
		$('.insert_pwTrue').css('display','none');
		$('.insert_repwNone').css('display','none');
		$('.insert_repwFalse').css('display','none');
		repwckCheck = false;
	
	// 비밀번호가 일치하지 않을 때 (형식은 맞음)
	}else if(user_pw != user_repw && pwFormCheck(user_pw)){
		$('.insert_pwNone').css('display', 'none');
		$('.insert_pwFalse').css('display', 'none');
		$('.insert_pwTrue').css('display','none');
		$('.insert_repwNone').css('display','none');
		$('.insert_repwFalse').css('display','block');
		repwckCheck = false;
	
	// 틀렸는데 일치도 안함
	}else{
		$('.insert_pwNone').css('display', 'none');
		$('.insert_pwFalse').css('display', 'block');
		$('.insert_pwTrue').css('display','none');
		$('.insert_repwNone').css('display','none');
		$('.insert_repwFalse').css('display','block');
		repwckCheck = false;
	}
});

