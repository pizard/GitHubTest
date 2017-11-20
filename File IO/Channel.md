# Channel
 - 정의
	 - 서버와 클라이언트간의 통신 수단
	 - 한 개 이상의 뚜렷한 입출력 작업을 수행할 수 있는 개방된 연결 수단(하드웨어 장비, 파일, 네트워크 소켓 혹은 프로그램 컴포넌트)
 - 특징
 	 - 기본 데이터형용 버퍼를 클래스로 제공
 	   ➜ 데이터 형에 맞는, 전용 메모리 공간을 갖고 있음
	 - 채널은 비동기적으로 닫히고 중단(interrupt)될 수 있다.
	   ➜ 한 스레드가 한 채널에서 하나의 입출력 작업으로 블록화하면 다른 스레드가 그 채널을 닫을 수 있다.
	   ➜ 한 스레드가 한 채널의 입출력작업으로 블록화되면 다른 스레드가 블록화된 스레드를 중단시킬 수 있다.
	   ➜ 즉 블로킹된 스레드 또한 언제든지 중지 시킬 수 있음
	   ➜ 소켓 채널 통신도 디폴트는 블록모드 이지만 'java.nio'패키지에서 제공하는 non-blocking 모드로 구현이 가능함
	   ➜ 읽기 쓰기를 동시에 할 수 있음
 	 - JVM의 도움을 받지 않고 C/C++과 같이 직접 메모리를 조작하는 네이티브 코드 프로그램의 접근방식을 지원하여 메모리 엑세스 속도가 빠름
	 - 다른 Thread가 Channel을 종료 시키면 블록된 스레드는 예외를 발생시킨다.
 	 - Multi Thread 접근에 대해 안전함
 - 인터페이스
 	 - 인터페이스의 이름중에 Byte라는 낱말이 들어가 있는데 이는 채널의 기본 입출력이 ByteBuffer임을 의미한다.
 	   ➜ CharBuffer, FloatBuffer를 사용하고 싶다면 asXXXBuffer()를 통한 필요



## java.nio.channels 인터페이스
 - **Channel**
 	 - 모든 채널 클래스류의 최상위 인터페이스
 	 - 모든 인터페이스들이 상속받으므로 Channel 인터페이스가 가진 메서드를 모두 사용할 수 있음
 	 1. `public boolean isOpen()`
 	 	 - 현재 채널의 상태가 오픈인지 아닌지 판단
 	 2. `public void close() throws IOException()`
 	 	 - 현재의 채널을 닫는다.
 - **InterruptibleChannel**
 	 - 블로킹 된 스레드(입출력)를 깨우는 기능
 	 1. `public void close() throws IOException()`
 	 	 - Channel 인터페이스의 close()와 다르게 blocking된 입출력에 대해 java.nio.channels.AsynchronousCloseException 예외를 발생시키는 방식으로 닫음
 	 	 - FileChannel, DatagramChannel, SocketChannel, ServerSocketChannel, Pipe.SinkChannel, Pipe.SourceChannel 클래스에서 구현 가능
 - **ReadableByteChannel**
 	 - 데이터를 읽어들이는 기능
 	 1. `public int read(ByteBuffer dst) throws IOException`
 	 	 - 채널의 데이터를 읽음(position ~ )
 	 	 - Error Message
 	 	 	 - NonReadableChannelException - 받을 채널을 읽지 못하는 경우 
			 - ClosedChannelException - 받을 채널이 닫혀있는 경우
			 - AsynchronousCloseException - read 작업의 진행 중, 다른 thread에 의해 이 채널이 닫힌 경우 
			 - ClosedByInterruptException - read 작업의 진행 중, 다른 thread가 우선 설정되어 이 채널을 닫고 그 이후에 진행하는 경우 
			 - IOException - 그 외의 입출력 에러가 발생한 경우
 - **WritableByteChannel**
 	 - 데이터를 쓰는 기능
 	 1. public int write(ByteBuffer src) throws IOException
 	 	 - 채널에 데이터를 출력 (허용 범위: position ~ limit)
 	 	 - return 값(int)는 출력하는 데이터의 수
 	 	 - Error Message
 	 	 	 - NonWritableChannelException - 보낼 채널으로 출력이 불가능한 경우
			 - ClosedChannelException - 보낼 채널이 닫혀있는 경우
			 - ClosedByInterruptException - write 작업의 진행 중, 다른 thread에 의해 Interrupt되어 이 채널을 닫고 Interrupt 상태가 설정되었을 경우
			 - IOException - 그 외의 입출력 에러가 발생한 경우
 - **ScatteringByteChannel**
	 - 여러 개의 버퍼를 읽는 기능
 	 - ReadableByteChannel의 하위 인터페이스
 	 1. public long read(ByteBuffer [] dsts) throws IOException 
 	 	 - ByteBuffer의 데이터를 읽어드림
	 2. public long read(ByteBuffer [] dsts, int offset, int length) throws IOException
 	 	 - ByteBuffer의 데이터를 offset에서 length만큼 읽어드림
 - **GatheringByteChannel**
	 - 여러 개의 버퍼를 출력하는 기능
 	 - WritableByteChannel의 하위 인터페이스
 	 1. public long write(ByteBuffer [] dsts) throws IOException 
 	 	 - ByteBuffer의 데이터를 Channel로 출력
	 2. public long write(ByteBuffer [] dsts, int offset, int length) throws IOException
 	 	 - ByteBuffer의 데이터를 offset에서 length만큼 Channel로 출력
 - **ByteChannel**
 	 - 데이터 읽기/쓰기 기능
 	 - ScatteringByteChannel와 GatheringByteChannel를 상속
 	 - 두개를 통합한다는 것 뿐 특별한 기능은 없음
 	 - FileChannel, DatagramChannel, SocketChannel 클래스에서 구현 가능

