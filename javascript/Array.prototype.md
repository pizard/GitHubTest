# Array.prototype
## 컴파일 과정이 없는 자바스크립트
 - 장점
	 - 자바스크립트는 컴파일 과정이 없으므로 100% 실행시점에 해석되고 실행됨
	 - 따라서 개발자가 작성한 코드는 별도의 최적화 과정을 거칠 수 없음
	 - 바로 이 점이 최대한 native함수를 이용해야 하는 이유

## slice의 내부
```
function slice( $start, $end ){
	var i, j, result;
	result = [];
	j = $end === undefined ? this.length : $end;
	for( i = $start ; i < j ; i++ )
		result[result.length] = this[i];
	return result;
}
```
 - Array.prototype.slice.call(argument) 
 	 - object를 array로 변환할 필요가 있는경우 사용
	 - `call()`
	 	 - 상위 context를 변경하는 메서드
	 - `argument`
	 	 - 함수의 매개변수에 접근할 수 있는 속성
	 	 - array가 아닌 object
	