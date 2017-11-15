# **자바 성능 튜닝 이야기**

 - 지은이
   - 이상민 / 인사이트

 - 디자인 패턴(GOF 패턴, Gang Of Four)

 - Transfer Object 패턴
   - Getter / Setter 의 경우 null check를 하지 않아도 길이가 0인 String 리턴
   - Serializable은 왜 implements 했는가?
     - 객체를 직렬화 할 수 있음, 서버 사이의 데이터 전송이 가능해짐
     - 원격지 서버에 데이터를 전송하거나 파일로 객체를 저장할 경우 이 인터페이스를 구현해야 함

 - Service Locator 패턴
   - EJB Home 객체나 유의 DataSource를 찾을 때 소요되는 응답속도를 감소시키기 위해 사용

 + 일단 앞부분은 별로 크게 의미 없을거 같으니 여기까지만 하고 추후 업데이트!


## **APM툴(Application Performance Monitoring)**
- WebTune(미소 정보, 개발 장비에서 무료), Pharos(케이와이즈), Introscope(CA Wily)
- 애플리케이션의 장애 상황에 대한 모니터링 및 문제점 진단
- 서버의 사용자 수나 리소스에 대한 모니터링 가능
- 실시간 모니터링
- CPU수를 기반하여 가격 측정
- 자바 기반 클라이언트 프로그램은 분석이 불가능

## **프로파일링 툴(Profiling Tool, 시스템 문제 분석 툴)**
- JProfiler(JProbe, ej-technologies), YourKit(YourKit)
- 소스 레벨의 분석을 위한 툴
- 애플리케이션의 세부 응답시간까지 분석 가능
- 메모리 사용량을 객체나 클래스, 소스의 라인 단위까지 분석 가능
- 사용자수 기반의 가격 측정
- 자바 기반의 클라이언트 프로그램 분석 가능

## **Library**
- JMH, Caliper, JUnitPerf, JUnitBench, ContiPerf(그래프 결과 제공, ms단위 제공 X)
- Junit 자바 코드 테스트 
- JMH JDK를 오픈소스로 제공하는 OpenJDK에서 만든 성능 측정용 Library
응답시간 & 메모리 Profiling / GC(Garbage Collection)

System Class
- Static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)

 + 실은 여기도 크게 의미 없을거 같으니 여기까지만 하고 추후 업데이트! 