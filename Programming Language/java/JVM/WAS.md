1. Web Server
 a. 기능
  - HTTP 프로토콜을 기반하여 클라이언트의 요청을 서비스하는 기능
   1. 정적 콘텐츠 제공
   2. 동적 콘텐츠 요청 전달
 b. 개념
  1. 하드웨어   : Web 서버가 설치되어 있는 컴퓨터
  2. 소프트웨어 : 웹 브라우저 클라이언트로부터 HTTP요청을 받아 정적 컨텐츠를 제공하는 프로그램
 c. 종류
  - Apache Server, Nginx, IIS
2. WAS(Web Application Server)
 a. 기능
  - 프로그램 실행환경과 DB 접속 기능 제공
  - 여러 개의 트랜잭션 관리 기능
  - 업무 처리 비즈니스 로직 실행
 b. 개념
  - DB조회나 다양한 로직 처리를 요구하는 동적 콘텐츠를 제공하기 위한 Application Server
  - Web Container 혹은 Servlet Container라고 불림
 c. 역할
  - Web Server + Web Container
  - 분산 트랜잭션, 보안, 메시징, 쓰레드 처리 등의 기능을 처리하는 분산환경에서 사용
 d. 종류
  - Tomcat, JBoss, Jeus, Web Sphere


3. Reference
 a. https://gmlwjd9405.github.io/2018/10/27/webserver-vs-was.html
