# RESTful API
## REST란?
 - REpresentational State Transfer의 약자
 - 장비간 통신을 위해 CORBRA, RPC, SOAP등 의 복잡한 방법 대신 간단하게 HTTP를 이용
 - 자원 지향 구조(Resource Oriented Architecture) 웹 사이트의 이미지, 텍스트, DB 내용 등의 모든 자원에 고유한 URI 부여

## CRUD
 - Create: 생성(POST)
 - Read: 조회
 - Update: 수정(PUT)
 - Delete: 삭제(DELETE)
 - POST: http://localhost/api/user/홍길동
 	 - 홍길동의 user정보를 생성합니다.
 - PUT: http://localhost/api/user/홍길동
 	 - 홍길동의 user정보를 수정합니다.
 - GET: http://localhost/api/user/홍길동
 	 - 홍길동의 user정보를 가져옵니다.
 - DELETE: http://localhost/api/user/홍길동
 	 - 홍길동의 user정보를 제거합니다.

## 6가지를 충족하는 아키텍처 스타일
 - Client-Server
 	 - REST서버는 API 제공
 	 - 하나 혹은 여러 클라이언트에서 하나의 REST API를 이용
 	 - 비즈니스 
 - Stateless
 	 - 무상태성
 	 - 상태 정보를 저장하지 않고 API서버는 들어오는 메시지로만 처리
 	 - 세션과 같은 컨텍스트 정보를 신경쓸 필요가 없음
 - Cache
 	 - 캐쉬 이용가능
 	 - HTTP 프로토콜 표준에서 사용하는 Last-Modified태그나 E-Tag를 이용하여 구현
 - Uniform Interface
 	 - REST는 HTTP표준에만 따른다면, 어떤 기술이라던지 사용이 가능한 인터페이스 스타일
 - Layered System
 	 - 클라이언트는 직접 최종서버에 붙었는지 등을 알 수 없습니다.
 - Code-On-Demand
 	 - 서버로부터 스크립트를 받아서 Client에서 실행하는 것

## HttpMessageConverters
 - getForObject(), postForLocation(), put() 으로 넘겨지고 반환되는 객체들은 HttpMessageConverters에 의해 HTTP 요청으로 변환되고 HTTP응답으로부터 변환된다.
 - 주요 MIME 타입과 자바 타입을 위한 변환기(converter)는 기본적으로 등록되지만, 직접 변환기를 작성하고 RestTemplate에 끼워 넣을 수 있다.
 - 종류
 	 - StringHttpMessageConverter
 	 - FromHttpMessageConverter
 	 - ByteArrayMessageConverter
 	 - MarshallingHttpMessageConverter
 	 - **MappingJacksonHttpMessageConverter**
 	 - SourceHttpMessageConverter
 	 - BufferedImagedHttpMessageConverter


http://seongilman.tistory.com/117