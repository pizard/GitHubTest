# Selector
 - 정의
 	 - 하나의 쓰레드에서 다중의 채널로부터 들어오는 입/출력 데이터를 처리할 수 있도록 해 주는 멀티 플렉서, 논블럭킹 입출력을 위한 핵심 요소
 	 - 여러 SelectableChannel을 자신에게 등록하게 하고 등록된 Selectable Channel의 이벤트 요청들을 나눠서 적절자에게 보내 처리하는 것
 - 탄생 배경(Blocking 방식의 단점)
 	 - OS에서 Thread들 간 Context-switching은 높은 비용과 메모리 소모를 요구
	   ➜ Selector를 통해 하나의 Thread만 사용
	 - 언제 클라이언트가 요청 할 지 모르기 때문에 accept(), read()등에서 Blocking되었음
	   ➜ SocketChannel 당 하나의 스레드가 할당
	   ➜ 연결된 클라이언트의 수가 과도하게 늘어나면 기능저하 문제가 발생
	   ➜ 그동안은 스레드 풀을 통해 해결
 	 - Selector가 없는 Channel 방식에서는 accecpt(), read()등의 Method에서 블로킹 되지 않고 바로 리턴 하기 때문에 아래의 경우 클라이언트가 연결 요청을 보내기 전까지 무한루프를 돌기 때문에 CPU가 과도하게 소비 될 수 있음
	  ```
	  	while (true) {
    		SocketChannel socketChannel = serverSocketChannel.accept();
    		...
		}
	  ```
 - 특징
 	 - Mulltiplex IO 가능(필수는 아니고 효울적임을 의미)
 	   ＊Multiplex IO: 단 하나의 스레드로 동시에 많은 IO채널들을 효율적으로 관리하여 좀 더 적은 CPU와 자원을 소모
 	 - selector에 등록할 수 잇는 채널은 SelectableChannel의 하위 채널만 가능한데 non-blocking 설정 된 것만 가능
 - 구성
 	 - SelectableChannel 클래스 : 채널로서 관리대상
	 - Selector 클래스 : 채널 관리자
	 - SelectionKey 클래스 : 채널들을 다룰때 필요한 정보
	 - non-blocking I/O의 지원을 해줌 	 
 - 동작 방식
 	 1. Channel은 Selector에 자신을 등록할 때 작업 유형의 키(SelectionKey)로 생성하고, Selector의 관심키셋(interest-set)에 저장
 	 2. 클라이언트가 처리 요청을 하면 Selector는 관심키셋에 등록된 키 중에서 작업 처리 준비가 된 키를 선택해 키셋(selected-set)에 별도로 저장
 	 3. 작업 스레드가 선택된 키 셋에 있는 키를 하나씩 꺼내와 키와 연관된 채널 작업을 처리
	 4. 작업 스레드가 선택된 키 셋에 있는 모든 키를 처리하게 되면 선택된 키셋(selected-set)은 비워짐
	 5. Selector는 다시 관심키셋에서 작업 처리 준비가 된 키들을 선택된 키셋(selected-set)을 채움


### Selector 클래스
 - SelectableChannel 관리
 - SelectionKey의 인스턴스로 관리
 - method()
 	 - public static Selector open()
 	 	 - selector를 얻는다
 	 	 - 사용 예시
	 	 	 - `Selector selctor = Selector.open()`
	 - public abstract void close()
 		 - 셀렉터 자신에게 등록된 Selectionkey들을 모두 유효하지 않게 만든 후 모든 자원 릴리즈
	 - public abstract int select() / select(long timeout) / selectNow()
	 	 1. select() : 최소한 하나의 채널이 준비 될때까지 블로킹
	 	 2. select(long timeout) : 최대 timeout만큼 블로킹
	 	 3. selectNow() : 호출 즉시 리턴, 채널이 없는 경우 0을 리턴
	 	 	 - Selector 구동, 관심 키셋에 저장된 SelectionKey로부터 작업 처리 준비가 되었다는 통보가 올 때까지 대기
	 	 	 - 리턴 값은 준비가 된 SelectionKey의 수
	 - public abstract Selector wakeup()
 	 	 - 블로킹되어 있는(select()) Selector를 즉시 리턴하고 이를 깨워줌
 	 - public abstract boolean isOpen()
 	 	 - selector가 열려있는지 여부를 확인
 	 - public abstract Set keys()
 	 	 - Selector에 Channel이 등록될때 생성된 SelectionKey를 Set객체로 리턴
 	 - public abstract Set selectedKeys()
	 	 - Selector에 등록된 SelectionKey들중 동작이 일어난(Selected) SelectionKey들을 Set객체로 리턴



