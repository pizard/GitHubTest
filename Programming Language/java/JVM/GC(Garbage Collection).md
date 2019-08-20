- GC(Garbage Collection)
 - 특징
  1. 사용하지 않는 메모리 자동 회수
  2. 전담 Thread가 별도로 존재
 - 종류
  - Minor GC
   - 기능
    - 새로 생성된 객체가 위치하는 Young 영역에서 발생
   - 구성
    - Eden(1) + Survivor(2)

  - Major GC(Full GC) : Old
   - 기능
    - Young 영역에서 살아남은 객체가 이동된 Old 영역에서 발생
   - 과정
    1. Mark : Old 영역에서 사용/비사용 식별
    2. Sweep : Heap 앞 부분부터 비사용 객체 삭제
    3. Compact : 삭제된 객체의 공간 정리
 - 방식
  - Serial GC
   - Mark - Sweep - Compact 알고리즘 사용
   - 하나의 Thread가 처리
   - 코어 수가 적고 간단한 프로그램에 사용
  - Parallel GC
   - Minor GC 여러개의 Thread 사용
   - Major GC의 경우 하나의 Thread 사용
  - Paarallel Old GC
   - Minor, Major GC 모두 여러 개의 Thread 사용
   - Parallel GC보다 좋기 때문에 Java 7 이후 자동으로 이것을 선택
  - CMS GC (Concurrent Mark & Sweep GC, Java 9 이후 Deprecated)
   - Stop The World 시간을 최소화 하기위해 사용
   - 아래의 과정 중 Initial Mark와 Remark 단계에서만 STW
   - 어플리케이션의 응답속도가 중요한 경우 사용
   - Memory, CPU 사용률이 높음
   - Compaction 단계가 제공되지 않음
   - 과정
    1-1. Initial Mark : 클래스 로더에서 가장 가까운 객체중 살아있는 객체 검색
    1-2. Concurrent Mark : 방금 확인한 객체들이 참조하는 객체를 확인 함
    1-3. Remark : Concurrent Mark단계에서 새로 추가되거나 참조가 끊긴 객체 확인
    2. Concurrent Sweep : Garbage 정리 작업 수행
  - G1 (Garbage First) GC
   - 가장 최신의, Default GC 방식(Java9 이후)
   - multi-processor, large memories를 가진 시스템을 대상으로 만듬
   - Heap > Region이라는 영역으로 구분하여 사용(1-32Mb)
   - 역할또한 동적으로 변환됨
 - Option
  - MaxTenuringThreshold : Minor GC 후에 survivor 영역에 머무를 수 있는 최대 횟수
   - Parallel GC 기준 Default 15
  - UserSerialGC
  - UseParallelGC
  - UseParallelOldGC
  - ParallelGCThreads : GC Thread 개수 지정
  - UseConcMarkSweepGC
  - UseCMSInitiatingOccupancyOnly : 사용 여부
  - CMSInitiatingOcupancyFraction : GC가 시작되는 메모리 사용량 비율 지정(ex 92 -> 92%)
  - About G1 GC
   - UseG1GC
   - G1HeapRegionSize : 영역의 크기 지정
   - MaxGCPauseMillis : 최대 GC Pause 시간에 대한 목표치, 큰 의미 x...
 - GC 로그 출력
  - -verbose:gc : GC발생 시 관련 Standard Output에 출력
  - -Xlog:gc:파일명 : 해당 파일에 로그 출력
 - GC 상세 로깅
  - XX:+PrintGCDetails
 - 시간 관련 로그 출력(Remove... Default로 들어감)
  - XX:+PrintGCTimeStamps : JVM시작 기준으로 몇초의 시간이 지났는지
  - XX:+PrintGCDateStamps : 로그를 남기는 시간 정보 출력
- Tool
 - GC viewer
  - 오픈소스 기반의 GC 로그 분석기
 - IBM Pattern Modeling and Analysis Tool for Java Garbage Collector
  - IBM developerworks에서 개발해 공개한 GC 로그 분석기
 - HP jmeter
  - HP에서 개발 배포하는 자바 성능 분석 도구

- STW(Stop The World)
 - 기본적으로 GC 동작 중에는 어플리케이션이 멈춤


남에게 폐가 안되어야 핥네데...
