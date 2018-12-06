# JavaParser JSON
## **Json(JavaScript Object Notation**
 - 정의
 	 - 서버와 웹 사이의 데이터 전송을 위해 사용하는 데이터 형식
 - 구성
 	 - Object: 중괄호를 이용하여 감싸고 있음
 	 - name은 string으로 되어있고, name:value 형태
 	 - value는 큰 따옴표
 	 - {object} / name : value / [array]
 - Parser
	 1. Jackson
		 - 코드가 심플하고 고용량(100MB 이상)의 JSON 데이터 처리 능력이 탁월
		 - 패키지가 무거운편
	 2. **Google-gson √**
		 - 소스코드, 레퍼런스 찾기가 용이
		 - 가벼운 JSON데이터 처리 성능이 탁월하고 전반적으로 고성능
		 - 상대적으로 가벼운 jar속에 하나의 패키지로 구성
	 3. JSON-lib
		 - 더글라스 크록포트(?), 디펜던시 다수 존재(?)
	 4. Flexjson
		 - 자바 객체를 JSON으로 직렬화하거나 비직렬화 할 수 있는 경량 라이브러리
		 - 다른 외부 라이브러리와 의존성이 없음
		 - 성능이 무난하고 아주 적은 패키지 사이즈가 장점
	 5. Json-io
		 - JsonReader, JsonWriter 두 클래스로 구성 -> 직렬화 담당하는 stream객체가 필요 없음
		 - JDK의 ObjectInputStream, ObjectOutputStream보다 빠른 직렬화 성능을 제공

 - 참고
 	 - 어디서 공부한건지... ㅇ.ㅇ.... 추후 추가...