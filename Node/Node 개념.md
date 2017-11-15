# Node.js
 - Google Chrome Javascript Engine(V8 Engine)에 기반하여 만들어진 Server Side Platform
 - 2009년 Ryan Dahl에 의해 개발
 - 특징
 	 - Node는 웹서버가 아님
 	 	 - 아파치 웹서버처럼 HTML 파일경로를 지정해주고 서버를 열고 이런 설정은 없음, HTTP서버를 직접 작성해야 함
 	 	 - 비동기 I/O 처리 / 이벤트 위주
 	 	 	 - 
 	 	 - 빠른 속도
 	 	 	 - Google Chrome의 V8 Engine을 이용하여 빠른 코드 실행
 	 	 - 단일 쓰레드 / 뛰어난 확장성
 	 	 	 - 이벤트 메커니즘을 서버가 멈추지 않고 반응하도록 해줘 확장성을 키워줌으로써 다른 웹서버보다 훨씬 많은 요청을 처리할 수 있음
 - Node.js의 사용처
 	 - 입출력이 잦은 어플리케이션
 	 - 데이터를 실시간으로 다루는 어플리케이션
 	 - JSON API 기반의 어플리케이션
 	 - Single Page 어플리케이션
 - Node.js를 쓰지 말아야 할 곳
 	 - CPU사용률이 높은 어플리케이션

### 참고
 - [VELOPERT.LOG](https://velopert.com/133 "VELOPERT.LOG")