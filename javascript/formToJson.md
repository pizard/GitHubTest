# formToJson
## SampleCode A
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
			o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};
 1. form의 모든 데이터를 serializeArray(), 배열의 형태로 변경
 2. Array의 이름(Name)에 값(Value) push
 3. 이름이 존재하는 경우 같은 위치에 값만 push(List형식)
 4. 이름만 존재하는 경우 이름만 넣음
 5. List형태의 값 전송 O


## SampleCode B
jQuery.fn.serializeObject = function() {
	var obj = null;
	try {
		// this[0].tagName이 form tag일 경우
		if(this[0].tagName && this[0].tagName.toUpperCase() == "FORM" ) {
			var arr = this.serializeArray();
			if(arr){
				obj = {};
				jQuery.each(arr, function() {
					// obj의 key값은 arr의 name, obj의 value는 value값
					obj[this.name] = this.value;
				});
			}
		}
	}catch(e) {
		alert(e.message);
	}finally  {
		
	}
	return obj;
};
 1. form의 모든 데이터를 serializeArray(), 배열의 형태로 변경
 2. Array의 이름(Name)만 확인하여 값(Value) 추가
 3. List형태의 값 전송 X