## java.nio.channels 클래스
 - **AbstractInterruptibleChannel**
 	 - 비동기적으로 외부에서 채널 클래스들의 작업을 중단시키는 기능(Non-Blocking)
 	 - 채널클래스의 최상위 클래스
 	 - java.nio.channels.spi 패키지, SPI(Service Provider Interface)
 	   ➜ 프로그래머가 제공하는 클래스로 기본 구현들을 수정 가능
 	 - InterruptibleChannel 인터페이스를 구현한 Abstract class
 	 - FileChannel, SelectableChannel 클래스에서 상속
 	 1. protected void begin()
 	 	 - 입출력 동작이 일어나기 전 호출
 	 2. void close()
 	 	 - 현재의 채널을 닫음
 	 3. protected void end(boolean completed)
 	 	 - 입출력 동작이 일어난 후 호출
 	 4. protected abstract void implCloseChannel() 
 	 	 - 현재 채널을 닫음
	 5. boolean isOpen()
	 	 - 현재 채널이 열려있는지 확인
 - **FileChannels**
 	 - 파일 입출력을 위한 채널
 	 - AbstractInterruptibleChannel를 상속받아 비동기 중단 가능
 	 - ByteChannel Interface를 구현해 읽기와 쓰기를 동시에 가능
 	 - abstract Class
 	   ➜ 스스로 인스턴스를 만들 수 없음
 	 - java.io패키지의 FileInputStream(읽기 가능), FileOutputStream(쓰기 가능), RandomAccessFile(읽기/쓰기 가능) 클래스의 getChannel()메서드를 통해 호출
 	 ```
 	 FileInputStream fis=new FileInputStream("파일명");
	 FileChannels fc=fis.getChannels();
	 ```
	 1. read()/write()
	 	 - 읽기/쓰기 기능, 전부 ByteBuffer를 인자로 받고 있어서 버퍼 기반의 파일 입출력가능
	 2. public abstract void force(boolean metaData) throws IOException
	 	 - FileChannels에서 쓰기는 버퍼의 내용을 바꾸는 것이므로 실제 파일에 적용할 때 사용
	 	 - 로컬 파일에만 적용
	 	 - true: 내용 + 최종 수정 시간 / false: 내용
	 3. public abstract long size() throws IOException
	 	 - 파일의 크기 반환
	 4. public abstract FileChannel truncate(long size) throws IOException
	 	 - 채널의 크기(?) 설정, 
	 5. transferFrom(ReadableByteChannel src, long position, long count)
	 	 - FileChannels에 대해 ReadableByteChannel인스턴스인 채널(src)로부터 읽어들인다.
	 	 - read()메서드보다 빠름
	 6. transferTo(long position, long count, WritableByteChannel target)
	 	 - FileChannels에 대해 WritableByteChannel 인스턴스(target)로 데이터를 출력한다.
	 	 - write()메서드보다 빠름
	 7. public final FileLock lock()
	 	 - 파일에 Lock을 걸어서 다른 프로세스나 스레드의 접근을 막는 메서드
	 	 - 호출시 FileLock클래스의 인스턴스 리턴
	 8. public abstract FileLock lock (long position, long size, boolean shared)
	 	 - (position ~ size)까지 일부 영역을 Lock하는 기능
	 	 - shared, true: 공유 FileLock(2개 ↥), false: 비공유 FileLock(독점)
	 9. public final FileLock tryLock()
	 	 - 다른 Thread에서 Lock을 걸고 있는 경우 null을 리턴하여 lock()메서드가 블로킹되는 것을 방지
	 10. ※ 파일 Lock 풀기
		 - release() 사용.-> 이 FileLock이 release()된것인지 아닌지는 isValid()로 알 수 있다.
		 - FileLock에 연결된 하부 채널이 close()된 경우
	 	 - 자바가상머신이 종료된경우
	 11. public abstract MappedByteBuffer map(FileChannel.MapMode mode, long position, long size)
	 	 - 파일의 영역을 position의 위치에 size만큼 직접 메모리에 매핑
	 	   ➜ 자주 읽거나 쓰는 파일에 유리
	 	 - MappedByteBuffer의 리턴형을 사용하는데 Heap이 아닌 Java가 관리하는 일반 메모리 영역을 따로 잡음
	 	   ➜ 준비시간이 많이 걸림
 	       ➜ 사이즈가 큰 파일에 유리
 	     - mode의 경우 MappedByteBuffer를 파일로 사용할 때 어떤 방식으로 사용할 지 설정, 상수로 이미 선언되어 있음
 	     	 - READ_ONLY: 읽기전용
 	     	 - READ_WRITE: 읽기/쓰기
 	     	 - PRIVATE: copy-on-write, 읽기/쓰기가 가능하지만 쓰기의 경우 복사본을 만들어 변화내용 적용



