# Stream
 - 정의
 	 - 일련의 연속된 데이터의 흐름으로 자바프로그램과 외부장치 사이의 데이터 교환을 위한 처리 방식, 추상화, 실제 장치와 상관없이 공통된 접근 방식을 제공한다.

## Byte Stream vs 문자 Stream
1. Byte Stream
	 - 정의
	 	 - 데이터를 Byte단위로 주고 받는 것
	 - 종류
		 - PrintStream
		 - InputStream, OutputStream
		 - ByteArrayInputStream, ByteArrayOutputStream
		 - FileInputStream, FileOutputStream
		 - FilterInputStream, FilterOutputStream
		 - ObjectInputStream, ObjectOutputStream
		 - PipedInputStream, PipedOutputStream
		 - BufferedInputStream, BufferedOutputStream
		 - DataInputStream, DataOutputStream
	 	 -  ... 기타 등등

	 - 특징
	 	 - 운영체제 별로 고유의 문자표현방식이 존재한다. 그리고 해당 운영체제에서 동작하는 프로그램은 그 문자표현방식을 따르기 때문에 따라서 파일또한 해당 문자표현방식을 따라 저장되어야 한다.
	 	 - 원래 Stream은 Byte단위를 기본으로 한다. 문자도 내부적으로 Byte 단위가 잇으며 

## InputStream, OutputStream
 - `FileOutputStream fos = new FileOutputStream("c:\\iotest\\stream.txt", true);`
 	 - true : Append, 이어쓰기
 	 - false : Create, 기존 내용에 덮어쓰기
 	 - 기본값 : false
 - I/O Stream 순서
 	 - 데이터 읽기
 	 1. 데이터 소스를 지정한다.(파일, 문자열 배열, 네트워크 연결 등)
 	 2. 데이터 소스를 사용해 Input Stream을 생성한다.
 	 3. Input Stream을 통해 데이터를 읽는다. 일반적으로 입력 스트림으로부터 모든 데이터를 읽을 때까지 루프를 수행하고 끝이 감지되었을때 특정한 문자를 리턴한다.
 	 4. Input Stream을 닫는다.
 	 - 데이터 쓰기
 	 1. 데이터 싱크를 지정한다. 데이터가 쓰여질 목적지를 명시한다. (파일, 문자열, 배열, 네트워크 등)
 	 2. 데이터 싱크를 사용하여 output Stream 생성한다.
 	 3. 데이터를 output Stream으로 쓴다.
 	 4. Output Stream을 닫는다.

### 참고
 - [놀이터흙이제맛](http://noritersand.tistory.com/46 "놀이터흙이제맛")
 