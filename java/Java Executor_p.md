# **Java Executor**

 - 개요
 	1. 웹서버와 같이 다수의 요청을 처리해야 하는 어플리케이션을 개발해야 하는 경우 쓰레드를 생성해야 하는데 모든 요청에 쓰레드를 생성한다면 다음과 같은 문제점이 발생할 수 있음
 		 - 쓰레드의 생성 및 종료에 따른 오버헤드 발생
 		 - 생성되는 쓰레드의 수로 인한 OutOfMemory Error가 발생
 		 - Thread Scheduling에 따른 오버헤드 발생
 	2. 이를 해결하기 위해 Thread Pool을 사용하여 동시에 실행할 수 있는 Thread의 개수를 제한하고 효율적으로 사용해야함
 	3. Java5에서 새롭게 추가된 Concurrenct API는 작업을 생행하기 위한 Executor Interface를 제공하며 다양한 Executor 구현체를 제공하고 있음

 - 특징
 	 - Thread Pool 사용
 	 - 무거문 Thread 미리 할당 가능
 	 - Task와 Thread를 생성하고 관리하는 것을 분리
 	 - Thread Pool안의 Thread는 한번에 하나씩 여러 Task를 실행
 	 - Task Queue를 이용해 Task를 관리
 	 - Executor Service가 더 이상 필요 없으면 중지
 	 - Executor Service가 멈추면 모든 Thread도 중지 
     
     

<img width="538" height="365" src="./image/Executor API.png"></img>
### **주요 클래스와 인터페이스**
 - Executor Interface
 	 - package: java.util.concurrent.Executor
 	 - 특징
 		 - 작업등록(task submission), 작업실행(task Execution)을 분리하는 표준적인 방법이며 각 작업은 Runnable의 형태로 정의 
 		 - 
 	 - 제공된 작업(Runnable 구현체)를 실행하는 객체가 구현해야 할 인터페이스
  	 - Task와 Thread를 분리하고 실행을 담당
  	 - execute() 메소드로 전달받은 작업(Runnable 인스턴스)를 알맞게 실행
  	 	`void execute(Runnable task);`
 - Executor Class
 	 - package: java.util.concurrent.Executors
 	 - ThreadPool Method
 	 	`ExecutorService newFixedThreadPool(int threadCount) // threadCount: Thread수`
 	 	 - 처리할 작업이 등록되면 그에 따라 실제 작업할 Thread를 하나씩 생성
 	 	 - 항상 일정한 Thread개수를 유지
 	 	 - Thread가 유휴 상태이더라도 제거하지 않고 유지
 	 	 - 생성할 수 있는 Thread의 최대 개수 제한
 	 	 - 실제 생성되는 객체는 ThreadPoolExecutor 객체
 	 - `ExecutorService newCachedThreadPool()`
 	 	 - 
 - Executor Service Interface
  	 - Executor Interface를 확장하며 Life Cycle 제어

# 어차피 사용하지도 않는거 금방 까먹을거 같아서 나중에 Thread를 사용할 때 다시 정리하겠습니다ㅜㅜ

### 6. 참고
 - [자바캔(Java Can Do IT)](http://javacan.tistory.com/entry/134 "자바캔(Java Can Do IT)")
 - [마이너의 일상](http://tomining.tistory.com/10 "마이너의 일상")



