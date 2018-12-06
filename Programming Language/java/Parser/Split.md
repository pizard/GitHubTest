# Split
## 생성자
 - split(String regex)
 - split(String regex, int limit)
 	 - regex: 문자열을 구분하기 위한 정규 표현 구분자
 	 - limit: 분류할 문자열의 수, 분류된 단어가 5개고 limit이 2인경우 2개만 구분하고 나머지는 통째로 출력
 	 	 -  0: default, 전체 구분
 	 	 - -1: 상세 구분(마지막꺼도 구분자로 인식)

## StringTokenizer vs Split
 - StringTokenizer
 	 - 공백을 무시하고 데이터를 인식함
 - Split
	 - 공백에 대해 데이터로 인식함
 - Performance
 	 - split메소드는 인자로 regex(정규표현식)을 사용하기 때문에 성능적인 측면에서는 StringTokenizer가 더 좋음
 	 - 가변적인 요소가 많거나 정확한 분리가 필요한 경우에는 split이 더 좋음

## EX
 - `String str = "apple, banana,,kiwi`
 	 1. StringTokenizer
 	 	 - 1번째: apple
 	 	 - 2번째: banana
 	 	 - 3번째: kiwi
 	 2. Split
 	 	 - 1번째: apple
 	 	 - 2번째: banana
 	 	 - 3번째: 
 	 	 - 4번쨰: kiwi
 - `String str = "apple, banana,kiwi,`
 	 1. StringTokenizer
 	 	 - 1번째: apple
 	 	 - 2번째: banana
 	 	 - 3번째: kiwi
 	 2. Split
 	 	 - 1번째: apple
 	 	 - 2번째: banana
 	 	 - 3번쨰: kiwi
 - `String str = "apple, banana,kiwi,`, split(",",-1)
 	 1. StringTokenizer
 	 	 - 1번째: apple
 	 	 - 2번째: banana
 	 	 - 3번째: kiwi
 	 2. Split
 	 	 - 1번째: apple
 	 	 - 2번째: banana
 	 	 - 3번쨰: kiwi
 	 	 - 4번째: 