# ///////////////////////////////////// 진행 중 /////////////////////////////////////



## [NIO] JAVA NIO 의 ByteBuffer와 Channel 클래스 사용하기!
 
### JAVA NIO - channel은 왜 그리고 언제 쓰나?

### 채널을 사용했을 때의 장점
 - 
 - 

### 소켓 채널과 관련하여 자바는 3종류의 패키지를 제공한다.
 - 'java.nio'패키지는 바이트 버퍼와 관련된 클래스를 지원한다. 소켓 채널 프로그램은 스트림을 사용할 수 없는 대신 바이트 버퍼를 지원한다.
 - 'java.nio.channels'패키지는 하드웨어 디바이스, 파일, 네트워크 소켓 등에 입출력 작업을 할 수 있는 클래스들을 지원한다.
 - 'java.nio.charset'패키지는 바이트와 문자의 변환을 지원하는 인코딩과 디코딩 클래스들을 제공한다.

### 소켓 통신의 문제점
 - 메서드 실행시 블록된다는 점
 - 스트림이나 스레드처럼 빈번하게 데이터를 복사하고 사용 후 바로 소멸하는 경우 많은 데이터가 가비지 컬렉션의 대상이 되며 빈번하게 이루어지고 그만큼 성능 저하가 발생한다.
 - non blocking으로 사용하는 수켓 채널은 외부 호스트와 연결하는 소켓 또는 read()메서드의 수만큼 스레드를 만들어 처리하는 것이 아니라 채널관리자(Selector)를 사용하여 실제 입출력이 일어난 구간을 알려주면 그 때 처리
 - 즉 모든 채널과 입출력에 대해 각각의 독립적 스레득 필요하지 않음

