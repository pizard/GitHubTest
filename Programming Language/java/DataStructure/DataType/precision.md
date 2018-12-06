# precision(정밀도)
## 서론
 - 컴퓨터의 경우 정수와 유리수는 정확하게 저장할 수 있지만 무리수의 경우 소수점 몇째자리에서 끊어 그 부분까지만 저장 가능함
 - 이렇게 짤려나간 뒷쪽 소수점으로 인해 발생하는오류를 truncation error/round off error라고 부름
 - 이에 컴퓨터가 실수를 표현하는 방식을 정의했다.

## IEEE 754
 - 정의
 	 - 부동소수점 표현시 컴퓨터들간의 호환성을 위해 미국 전기전자공학회(IEEE)에서 표준화한 형식
 - 종류
 	 - Single Precision(단정도): 32bit 표현 방식
 	 - Double Precision(배정도): 64bit 표현 방식

### Single Precision(단정밀도)
 - 정의
	 - 32bit(4byte) 부동소수점 표현 방식
 - 32bit: 1bit(sign, 부호) + 8bit(exponent, 지수) + 23(mantissa, 가수)
 	 - 부호(sign)
 	 	 - 양수와 음수를 판단하는 방식
 	 	 - 0: 양수, 1: 음수
 	 - 지수(exponent)
 	 	 - 바이어스 지수: 실수끼리 연산을 할 때 크기가 더 작은 실수의 가수와 지수를 조정해야함
 	 - 가수(mantissa, significant)
 	 	 - 실질적인 데이터
 	 	 	1. 지수를 1.bbb...b의 형식으로 표현 가능하도록 지수를 조정
 	 	 	2. 가수를 표현할 때 bbb...b만 표현
 	 	 	3. 1은 항상 존재하기 때문에 저장할 필요가 없기 때문
 	 	 	4. 단, 숫자 0인경우 가수를 모두 0으로 채운다.
 - ex. 15.625
 	1. 8 + 4 + 2 + 1 + 0.5 + 0.125 : 1111.101(2)
 	2. 1.111101 * 2^3(2)
 	3. 지수: 2^3
 		 - 바이어스(bias) 지수: 3 + 127, 1000 0010(20)
 	4. 가수
 		 - 0.111101
 		 - 111 1010 0000 0000 0000 0000ㅁ
 	5. 0(sign) + 1000 0010(exponent) + 111 1010 0000 0000 0000 0000(mantissa)
 	6. 0100 0001 0111 1010 0000 0000 0000 0000
 	6. 0x417A0000



### Double Precision(배정밀도)
 - 정의
	 - 64bit(8byte) 부동소수점 표현 방식
 - 64bit: 1bit(sign, 부호) + 11bit(exponent, 지수) + 52(mantissa, 가수)
 - ex. 15.625
 	1. 8 + 4 + 2 + 1 + 0.5 + 0.125 : 1111.101(2)
 	2. 1.111101 * 2^3(2)
 	3. 지수: 2^3
 		 - 바이어스(bias) 지수: 3 + 1023, 100 0001 0000(20)
 	4. 가수
 		 - 0.111101
 		 - 1111 0100 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000
 	5. 0(sign) + 100 0001 0000(exponent) + 1111 0100 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000(mantissa)
 	6. 0100 0001 0000 1111 0100 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000
 	6. 0x410F400000000000


## 참고
 - [경영학도의 좌충우돌 프로그래밍](http://qt3b1s62da6s.tistory.com/368 "단정도(single precision), 배정도(double precision)이란?")
	 - single precision / double precision
 - [이름이 없는 블로그](http://whatisthenext.tistory.com/146 "single precision과 double precision")
	 - Primitive Types > 상세, Literal, Integer Literals, Floating-point Literals



