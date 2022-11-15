/**
 * 
 */

$(document).ready(function(){
	
	$("input[type='button']").on("click", function(){
		//alert("aaa");
		// pageNum에 1을 초기화
		$("input[name='pageNum']").val("1");
		// form태그를 submit
		$("#searchForm").submit();
	})
	
})