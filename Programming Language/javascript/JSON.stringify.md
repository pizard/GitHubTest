# JSON.stringify()
 - 용도
	 - JSON의 일반적인 사용법은 웹 서버와 데이터를 교환하기 위함이다.
	 - 웹 서버로 데이터를 보낼때, 데이터는 string의 형태여야만 한다.
	 - 이때 JavaScript 객체를 String의 형태로 전환하기 위해 사용
 - 메서드
 	 - JSON.stringify(value[, replacer[, space]])
 	 	 - parameter
 	 	 	 - value
 	 	 	 	 - JSON문자열로 변환할 값
 	 	 	 - replacer (optional)
 	 	 	 	 - 문자열화 프로세스의 작동을 변경하는 함수, 혹은 JSON 문자열에 포함될 값 객체의 속성들을 선택하기 위한 화이트리스트로 쓰이는 String과 Number 객체들의 배열
 	 	 	 	 - 이 값이 null이거나 제공되지 않으면, 객체의 모든 속성들이 JSON 문자열 결과에 포함된다. 
 	 	 	 - space (optional)
 	 	 	 	 - 가독성을 위해 JSON 문자열 출력에 공백을 삽입하는데 사용되는 String 또는 Number 객체
 	 	 	 		 1. Number
 	 	 	 		 	 - 공백으로 사용되는 공간의 수(1 ~ 10 사이의 수)
 	 	 	 		 2. String
 	 	 	 		 	 - 해당 문자열이 공백으로 사용(10보다 긴 경우 10번째 문자열까지만 사용)
 - 예시
 	 - ex1. placer
	 	```
	 	function replacer(key, value) {
			if (typeof value === "string") {
				return undefined;
			}
			return value;
		}

		var foo = {foundation: "Mozilla", model: "box", week: 45, transport: "car", month: 7};
		var jsonString = JSON.stringify(foo, replacer);
	 	```
	 	 - 결과값: `{"week":45,"month":7}`
	 - ex2. space
	 	`JSON.stringify({ uno: 1, dos: 2 }, null, ' ');`
	 	 - 결과값 
		 	```
		 	'{
				"uno": 1,
				"dos": 2
			}'
	 		```


 https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/JSON/stringify
