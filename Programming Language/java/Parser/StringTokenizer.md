# StringTokenizer
## 정의
 - java.util.StringTokenizer
 - 구분자(delimiter)로 문자열을 Token단위로 끊어주는 함수
 	 - Token: 구분자로 쪼갠 단위
 	 - delimiter: 이때 구분에 이용되는 문자, 문자열

## 생성자
 - `StringTokenizer(String str)`
 	 - 구획문자(delimiter)를 인자로 받지않는 생성자
 	 - default로 \t, \n, \r, \f를 갖는다
 - `StringTokenizer(String str, String delim)`;
 	 - 구획문자(delimtiter)를 인자로 받는 생성자
 	 - 구획문자의 길이가 1로 고정
 	 	 - ex. `$%`인 경우 `$`, `%`로 끊는다.
 - `StringTokenizer(String str, String delim, boolean returnDelims)`
 	 - 구획문자(delimiter)를 인자로 받는 생성자
 	 - returnDelims가 true인 경우 구획문자도 토큰으로 간주, (default: false)
 	 - 구획문자의 길이가 1로 고정

## function
 - `countTokens()`
 	 - 토큰의 개수를 리턴
 - `nextToken()`
 	 - 다음 토큰을 리턴한다. 이전 토큰은 제거
 - `nextToken(String delim)`
 	 - 구획문자를 delim으로 바꾼 후 다음 토큰을 리턴
 - `hasMoreTokens()`
 	 - 파싱된 문자열에 남겨진 토큰이 있는지 확인
 - `nextElement()`
 	 - nextToken과 같은 역할을 하지만 String대신 Object의 형태로 리턴한다.
 - `hasMoreElements`
 	 - hasMoreToken과 같은 역할을 수행함


### 참고
 - [J. deo의 그알정보](http://arer.tistory.com/48 "[JAVA 자바] StringTokenizer")
 	 - 생성자
 	 - function
 - [누구도 평범한 사람은 없다](http://lifeones.tistory.com/89 "StringTokenizer 클래스(문자열 파싱하기)")
 	 - 정의
 - [oracle](https://docs.oracle.com/javase/8/docs/api/index.html?java/util/StringTokenizer.html "StringTokenizer")
 	 - function