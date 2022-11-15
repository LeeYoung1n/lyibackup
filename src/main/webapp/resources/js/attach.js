/**
 * 첨부파일 관련 js
 */

$(document).ready(function(){
	// detail.jsp가 시작되자마자(ready 이벤트) bno값 가져오기
	// input과 name 사이를 띄우면 안됨!! 
	var bno=$("input[name='bno']").val();
	var str="";
	//									콜백
	$.getJSON("/attachlist",{bno:bno},function(attachlist){
		console.log(attachlist);
		
		
		
		$(attachlist).each(function(i, attach){
			// 만약 image 결과가 true면
			if(attach.image){
				var filePath=encodeURIComponent(attach.uploadPath+"/s_"+attach.uuid+"_"+attach.fileName)
				str+="<li><img src='/display?fileName="+filePath+"'>"+attach.fileName+"</a></li>"
			}else{// 그렇지 않으면
				var filePath=encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName)
				str+="<li><a href='/download?fileName="+filePath+"'>"+attach.fileName+"</a></li>"
			}
		})
		$("#uploadResult ul").html(str);
		
		
		
	})
})