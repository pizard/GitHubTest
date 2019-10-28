#  1. 기상 데이터셋
- 기상 데이터 : 지구 전지역에서 매시간 데이터를 수집하면 기상 센서들은 대량의 로그 데이터를 모음 -> 반구조적, 레코드 지향적
    -> 맵리듀스에 적합
## 1.1 데이터 포맷
- 국립기후자료센터(National Climatic Data Center, NCDC)
- 데이터 파일
    - 기준 : 날짜, 기상관측소를 기준으로 분리
    - 기간 : 1901년 ~ 2001----

## 2. 유닉스 도구로 데이터 분석하기
- 이론적으로 한대의 머신에는 모든 하드웨어 스레드를 활용해 서로 다른 프로세스에 할당하면 되지만 문제가 존재
    1. 일을 동일한 크기로 나눈다는 것이 언제나 쉬운 것은 아님
    2. 독립적인 프로세스의 결과를 모두 합치는데 더 많은 처리가 필요할 수 있음
    3. 단일 머신의 처리 능력 한계

#  3. 하둡으로 데이터 분석하기
## 3.1 맵과 리듀스
1. Map
    - 구성
        - Input : NCDC의 원본 데이터
        - Key : 파일의 시작부에서 각 행의 시작되는 지점까지의 오프셋
        - Value : 각 행(문자열)
        - Output : 리듀스 함수로 보내는 데이터
    - 작업
        - 잘못된 레코드 제거(필드의 값 누락, 문제가 있는 레코드)
2. MapReduce Framework
    - 작업
        - 키-값 쌍을 키를 기준으로 정렬 및 그룹화
        - ex. Key : 연도, value : 기온
3. Reduce
    - 구성
        - Input : 정렬 및 그룹화 된 데이터(Key, Value)
    - 작업
        - 리스트 전체를 반복하고 원하는 작업 수행(ex. 최고 측정값 추출)

## 3.2 자바 맵리듀스
- MapReduce : 여러 노드에 테스크를 분배하는 방법
    - Map : 흩어져 있는 데이터를 Key, Value의 형태로 연관성 있는 데이터 분류로 묶음
    - Reduce : Map작업을 수행한 각각의 블럭의 결과 정보를 합치는 작업
- Mapper(입력키, 입력값, 출력키, 출력값)
    - Parameter : Generic Type
        - 입력키 : long integer타입의 오프셋
        - 입력값 : 한 행의 내용
        - 출력키 : 연도
        - 출력값 : 기온(정수)
    - Data Type
        - Long    -> LongWritable
        - String  -> Text
        - Integer -> InWritable
    - map
        - key, value, Context
- `Reducer<Text, IntWritable, Text, IntWritable>`
    - Parameter : Generic Type
        - Text, IntWritable : 리듀스 함수의 입력타입 : 맵 함수의 출력 타입
    - `reduce(Text key, Iterable<IntWritable> values, Context context)`

- Job
    - 기능 : 잡 명세서 작성
    - Method
        - `FileInputFormat`
            - `addInputPath` : 입력 경로 지정
        - `setJarByClass` : 해당 클래스와 관련된 Jar파일 검색 및  클러스터 배치
        - `FileOutputFormat`
            - `setOutputPath` : 출력 경로 지정
        - `setMapperClass` : 맵 함수의 출력 타입 지정
        - `setReducerClass` : 리듀스 함수의 출력 타입 지정
        - `setOutputKeyClass` & `setOutputValueClass`
            - 리듀스 함수의 출력 타입 지정
            - Reduce 클래스 에서의 출력 타입과 일치해야 함
            - 일반적으로 매퍼와 리듀서의 출력 타입이 같으면 지정하지 않아도 괜찮음
        - `setMapOutputKeyClass` & `setMapOutputValueClass`
            - 맵의 출력 타입 지정
            - 맵과 리듀서의 출력타입이 다르다면 지정 필요
        - `waitForCompletion` : 잡을 제출한 후 잡이 모두 끝날 때까지 기다림
            - true : 중간 결과의 생성 여부 표시 O
            - false : 중간 결과의 생성 여부 표시 X
        - `setCombinerClass` : 컴ㅎ바이너 함수 지정
- 테스트 수행
    1. 독립모드로 하둡 설치
        - 로컬시스템과 로컬 잡 수행자로 맵리듀스 잡을 실
    2. 


# 4. 분산형으로 확장하기
- 대용량 데이터를 어떻게 처리하는지 살펴
- YARN에 대해 학습함
## 4.1 데이터 흐름
- 용어
    - Job : 클라이언트가 수행하는 작업의 기본 단위
        - 구성
            - 입력 데이터
            - 맵리듀스 프로그램
            - 설정정보
        - 특징
            - map & reduce task로 나누어 실행
            - YARN을 이용하여 각 태스크를 스케줄링
            - 특정 노드의 태스크 하나가 실패하면 자동으로 다른 노드에 재할당 및 재시작
    - input split : 맵리듀스 잡의 입력을 분리하는 조각 단위
        - 스플릿마다 하나의 맵 태스크를 생성하고 스플릿의 각 레코드를 사용자 정의 맵 함수로 정의
        - 스플릿↑ → 부하 분산 효과↑
        - 스플릿↑ → 잡의 실행하시간↑(스플릿 관리 및 맵 태스크 생성)
        - 일반적으로 128MB가 적당
        - 최적 스플릿 크기가 HDFS 블록 크기와 같아야 하는 이유는 블록 크기가 단일 노드에 저장된다고 확신할 수 있는 가장 큰 입력크기이기 때문
    - 데이터 지역성 최적화(data locality optimization)
        - HDFS 내의 입력 데이터가 있는 노드에서 맵 태스크를 실행할 때 가장 빠르게 작동
        - 클러스터의 중요 공유자원인 네트워크 대역폭을 거의 사용하지 않음
        - 이를 위한 가용 슬롯이 부족한 경우 블록 복제본이 저장된 동일 랙에 속한 다른 노드에서 가용한 맵 슬롯을 찾음
        - 드물게 데이터 복제본이 저장된 노드가 없는 외부 랙의 노드가 선택된 경우 네트워크 전송이 발생


- To be continue

## 4.2 컴바이너 함수
- 기능
    - 맵의 결과 처리 & 리듀스 입력으로 전달
- 특징
    - 리듀스 함수를 컴바이너 함수로 재사용할 수 있음 (max : O, mean : X)

## 4.3 분산 맵리듀스 잡 실행하기
- 맵리듀스는 데이터의 크기와 하드웨어의 성능에 따라 확장 가능

# 5. 하둡 스트리밍
- 기능
    - 하둡과 사용자 프로그램 사이의 인터페이스로 유닉스 표준 스트림 사용
- 특징
    - 텍스트 처리에 적합
## 5.1 루비
## 5.2 파이썬
