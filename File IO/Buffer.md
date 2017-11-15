# Buffer
## NIO의 Buffer 클래스
 - NIO에서는 데이터의 입출력하기 위해 항상 버퍼를 사용
 - 정의
   - 읽고 쓰기가 가능한 메모리 배열
 - 특징
   - 운영체제의 커널이 관리하는 시스템 메모리를 직접 사용 할 수 있다.
   - byte[]의 경우 JVM의 힙영역에 메모리가 할당되고 바이트 배열의 초기값이 시스템 메모리로 한번 복사 되어야 한다.
   - byte[]의 경우 이렇게 복사 뿐만 아니라 운영체제 수준에서 제공해주는 DMA, 가상 메모리, 메모리 맵 파일들의 기능을 사용할 수 없음

## Buffer의 종류(데이터 타입/메모리 위치)
### 1. 데이터 타입
 -  NIO 버퍼는 저장되는 데이터 타입에 따라서 별도의 클래스로 제공
 	<img src="../image/File IO/Channel/bufferClassType.png"></img>
  	 - 이 중 MappedByteBuffer는 ByteBuffer의 하위 클래스로 파일의 내용에 랜덤하게 접근하기 위해서 파일의 내용을 메모리와 맵핑시킨 버퍼

### 2. 메모리 위치(Direct Buffer)
 - 정의
  	 - 운영체제가 관리하는 메모리 공간을 이용하는 버퍼
 - 특징
  	 - 운영체제의 메모리를 할당받기 위해 운영체제의 네이티브 C함수를 호출해야 하고 여러 잡다한 처리를 해야 하므로 상대적으로 생성이 느림
  	 ➜ 자주 생성하기 보다는 한번 생성 후 재사용이 적합함
  	 - 운영체제가 허용하는 범위 내에서 대용량 버퍼를 생성할 수 있음
 	 - 채널(Channel)을 사용해서 버퍼의 데이터를 읽고 저장할 경우에만 운영체제의 native I/O를 수행, 만약 채널을 이용하지 않고 ByteBuffer의 get()/put()메소드를 사용한다면 내부적으로 JNI(Java Native Interface)를 호출하여 native I/O를 수행하기 때문에 JNI호출이라는 오버헤더가 추가됨
  	 ➜ get()/put()을 사용한다면 오히려 NonDirect Buffer의 성능이 더 좋게 나올 수도 있음
  	 ※ JNI(Java Native Interface): 자바 코드에서 C 함수를 호출할 수 있도록 해주는 API
 - Function()
  	 - `allocateDirect()`
  	 	 - 운영체제가 관리하는 메모리에 Direct Buffer를 생성
  	 	 - 타입별 Buffer클래스는 없고, ByteBuffer에서만 제공
  		 	 ➜ 이외의 타입의 경우 우선 allocateDirect()메소드로 버퍼를 생성한 후 asCharBuffer(), asShortBuffer()등을 이용하여 해당 타입별 Buffer를 얻음

### 3. 메모리 위치(NonDirect Buffer)
 - 정의
  	 - JVM이 관리하는 힙 메모리 공간을 이용하는 버퍼
 - 특징
  	 - JVM 힙 메모리를 사용하므로 생성 시간이 빠름
  	 - JVM이 관리하는 제한된 힙 메모리를 사용하므로 버퍼의 크기를 크게 잡을 수 없음
  	 - 입출력 시 임시 Direct 버퍼를 생성하고 NonDirect 버퍼에 있는 내용을 임시 Direct 버퍼에 복사합니다. 그 후 임시 다이렉트 버퍼를 사용해서 운영체제의 native I/O기능을 수행함
	  	 ➜ Direct Buffer에 비해 입출력 성능이 낮음
 - Function()
  	 - `allocate()`
  	 	 - JVM 힙 메모리에 NonDirect Buffer를 생성
  	 	 - 타입별 Buffer클래스가 존재(ButeBuffer, CharBuffer, DoubleBuffer...)
  	 - `wrap()`
  	 	 - 이미 생성되어 있는 자바 배열을 wraping하여 Buffer 객체를 생성
  	 	 - 자바 배열은 JVM 힙 메모리에 생성되므로 wrap()은 NonDirect Buffer를 생성합니다.