### 결론
 - 서버처럼 외부 클라이언트로부터 접속 요구가 많은 환경에서 소켓 채널통신이 소켓 프로그램보다 좋은 성능을 낼 수 있음

### 더 공부할 것
 - Buffer가 도대체 뭔지...ㅜ
 - 소켓 복습 해야할 것 같은뎅...

### 참고
 - [DEVSTORY](http://eppffy.tistory.com/10 "DEVSTORY")
 
 - [Minsub's Blog](http://gyrfalcon.tistory.com/entry/Java-NIO-Channel "[Java] NIO Channel [펌]")
	 - 채널(channel)
	 - java.nio.channels 인터페이스
	 - java.nio.channels 클래스
	 - 갓갓가ㅏ라갓 어디서 퍼오셨는지 사랑합니다-

 - [One Day One Line / ByteBuffer vs Channel ](http://killsia.tistory.com/entry/NIO-JAVA-NIO의-ByteBuffer와-Channel로-File-Handling에서-더-좋은-Perfermance-내기?category=426417 "ByteBuffer vs Channel")

 - [One Day One Line / IO vs NIO Performance](http://sooin01.tistory.com/entry/IO-vs-NIO-performance-compare-성능-비교 "IO vs NIO Performance")



### 공부할 것
 - 채널(channel) > java.nio.channels 인터페이스 > ScatteringByteChannel & GatheringByteChannel
	 - IO에서는 파일을 읽는 경우 read의 파일을 Stream에 넣고, 파일에 쓰는 경우 Stream을 파일에 넣는데 Channel은 왜 Parameter가 둘다 ByteBuffer냐...? ㅇ.ㅇ...
 - 채널(channel) > java.nio.channels 클래스 > AbstractInterruptibleChannel
 	 - Abstract class가 정확하게 뭐지? 다른 데서도 되게 많이나오던데 추상 클래스...
 - 채널(channel) > java.nio.channels 클래스 > FileChannels
 	 - 이거 왜 Stream을 통해서 구현되는거지? Channel이랑 Stream이랑 대립되는 방식이 아니었나? I/O에서 발전된 형태가 같이 넣은건가? 그럼 Stream이랑 Buffer랑 대립되는 건가? 채널은 통로... Stream은 방식..? ByteBuffer는 결과물? ㅎㅏ... 복작복작하네ㅡㅡ
 	 ➜ https://www.quora.com/What-is-the-difference-between-streams-and-buffers-in-JavaScript-Node-js
 	 ➜ Buffer와 Stream이 대립되는 방식, 버퍼는 어딘가로 옮길때 램에 일시적으로 할당, Stream은 버퍼링 방식이 아닌 하나의 덩어리 단위로 다룸
 	 - 버퍼링 방식 아는데... 기억이 잘 안나... 복습해야겠당ㅜㅜ 무튼 일단 다시 위로...
 - 채널(channel) > java.nio.channels 클래스 > FileChannels > public abstract FileChannel truncate(long size) throws IOException
 	 - 이거 크기라는게 Buffer가 지날 수 있는 Channel(통로)의 크기인건가? 출력 할 때 파일의 크기의 limit을 정하는건가?
 - 채널(channel) > java.nio.channels 클래스 > FileChannels > transferTo / transferFrom
 	 - 이거 왜 read/write보다 빠른거야? 차이는 뭐고 성능 표보니까 GatheringByteChannel/ScatteringByteChannel이 제일 빠르던데 성능표에서는 다수의 파일이었던건가..?
 - 채널(channel) > java.nio.channels 클래스 > FileChannels > FileLock 부분
 	 - FileLock로 파일 접근을 막으면 막는거지 boolean shared을 왜 넣은걸까..? true면 안막고 false면 막고? 이건 채널에 걸어주는건가? 뭔가 알거같으면서 모를걸 같기도 하고ㅜㅜ tryLock은 또 뭔소리여..
 	 ➜ 'FileLock에 연결된 하부채널'이라는 문장을 보니까 FileLock은 채널에 걸어주는거고 공유 FileLock의 경우 하부 채널만 사용할 수 있도록 하는거 같지..?
