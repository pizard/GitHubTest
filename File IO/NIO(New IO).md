# NIO(New IO)
### NIO란?
 - 정의
 	 - 강력한 I/O 오퍼레이션 기능을 제공하는 자바 프로그래밍 APO
 - 특징
 	 - J2SE 1.4에서 표준 I/O를 보완하기 위해서 소개 되었음
 	 - 자바 7에서 NIO2라 불리는 새로운 파일시스템 API 제공

### NIO 패키지
 - `java.nio`
 	 - 바이트 버퍼와 관련된 클래스 제공
 - `java.nio.channels`
 	 - 입출력 작업을 할 수 있는 클래스 제공(하드웨어 디바이스, 파일, 네트워크 소켓)
 - `java.nio.charset`
 	 - 바이트와 문자의 변환을 지원하는 인코딩과 디코딩 클래스 제공

## IO vs NIO
### 자바 I/O
 - 디스크 파일 읽기
 	 1. 커널에 명령 전달
 	 2. 커널은 시스템 콜(System Call)을 사용해 디스크 컨트롤러가 [디스크] > [커널 영역 버퍼]로의 데이터 저장
 	 	 ➜ 디스크 컨트롤러가 DMA 기술을 사용하기 때문에 CPU를 사용하지 않음
 	 3. [커널 영역 버퍼] > [프로세스(JVM) 영역 버퍼]로의 데이터 전달
 	 	 ➜ CPU를 사용 
 - 특징
	 - Java IO는 커널 영역의 버퍼를 직접 건들지 못함
	 - 스트림 데이터가 처리되기 전까지 스트림을 사용하는 자바 스레드는 Blocking 
 - 개선점
	 - [커널 영역] > [프로세스 영역] 복사 제거
		 - 커널 영역의 버퍼에 저장된 데이터를 직접 사용
		 ➜ 복사 시간을 단축(2단계 -> 1단계)
		 ➜ GC도 불필요
		 ➜ CPU자원 최소화
	 - [디스크] > [커널 영역 버퍼] 복사에서 프로세스 영역의 블로킹 > 논블로킹 형식 변경
		 - 운영체제는 효율을 높히기 위해 최대한 많은 양의 데이터를 커널 영역의 버퍼에 저장한 후 프로세스 영역의 버퍼로 전달
		 ➜ 디스크의 파일 데이터를 커널 영역 안의 버퍼로 모두 복사할 때 까지 자바 프로세스가 블로킹 된다. 좀 더 정확하게는 파일 읽기를 요청한 자바 스레드가 블로킹 됨

### NIO
 - 디스크 파일 읽기
 	 1. 유저 프로세스는 recvfrom함수를 통해 커널에 명령 전달
 	 2. 커널은 상대방의 데이터를 전송 받아서 recvBuffer에 저장
 	 3. recvBuffer가 비어있어서 유저 프로세스가 받을 수 있는 정보가 없는 경우
 	 	 ➜ recvfrom함수는 아직 진행중이란 의미로 "EWOULDBLOCK"을 리턴
 	 	 ➜ "EWOULDBLOCK" 결과를 받은 유저프로세스는 다른 작업 진행
 	 4. recvBuffer에 받을 수 있는 데이터가 있는 경우
	 	 ➜ recvfrom함수는 읽을 수 있는 데이터를 복사해주고 길이와 함께 반환
 	 	 ➜ recvBuffer는 커널의 메모리에 적재되어 있어 메모리간 복사로 I/O보다 훨씬 빠른 속도로 데이터를 전달할 수 있음
 - 도입된 기술
 	 - 버퍼(Buffer) 사용
 	 	 - 1.4이전의 I/O에서는 모든 메모리를 JVM Heap 영역에서 관리하였고 비효율적 보사과정을 거치고 블로킹이 됐었지만 Buffer를 통해 시스템 메모리에 직접 접근할 수 있게 되었음
 	 - 채널(Channel) 사용
 	 	 - 1.4이전의 Stream에서는 단방향 통신만 가능했지만 Channel을 통해 양방향으로 읽고 쓸 수 있게 되었음
 	 	 - Native IO 이용 가능
 	 - 셀렉터(Selector) 사용
 	 	 - 1.4이전 에서는 클라이언트를 관리하기 위해 하나당 하나의 쓰레드를 생성해서 처리했지만 셀렉터를 통해 하나의 스레드로 다수의 동시 사용자를 처리할 수 있음