## byte 해석순서(ByteOrder)
 - Big Endian
 	 - 앞쪽 바이트부터 먼저 처리
 - Little Endian
 	 - 뒤쪽 바이트부터 먼저 처리
 - 데이터를 처리할 때 바이트 처리 순서는 운영체제마다 차이가 존재
  	 ➜ 운영체제간 데이터 교환 시 데이터를 다루는 버퍼도 고려해서 짜야함
 - NonDirect Buffer의 경우 JVM에서 이것을 처리해 주기 때문에 상관없음
 - Direct Buffer의 경우 운영체제의 native I/O를 사용하므로 운영체제의 해석 순서로 JVM의 해석순서를 맞추는 것울 통해 성능개선
 - Function()
 	 - ByteOrder 클래스의 `nativeOrder()`
 	 	 - 데이터 처리 순서를 확인할 수 있음
		 - `ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100).order(ByteOrder.nativeOrder());`

## 버퍼의 위치 속성
 - 용어
	 - position
	 	 - 현재 읽거나 쓰는 위치 값
	 - limit
	 	 - 읽거나 쓸 수 있는 한계
	 - capacity
	 	 - 버퍼의 최대 데이터 개수(메모리 크기)
	 - mark
	 	 - reset()메소드 실행 시 돌아오는 위치
	 - 0 ≤ mark ≤ position ≤ limit ≤ capacity

 - 공통 메소드, 이외에도 많이 존재
 	 - `flip()`
 	 	 - limit ➜ position, position ➜ 0번 index
 	 - `rewind()`
 	 	 - limit ➜ 그대로, position ➜ 0번 index
 	 - `mark()`
 	 	 - mark 값 지정(mark ➜ position)
 	 - `reset()`
 	 	 - 초기화 (position ➜ mark)
 	 - `clear()`
 	 	 - 데이터를 제외한 값들을 초기화 시킴(limit ➜ capacity, position ➜ 0번 index, mark ➜ 삭제)
 	 - `compact()`
 	 	 - 버퍼 Data 위치 변경(position ~ limit DATA ➜ 0번 index, position ➜ 이동 데이터 이후, 나머지는 그대로)
 	 	 - 딱히 쓸 일 없을듯...

## 버퍼 변환
 - 채널이 데이터를 읽고 쓰는 버퍼는 모두 ByteBuffer
	 ➜ 채널을 통해 읽는 데이터를 복원하려면 ByteBuffer를 문자열 또는 다른 타입의 버퍼(CharBuffer, ShortBuffer, IntBuffer...)로 변환이 필요

### ByteBuffer ⇄ String / ByteBuffer ⇄ IntBuffer
 - 채널을 통해 문자열을 파일이나 네트워크로 전송하려면 특정 문자셋(UTF-8,EUR-KR... )로 인코딩하여 ByteBuffer로 변환해야 함
 	```
 	Charset charset = Charset.forName("UTF-8");
 	String data = ".....";
	ByteBuffer buffer = charset.encode(data);	// UTF-8로 문자열을 encoding
	data = charset.decode(buffer).toString();	// UTF-8의 문자열로 decoding
	```
 - int의 경우 Bytebuffer로 받은 후 asIntBuffer()를 통해 변환해야 함
 	```
 	int[] writeData = { 10, 20, 30, 50, 70 };
    IntBuffer writeIntBuffer = IntBuffer.wrap(writeData);
    ByteBuffer writeByteBuffer = ByteBuffer.allocate(writeIntBuffer.capacity() * 4);
 
    for (int i = 0; i < writeIntBuffer.capacity(); i++) {
        writeByteBuffer.putInt(writeIntBuffer.get(i));
    }
 
    writeByteBuffer.flip();
 
    ByteBuffer readByteBuffer = writeByteBuffer;
    IntBuffer readIntBuffer = readByteBuffer.asIntBuffer();
    int[] readData = new int[readIntBuffer.capacity()];
    readIntBuffer.get(readData);
 	```

### 참고
 - [palpit's log-b](http://palpit.tistory.com/641 "palpit's log-b")
   - Buffer의 종류(데이터 타입/메모리 위치)
   - 갓갓갓갓갓 사랑합니다♡