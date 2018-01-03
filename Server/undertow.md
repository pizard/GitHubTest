# Undertow
## Undertow란 소개
 - JBossEAP 7에서 새롭게 도입
 - 자바 언어로 작성된 웹서버
	 - 웹의 발전에 따라 웹서버에 필요한 기능들을 충족시키기 위해 개발
	 - 가볍기 때문에 임베드 가능하고 웹 어플리케이션 서버에 적합
	 - Non-Blocking API / Blocking API 제공
	 - JBos

## Undertow란 무엇인가?
 - JBoss EAP7 또는 Wildfly 에서는 JBoss EAP6(JBoss AS7) 이전 버전에서 사용하던 tomcat 기반의 JBossWeb대신 Undertow를 사용
 - 웹 서버와 서블릿 컨테이너 기능을 제공
 - I/O 부분은 JBoss 프로젝트 중 하나인 XNIO를 이용하여 처리
 - Java로 작성된 유연하면서 고성능의 웹서버이며 NIO기반의 blocking / Non-blocking API를 제공
 - 컴포지션 아키텍처를 제공하여 작은 단위의 용도를 갖는 핸들러들을 연결하여 웹서버 구축 가능
 - 컴포지션 아키텍처는 Full Java EE Servlet 3.1 컨테이너에서 부터 Low Level의 Non-blocking 핸들러 또는 그 중간 수준의 기능을 선택할 수 있는 유연성을 제공해준다.

## Undertow의 특징은?
 1. LightWeight
 	 - Core Library가 1.3MB정도로 매우 작으며, 런타임에서 가볍게 동작
 	 - 단순한 임베드 웹서버의 경우 10MB 이하의 힙 사이즈에서도 동작
 2. Http 업그레이드 지원
 	 - HTTP 업그레이드를 사용하여 HTTP상에서 동작하는 다양한 프로토콜을 다중화 
 	 - EJB와 JMS 등 자체 프로토콜을 사용하는 서비스들은 Http를 통해 연결하여 리슨 포트수를 줄임
 	 - 이를 통해 클라우드 환경에서 사용되는 포트의 수를 줄여 동일한 시스템에서 더 많은 서버를 실행
 	 - VM이나 컨테이너 환경에서 네트워크 포트관리가 어려울때 매우 유용
 3. 웹소켓 지원
 	 - Undertow는 JSR-356을 포함한 웹소켓을 완벽하게 지원한다.
 4. Servlet 3.1지원
 	 - Undertow는 임베드 Servlet을 포함한 Servlet 3.1을 지원한다. 이것은 servlet과 native undertow non-blocking 핸들러를 결합하여 배포할 수 있게 한다.
 5. 손쉬운 임베딩
 	 - 작은 코드로도 애플리케이션에서 undertow를 포함시킬 수 있으며, 스탠드얼론으로 실행할 수 있다.
 6. 유연성
 	 - undertow 서버는 핸들러 체인을 통해 설정할 수 있다. 이것은 필요한 기능을 초가하고 제거하는데 있어 사용하지 않은 것들에 대해 신경쓸 필요가 없게 해준다.
 	 

