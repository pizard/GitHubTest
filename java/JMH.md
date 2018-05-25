# JMH(Java Microbenchmark Harness)
## Benchmark Modes, @BenchmarkMode
 - 기능
 	 - 무엇을 측정할지 확인
	 - Parameter
	 	 - Mode
	 	 - Throughput(default)
	 	 	 - 1초당 benchmark method 동작하는 횟수를 측정
	 	 - Average Time
	 	 	 - benchmark method가 소요하는 평균 시간 측정
	 	 - Sample Time
	 	 	 - max/min을 포함하여 benchmark method가 얼마나 걸리는지 측정
	 	 - Single Shot Time
	 	 	 - 단일 benchmark method가 소요하는 시간 측정(cold start에 유리, no JVM warm up)
	 	 - All
	 	 	 - 위의 지표들을 모두 측정
 	 - ex. `@BenchmarkMode(Mode.Throughput)`

## Benchmark Time Unit,  @OutputTimeUnit
 - 기능
 	 - benchmark 결과를 나타내는 시간 단위 선택
 - Parameter
 	 - java.util.concurrent.TimeUnit
 	 	 - NANOSECONDS / MICROSECONDS/ MILLISECONDS / SECONDS / MINUTES / HOURS / DAYS
 	 - ex. `@OutputTimeUnit(MINUTE)`

## Benchmark State Class, @State
 - 기능
 	 - benchmark code에 필요한 initialize 변수들을 측정 코드에 넣고 싶지 않은경우 사용
 	 - state class를 통해 initialize 변수(state variable)들을 지정
 - 선언 규칙
 	 - JMH state class들은 public으로 선언해야 한다.
 	 - 만약 class가 nested class라면 static으로 선언해야 한다.
 	 - class들은 public no-arg 생성자 가져야만 한다.(parameters가 없음)
	 - 위의 규칙들이 지켜지고 @State annotation을 가진 class들만 JMH가 state class로 인식할 수 있음
 - Parameter
	 - Scope
	 	 - 종류
		 	 - Thread
		 	 	 - 동작하고 있는 benchmark를 Thread 단위로 상태 객체를 생성한다.(개별)
		 	 - Group
		 	 	 - 동작하고 있는 benchmark들이 Thread Group 단위로 상태 객체를 생성한다.(Group)
		 	 - Benchmark
		 	 	 - 동작하고 있는 모든 Benchmark들이 동일한 상태객체를 공유한다.(전체)
	 - ex. `@State(Scope.Thread)`

### Benchmark State Method, @Setup/@TearDown
 - 기능
 	 - Setup
 	 - TearDown
 	 - JMH에게 benchmark method 실행전 state object를 설정하기 위해 해당 method가 호출되어야 한다는 것을 알려줌
 2. @TearDown
 	 - JMH에게 benchmark method 실행후 state object를 clean up(tear down)하기 위해 호출되어야 한다는 것을 알려줌
 3. Parameter
	 - Level.Trial
	 	 - 모든 동작에 대한 benchmark를 실시한다.
	 - Level.Iteration
	 	 - 각각의 반복마다 benchmark를 실시한다.
	 - Level.Invocation
	 	 - 해당 method가 소환될때마다 benchmark를 실시한다.


### 참고
 - [제이제이랩](http://jayjaylab.tistory.com/26 "benchmarking 코드를 작성해 보자 #1")
 - [jenkov](http://tutorials.jenkov.com/java-performance/jmh.html#your-first-jmh-benchmark "JMH - Java Microbenchmark Harness")

