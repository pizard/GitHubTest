# **Node.js란 무엇인가?**
### 웹의 역사
1. 1990년 Tim Berners lee WEB 창시
	 - 정적인 체계
2. Marc Andreessen의 Netscape(Web Browser), Brendan Eich의 Java Script 등장
	 - 동적인 체계 탑재
	 - 사용자와 상호작용 가능
3. 2008년 Google의 JavaScript Engine 개발(V8)
	 - 성능 향상의 Point
4. 2009년 Ryan Dal의 Node.js 개발

### JavaScript vs Node.js
 - ?

### Node.js의 장점
1. V8 Engine
	 - Google에 의해 끊임없이 발전 될 것
2. Event-driven 방식
	 - 사용자가 이벤트를 발생시켰을 때만 작동되는 방식
	 - 자원을 최소화 할 수 있음
3. non-Blocking 패러다임
	 - I/O작업을 하는동안 유저 프로세스의 작업을 중단시키지 않음
4. Single Thread
	 - 장/단점이 존재함
	 - 적은 양의 자원으로 일을 처리하는 것이 가능
	 - 한곳에 예외상황 및 에러가 발생한다면 어플리케이션 전체에 영향이 가게 됨
5. Client와 Server의 사용언어가 동일 함

### Node.js의 단점
1. Single THREAD
	 - 하나의 작업이 많이 걸리면, 전체 시스템으 성능이 급격하게 떨어짐
	 - 멀티코어 머신에서 CPU사용을 최적화 할 수 없음
	 - Single Thread기반의 비동기 IO를 지원해야 하기 때문에 노드 전용 모듈을 사용ㅎ야 함
2. 자바나 다른 언어에 비해 명시성이 떨어짐
3. 이벤트 Call back 형태를 기준으로 개발되기 때문에 중첩될 경우 가독성이 떨어짐
4. 해당 코드가 실행 되는 경우에만 Error 확인
5. Error가 발생되는경우 프로세스 자체가 죽음
6. V8 Engine은 Garbage collection 기반의 메모리 관리를 하기 때문에 CPU 사용률이 Spike를 치면 순간적으로 서버를 멈출 수 있음

### 결론
 - 개발이 빠르고 쉬운 장점이 있지만 운영에서는 테스트, 장애 대응, 디버깅 등에 대해서 신경 쓸 부분이 더 많음

### node.js의 내부 작동 원리 구조
 - Single Thread 기반의 Event Loop(libuv)가 돌면서 요청을 처리하면서 요청을 처리
 - Async / Non blocking IO
 	 **file write io**
 	 1. file_write를 호출
 	 2. 디스크에 파일 쓰기 요청
	 3. 디스크가 파일을 쓰는 동안 file_write부분에 멈춰서 대기(blocking state)
	 4. 파일을 다 쓰면 디스크에서 리턴해 file_write 함수 이후로 진행
 - **비동기식 IO**
 	 **file write io**
 	 1. 파일 쓰기 요청을 던짐
 	 2. 동시에 다음코드로 진행
 	 3. 파일을 다 쓰면 callback함수를 호출
 - **Single Thread Model**
 	 - 하나의 Thread만을 사용해서 여러 Client로부터 오는 Request 처리
 	 - IO작업의 경우 비동기 IO방식으로 IO요청을 던져 놓고 다른 작업 진행
 	 - IO작업을 보내고 그동안 다른 요청을 받는 Thread를 ELP(Event Loop Thread)라 함
 	 - Thread Pool
 	 	 - 내부적으로는 multi thread pool을 사용하기도 함

# **...... 추가 필요!!**

### LAMP stack vs MEAM stack
 - LAMP stack(Linux, Apache, MySQL, PHP/Python/Perl)
 - MEAN stack(MongoDB, Express.js, Angular.js, Node.js)


### 참고
 - [Jbee_Devlog](http://asfirstalways.tistory.com/43 "Jbee_Devlog")
 	- 웹의 역사
	- Node.js의 장점
 - [조대협의 블로그](http://bcho.tistory.com/876 "조대협의 블로그")
	 - Node.js의 단점
	 - 결론
 - 한장현