### Input/Output Stream
 - Stream
 	 - 사전적 의미로 무엇인가의 끊기지 않는 흐름
 	 - Java I/O에서 데이터의 순차적 흐름(바이트 문자, 객체)


## Java NIO는 생각만큼 non-blocking 하지 않다
 - Java NIO(New IO)를 Non-blocking IO의 줄임말로 잘못 아는 사람들도 많음
 - IO : NIO = Stream : Channel
 	 - IO와 NIO의 관계는 Stream과 Channel의 관계와 비교가 된다.
 	 - 이를 이해하기 위해 Stream 과 Channel의 차이점을 먼저 알아보자.

### Stream vs Channel
 - Stream
 	 - InputStream, OutputStream을 통한 단방향(one-way) 데이터 통로
 	 - 기본적으로 byte 또는 byte[]이고 작업 지시후 끝나야 다음 작업이 진행되는 blocking 방식
 - Channel
 	 - 데이터가 흘러다니는 통로라는 점에서 Stream과 비슷한 역할을 하지만 동작방식에서 차이를 보임
 	 - 양방향(two-way) 통로로 Input/Output을 구분하지 않고 ByteChannel, FileChannel을 만들어 사용
 	 - 언제나 Buffer을 통해서만 데이터를 읽고 쓸 수 있음
 	 - Non-blocking방식이 가능하다(하지만 언제나 Non-blokcing방식은 아니고 **'Non-blocking 방식도 가능하다'**는 것)

### File.new--()는 모두 blocking 방식이다.
 - java.nio.Files는 NIO 중에서 File I/O를 담당하는데 모두 Blocking 방식임
 	 - `Files.newBufferedReader()`
 	 - `Files.newInputStream()`
 	 - `Files.newBufferedWriter()`
 	 - `Files.newOutputStream()`
 - 위의 Method들은 결국 Files.newByteChannel()을 통해 생성되는 SeekableByteChannel을 바탕으로 데이터를 읽고 쓰게되는데, 이 SeekableByteChannel과 WritableByteChannel은 모두 blocking방식으로만 동작하는 Channel

### 어차피 blocking인데 FileI/O에 뭐하러 NIO를 쓰는가?
 - 성능
 	 - File I/O에 사용되는 Channel이 blocking모드로 동작하기는 하지만, 데이터를 Buffer를 통해 이동시키므로 기존의 Stream I/O에서 병목을 유발하는 몇가지 레이러를 건너뛸 수 있음
 	 - Buffer를 사용하면 DMA(Direct Memory Access)를 활용할 수 있다.
 	 - 기존 I/O의 단점을 생각하면 여러 성능적 문제를 고려하더라도 NIO를 쓸 수 있다면 쓰는 게 좋음

### 공부할 것
 - Channel..? Stream..?
 - NIO2가 쓸만한건가? 진짜 많이 쓰나? JAVA에서도 쓰이나?ㅜㅜㅜ 왜 이렇게 정보가 없을까...
 - DMA가 뭐지..?
 - Selector랑 Channel을 이용해서 한다는데 Selector가 뭐지..?ㅜㅜ

### 참고
 - [HomoEfficio](http://homoefficio.github.io/2016/08/06/Java-NIO는-생각만큼-non-blocking-하지-않다 "HomoEfficio")
 	 - Java NIO는 생각만큼 non-blocking 하지 않다.
 	 - DMA [eincs](http://eincs.com/2009/08/java-nio-bytebuffer-channel-file/ "eincs")
 - [회색꿈](http://eppffy.tistory.com/12 "회색꿈")

 - [DEVSTORY](http://graydream.tistory.com/73 "DEVSTORY")
 	 - NIO 패키지

 - [Gyrfalcon](http://gyrfalcon.tistory.com/entry/JAVA-NIO "Gyrfalcon")
 	 - NIO

