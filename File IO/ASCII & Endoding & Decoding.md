# **Response 객체**

## **ASCII**
 - 0 ~ 32(2^0 ~ 2^4)
 	 - 제어문자, 폰트, 전송의 끝을 알리는 문자 등의 특수한 이벤트를 알림
 - 33 ~ 127(2^5 ~ 2^7)
 	 - 실제 사용되는 문자, !@#abcd...
 - 이때 8개의 bit로 7개만 사용하면 되기 때문에 첫번째 bit의 경우 0으로 비워둔다.

## **Encoding/Decoding**
 - 생성 과정
	1. 네트웍을 통해 'Binary(음악, 그래픽, 영화 등등, 8bit)' 파일을 보낼 필요가 생김
	2. 7bit의 ASCII코드로 이들을 표현하기에 부족
	3. 기존의 네트웍 데이터 교환 시스템 또한 ASCII(7bit)를 전제로 제작되었기 때문에 8bit Binary데이터를 제대로 전달할 수 없었음
	4. 'Binary파일'들을 'ASCII 문자 파일'로 바꾸어 전달할 필요가 있었음(Binary -> Text)
	5. 이것을 인코딩(Encoding)이라고 하고 반대의 경우를 디코딩(Decoding)이라고 함
 - Encoding
 	 - 정의
 		 - 응용프로그램의 데이터를 스트림(Stream)형식으로 변환시켜 보조기억장치나 네트워크상에서 사용가능한 형태로 변환하는 작업
 		 - Binary파일 -> Text파일(ASCII)로 바꾸는 것
 - Decoding
 	 - 정의
 	 	 - Text파일(ASCII) -> Binary파일로 해독하는 과정

#### **UUEncode(Unix-to-Unix Encode)**
 - 초기 인코딩 방식의 대표적 표준
 - 진행
 	 - 어떤 Binary Data 중 3개의 byte를 가져왔을 때 다음과 같다면
		`10011100  00110011  11110000`
	 - 3byte는 24개(8\*3)의 bit인데 이를 6개짜리 4개로 변환
		`100111  000011  001111  110000`
 	 - 각 bit의 첫 두자리에 0을 붙임
		`00100111  00000011  00001111  00110000`
	 - 각각에 십진수 32(이진수 1000000)를 더함(조절문자가 아닌 보통의 문자로 바꾸기 위함)
		`01100111  01000011  01001111  01110000`

#### **MIME(Multipurpose Internet Mail Extensions)**
 - 정의
 	 - 메시지 Content-Type을 정의하기 위한 인터넷 표준
 	 - UUEncode가 성장된 방식
 - 진행
 	 - 컴퓨터는 0과 1로 이루어진 2진수(Binary)만 이해할 수 있는데 초기에는 컴퓨터마다 문자에 대응되는 값이 달랐고 이에 ANSI에서 "ASCII(**A**merican **S**tandard **C**ode for **I**nformation **I**nterchange"표준을 정함
 	 - 컴퓨터의 기본 단위는 byte(8bit)
 	 - 이메일과 함께 보내질 첨부 파일(attachment file)을 텍스트 문자로 전환해서 이메일 시스템을 통해 전달하기 위해 개발되었기 때문에 이름이 Internet Mail Extension입니다.
 	 - 문서 끝 부분의 공백이 사실은 공백이 아니라 변환되어야 할 값인데 공백을 무시하는 경우엔 UUEncode 파일을 원형 그대로 전달 받을 수 없는 한계를 극복하기 위해 보강한 방식
 	 - MIME의 경우 기존 방식(UUEncode)에서는 없었던 파일 포맷(Content-Type)정보도 함께  담을 수 있음
