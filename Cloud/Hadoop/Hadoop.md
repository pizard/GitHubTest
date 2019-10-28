# 다른 분산 컴퓨팅 vs Hadoop
1. 접근(Accessible) : 범용 컴퓨터 or EC2에서 실행
2. 견고성(Robust) : 빈번한 고장을 가정하고 설계
3. 확장가능성(Scalable) : 선형적 확장
4. 간단성(Simple) : 효과적인 병렬코드 사용

# SQL vs Hadoop
1. Not Scale Up, But Scale Out
2. Not RDBS, But Key-Value
3. Not SQL, But MapReduce(기능적 프로그래밍)
4. Not Online, But OffLine Batch

# 구성요소
1. HDFS(Hadoop File System)
    - master/slave 구조
2. NameNode
    - HDFS의 Master
    - DataNode 데몬에게 I/O작업 지시
    - 파일 시스템의 전반적인 위치와 상태 저장(기록원)
    - 메모리와  I/O에 관한  작업 수행

3. DataNode
    - 로컬 파일 시스템에 위치한 파일에 HDFS 블록을 읽기/쓰기 기능 수행

4.  Secondary NameNode(SNN)
    - 클러스터로 구성된 HDFS의 상태를 모니터링하는 보조 성격을 갖는 데몬

5. Job Tracker
    - 클러스터 Node에서 실행되는 사용자 애플리케이션 관리

6. TaskTracker
    -  master로서 MapReduce의 전체적 실행 감독


## What is Hadoop Mapper
- each input record and it generates a new <key, value> pairs
- Before writing the output for each mapper task, partitioning of output take place on the values for each key are grouped together
