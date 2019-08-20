Java Stack 분석
- 필요한 경우
 1. 전체 어플리케이션 응답시간이 느려지는 경우
 2. 일부 또는 특정 어플리케이션의 응답시간이 느려지는 경우
 3. 특정 어플리케이션의 CPU 사용률이 높은 경우
- 쓰레드 덤프 생성 방법
 1. Java Process의 PID 알아내기
 2. 쓰레드 덤프 생성
  - jstack 이용 : stack <PID>   in Oracle
  - kill 명령어 이용 : kill -3 <PID> or kill -QUIT <PID>  in IBM
  - 서비스로 등록된 SendSignal <PID> 이용 in Windows
 3. 쓰레드 덤프 생성 위치
  - Oracle : STDOUT
  - IBM : ㅁ_ㅁ...
 2-2. Core 덤프 생성
  - 시스템에 많은 부하를 주기 때문에 운영환경에서는 사용 권장하지 않음
  - ulimit -c : 생성할 core파일 크기 제약 확인
  - gencore <PID> : 강제 core 덤프 발생
  -
- 쓰레드
 - Thread Contention
  - 두 개 이상의 쓰레드가 공유 자원을 사용할때 경합이 발생하고 데드락(Deadlock)이 발생할 수 있음
  - Java는 쓰레드 동기화를 위해 Monitor를 사용하며 이는 동시에 한개의 쓰레드만 소유할 수 있음

- Tool
 - IBM Thread and Monitor Dump Analyze for Java
  - 실행 방법
   - java -Xms512m -jar jca457.jar
  - Thread Detail
   - 전체 쓰레드들의 상태와 call stack 정보
  - Monitor Detail
   - lock 점유 및 대기 상태인 쓰레드들 간의 관계
  -
 - Stuck 상태
  - 쓰레드가 Runnable 상태로 원격 서버로붙의 응답을 장시간 대기하는 경우
 - 지정된 시간 이상 Stuck 상태가 지속된다면 Interrupt 수행