### SelectableChannel 클래스
 - 모든 소켓 채널들의 슈퍼 클래스
 - Selector에 의한 관리나 Non-Blocking I/O를 위한 기본적 기능을 가진 abstract class
 - AbstractInterruptibleChannel를 상속받아 비동기 중단 가능, Non-blocking I/O가능
 - Method()
 	 - public final SelectionKey register(int ops)		// 수정
 	 - public final SelectionKey register(Selecetor sel, int ops) // 등록
 	 - public final SelectionKey register(Selecetor sel, int ops, Object att)	
 	 	 - 정의
	 	 	 - 채널을 Selector(sel)에 등록/수정 + 어떤 입출력 동작(ops)을 할지 지정
 	 	 - 사용예시
	 	 	```
	 	 	1. SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
 		 	2. SelectionKey selectionKey = socketChannel.register(SelectionKey.OP_WRITE);
 	 		```
 	 		 - serverSocketChannel 채널의 작업 유형 정보를 담은 SelectionKey를 생성하고 selector에는 관심 키셋을 저장하며 Selectionkey 리턴
 	 	 - 특징
	 	 	 - Channel을 Non-blocking모드로 설정 필수
	 	 	 - 하나의 SelectableChannel을 여러 개의 Selector에 등록 불가
 	 	 - Parameter
	 	 	 - sel: selector 명
	 	 	 - ops: 채널의 작업 유형
	 	 	 	 - SelectionKey의 상수들
	 	 	 	 - OP_ACCEPT : 연결 수락
	 	 	 	 - OP_CONNECT : 서버 연결
	 	 	 	 - OP_READ : 데이터 읽기
	 	 	 	 - OP_WRITE : 데이터 쓰기
	 	 	 - att: 부가적으로 필요한 객체, 정보(필수값 x)
	 - public abstract boolean isRegistered()
	 	 - 현재 이 채널이 selector에 등록 되어 있는지를 판단
	 - public abstract SelectableChannel configureBlocking (boolean block)
	 	 - 채널의 입출력 모드를 선택한다. true: blocking I/O, false: non=blocking I/O
	 - public abstract boolean isBlocking()
	 	 - 현재의 채널의 입출력 모드를 확인(blocking/non-blocking)
	 - public abstract SelectionKey keyFor(Selector sel)
	 	 - selector에 해당 채널이 등록되어 있는지 확인
	 - public abstract int validOps()
	 	 - 현재 채널의 입쳘력 동작을 리턴(read/write/accept/connect)
	 	 - 서버 소켓 채널의 경우 OP_ACCEPT만 가능 

### SelectionKey 클래스
 - 특정 채널과 셀렉터 사이의 등록 관계 캡슐화
 - SeletableChannel을 선택하는데 기준이 되는 동작(ops), 부가정보(att), 연결되어 있는 Selector를 함께 표현하는 정보 클래스
 - method()
 	 - public abstract int interestOps()
 	 	 - 해당 동작(ops)들 리턴
 	 - public abstract SelectionKey interestOps(int ops)
 	 	 - 해당 동작(ops)를 지정
 	 - public final boolean isAcceptable() / isConnectable() / isReadable() / isWritable()
 	 	 - 해당 동작들의 유효성 점검
 	 - public final Object attach(Object ob)
 	 	 - 셀렉션키에 참조할 정보 객체(att) 추가
 	 - public final Object attachment()
 	 	 - 첨부된 정보(att) 객체를 리턴
 	 	 - 사용예시
 	 	 ```
		 	 // 객체 첨부하기
		    Client client = new Client(socketChannel);
		    SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
		    selectionKey.attach(client);
		    // 첨부된 객체 얻기
		    if (selectionKey.isReadable()) {
		        Client client = (Client) selectionKey.attachment();
		    }
	 	 ```
	 - public abstract SelectableChannel channel()
	 	 - 연결된 SelectableChannel 인스턴스를 리턴
	 - public abstract Selector selector()
	 	 - 연결된 Selector 인스턴스를 리턴
	 - public abstract void cancel()
	 	 - SelectionKey를 해당 Selector에서 삭제 후 취소 키셋으로 이동
	 	 - SelectionKey가 삭제되어 Garbage Collection 대상이 되더라도 첨부 객체는 남아 있음
		 ➜ 꼭 Key 삭제시 함께 삭제해야 함


### 참고
 - [Minsub's Blog](http://gyrfalcon.tistory.com/entry/Java-NIO-Channel "[Java] NIO Channel [펌]")
 - [My Story](http://hjhistory.tistory.com/entry/NIO-셀렉터-부분-정리 "My Story")