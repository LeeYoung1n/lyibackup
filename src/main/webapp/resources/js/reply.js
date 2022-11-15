/**
 * 댓글 관련 javascript 처리
 */

$(document).ready(function(){	//jquery 준비...
	// 함수 호출
	// detail.jsp가 시작되자마자 bno값을 가져올려면 $(document).ready 아래에 선언
	var bnoValue=$("input[name='bno']").val();
	
	// detil.jsp가 시작되자마자 댓글목록리스트(list) 함수를 호출
	list(bnoValue);
	
	//댓글 쓰기 버튼을 클릭하면
	$("#add").on("click",function(){
		//댓글쓰기 버튼을 클릭했을 당시에 댓글내용을 가져오려면 $("#add').on("click,function(){ 아래에 선언
		var replyValue=$("#reply").val();
		var idValue="abcd1";	//임의로 입력해둔 id값
		//댓글쓰기를 하기 위한 함수 호출
		add({bno:bnoValue,reply:replyValue,id:idValue});
	})
	
	// 댓글 수정버튼을 클릭하면
	// 이미 존재하는 태그에 이벤트를 처리하고
	// 나중에 동적으로 생기는 태그들에 대해서 파라미터 형식으로 지정(이벤트 델리게이트)
	$("#chat").on("click", ".update", function(){
		// 댓글 번호와 댓글내용을 수집해서
		var rno = $(this).data("rno");
		var reply = $("#replycontent"+rno).val();
		// 댓글 수정을 하기 위한 함수 호출(댓글 번호, 댓글 내용)
		modify({rno:rno, reply:reply});		
	})
	
	
	// 댓글 삭제버튼을 클릭하면
	$("#chat").on("click", ".remove", function(){
		// 댓글 번호만 수집해서
		var rno = $(this).data("rno");
		console.log(rno);
		// 댓글 삭제를 하기 위한 함수 호출(댓글 번호, 댓글 내용)
		remove(rno);
		//remove({rno:rno});		
	})
	
	
	
})// jquery 준비...
// 댓글 수정 함수 선언
function modify(reply){
	console.log(reply);
	$.ajax({
		type:"put",		//method방식(get, post, put, delete)
		url:"/replies/modify",
		data:JSON.stringify(reply),
		// contentType:ajax -> controller로 데이터 전송 시타입
		// contentType을 생략하면 web Brower한테 위임
		contentType : "application/json; charset=utf-8",
		success:function(result){
			if(result=="success"){
				alert("댓글수정 성공")
			}
		}
		
	})
}


// 댓글 삭제를 위한 함수 선언
function remove(rno){
	console.log(rno);
	$.ajax({
		type:"delete",		//method방식(get, post, put, delete)
		url:"/replies/remove/"+rno,
		success:function(result){
			if(result=="success"){
				alert("댓글삭제 성공")
			}
		}
		
	})
}



//list 함수 선언
function list(bno){	//list 함수 선언 시작
	//alert(bno);
	$.getJSON("/replies/"+bno+".json", function(data){
		console.log(data)
		var str="";
		
		for(var i=0; i<data.length; i++){
			str+="<li>"+data[i].id+"</li>" 
			str+="<li>"+data[i].rno+"</li>"
			// 댓글 수정 버튼 - javascript를 통해 html에 간접적으로 드러남 
			str += "<li><textarea id = 'replycontent"+data[i].rno+"'>"+data[i].reply+"</textarea></li>"
			str += "<li><input class='update' data-rno="+data[i].rno+" type='button' value='수정' ></li>"
			str += "<li><input class='remove' data-rno="+data[i].rno+" type='button' value='삭제' ></li>"
		}
		$("#replyUL").html(str);
	});	
}
//list 함수 선언 끝



//댓글 쓰기를 하기 위한 함수 선언
function add(reply){
	console.log(reply);
	$.ajax({
		type:"post",
		url:"/replies/new",
		data:JSON.stringify(reply),
		// contentType:ajax -> controller로 데이터 전송 시타입
		contentType:"application/json; charset=utf-8",
		success:function(result){
			if(result=="success"){
				alert("댓글쓰기 성공")
			}
		}
	})

} //add 함수 선언 끝



