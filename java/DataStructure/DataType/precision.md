# precision(정밀도)

### Double Precision
 - double: 64 bit


## IEEE 754
 - 정의
 	 - 부동소수점 표현시 컴퓨터들간의 호환성을 위해 미국 전기전자공학회(IEEE)에서 표준화한 형식
 - 종류
 	 - Single Precision(단정도): 32bit 표현 방식
 	 - Double Precision(배정도): 64bit 표현 방식

### Single Precision(단정도)
 - 정의
	 - 32bit 부동소수점 표현 방식
 - 32bit: 1bit(sign, 부호) + 8bit(exponent, 지수) + 23(mantissa, 가수)
 	 - 부호(sign)
 	 	 - 양수와 음수를 판단하는 방식
 	 	 - 0: 양수, 1: 음수
 	 - 지수(exponent)
 	 	 - 
 	 - 가수(mantissa, significant)
 	 	 - 실질적인 데이터
 	 	 	1. 지수를 1.bbb...b의 형식으로 표현 가능하도록 지수를 조정
 	 	 	2. 가수를 표현할 때 bbb...b만 표현
 	 	 	3. 1은 항상 존재하기 때문에 저장할 필요가 없기 때문
 	 	 	4. 단, 숫자 0인경우 가수를 모두 0으로 채운다.
 - ex. 15.625
 	1. 1111.101(2)
 	2. 1.111101 * 2^3(2)
 	3. 


http://whatisthenext.tistory.com/146