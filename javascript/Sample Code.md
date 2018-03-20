# Sample Code
 - 삭제
```
var deleteFile_sq = [];	// 삭제할 첨부 파일 sq
function deleteFile(obj){
    var div = $(obj).parents(".deleteBox");
    deleteFile_sq.push(div.attr("index"))
	div.hide();
	return;
}

$("#btnModify").click(function(){
	var form = $('#frm')[0];
	var formData = new FormData(form);
	// 파일 삭제 처리
	formData.append("deleteFile_sq", "(" + deleteFile_sq + ")");
	
	$.ajax({
		url : '경로',
		type: 'POST',
			processData : false,
			contentType : false,
		data: formData,
		success : function(data){
			alert("삭제에 성공하셨습니다.");
		},
		error : function(request,status,error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			alert("통신에 문제가 발생했습니다. \n잠시 후 다시 시도해주십시오.");
		}
	});
});


	<update id="deleteAttachFile" parameterType="hashmap">
		UPDATE {테이블 명}
		   SET del_yn = 'Y'
			 , e_dt = Now()
			WHERE FILE_SQ IN
				${deleteFile_sq}
	</update>
```
