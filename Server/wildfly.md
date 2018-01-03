# Chapter 1.JBoss 소개
## JBoss 이름의 유래
 - 1999년 Mark Fleury가 EJB Container를 오픈소스로 개발하기 위해 EJBOSS(Enterprise Java Beans Open Source Software)라는 이름으로 시작한 프로젝트였지만 SUM과의 상표권 문제로 인해 앞의 E를 빼고 현재의 JBoss라는 이름이 되었습니다.
 - 2006년 4월 RedHat이 JBoss를 인수하면서 JBoss에는 여러가지 의미를 갖게 됨
 	 1. RedHat에서 오픈소스로 개발하는 미들웨어 사업부
 	 2. RedHat이 제작하는 모든 미들웨어 제품들에 대한 상표
 	 3. JBoss Application Server(JBoss-AS)

## JBoss-AS, JBoss-EAP, Wildfly의 관련성
### JBoss-AS vs JBoss-EAP
 - JBoss-AS((E)JBoss Application Server)
 	 - JBoss.org라는 인터넷 커뮤니티에서 제공하는 JavaEE6표준을 지원하는 오픈소스 Application Server의 이름
 - JBoss-EAP(JBoss Enterprise Aplication Platform)
 	 - JBoss.org가 아닌 REDHAT에서 제공하는 제품
 - 공통점
 	 - 소스 코드 수준에서 거의 동일한 제품
 - 차이점
 	 - 기술지원이 필요할 때 유료 기술 지원을 받을 것인지 or 무료로 스스로가 해결할 것인지의 차이
<img src="../image/server/JBoss-AS vs JBoss-EAP.png"></img>
 - JBoss-AS7
 	 - JBoss.org 커뮤니티에서 주로 기능 개발을 목적으로 하는 제품
	 - 개발 중 발생된 버그는 수정되어 'Release'에 포함되고 메이저 버전 업그레이드는 존재
	 - 하지만 보안이나 버그 패치 등의 'Release'는 제공하지 않으며 유지보수 또한 지원하지 않음
	 - 즉 스스로가 코드를 수정하고 포팅, 빌드업 해야함
 - JBoss-EAP 6
 	 - 상업 서비스 제품으로 사용자가 요청한 버그 수정 또는 보안 업데이트 등의 안전성과 품질 그리고 기술 지우너 환경에 대한 호환성 테스트를 걸쳐 출시
 	 - 버그/보안/성능과 관련된 'Release' 제공
 	 - JBoss-AS7 버전과 동일한 소스 코드를 기반으로 하여 안정화한 버전을 패키징하기 때문에 대체로 EAP버전이 AS에 비해 낮음

### Wildfly
 - JBoss-AS와 JBoss-EAP라는 이름을 구분짓기 위해 만든 것
 - 일반적으로 JBoss -> JBoss-AS를 의미했었지만 2013년 RedHat은 JBoss -> JBoss-EAP로 인식을 바꾸기 위해 JBoss-AS 8 부터는 'Wildfly 8'이라는 이름으로 변경, JBoss.org -> wildfly.org로 변경



### 참고
 - 전준식. 『거침없이 배우는 JBoss』. (주) 지앤션, 2014.
 - [beom3](http://beom3.tistory.com/30 "JBoss의 AS/EAP 그리고 Wildfly란 무엇일까?")