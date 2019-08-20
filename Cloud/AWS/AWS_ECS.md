ECS(Elastic Container Service)
 a. 구성
  1. Cluster
   - 기본 단위
  2. Service
   - 태스크를 지속적으로 관리하는 단위
  3. Task
   - 실행 최소 단위
   - 실행시 해당 Container Instance를 찾아 실행
   - Task Definition : Task 설정파일(모드, 역할, 이미지, CPU 제한..)
  4. Container Instance
   - 서비스, 태스크를 실행하기 위해 사용하는 컴퓨팅 자원
   - Container Definition
  5. Image    : 특정 애플리케이션을 실행 가능한 환경을 재현하기 위한 파일 집합
   - Dockerfile로 관리
   - Docker Hub, ECR(Elastic Container Registry)에 저장해서 사용
 b. 실행방식
  1. Task Definition을 통한 직접 실행 (특정한 경우만 사용)
  2. 서비스 정의를 통한 실행
   2-1. Replica Type : 실행하려는 태스크의 개수 지정 (실 서비스)
   2-2. Demon Type   : 모든 컨테이너 인스턴스에 해당하는 태스크가 하나씩 실행 (관리의 목적)
 c. Scheduling
  -
 - 0.25 vCPU 단위로 쪼갤 수 있음

 e. 특징
  1. 성능이 제한되는 람다(5분)보다는 성능의 자유도가 높음


ScheduleStart, ScheduleStop, Scheduled


- 장점
 - 관리를 위한 별도의 어플리케이션이 필요 없음
 - 컨테이너 운영 매니지드 서비스
- 특징
 1. 부하분산
 2. 자동확장
 3. 로깅
 4. 네트워킹
 5. 접근제어
 6. 모니터링

Fargate
 - 관리X
  - Cluster(Clustering)
  - EC2 Instance
 - 관리 O
  - Container

 - MSA로 Docker를 운영하기 위해서는 Docker의 갯수가 너무 늘어남
 - Amazon EC2
 - 모든 사이즈의 Container를 관리할 수 있음



- 구성요소
 1. 작업
 2. 클러스터
 3. 에이전트
 4. 매니저
 5. 작업 정의
 6. 스케줄러
- 진행
 - 클러스터안의 에이전트를 통해서 매니저를 연결하여 작업을 등록
 - 작업정의라는 이름으로 스케쥴러에서 도커를 컨트롤할 수 있음
-

ECR(Elastic Container Registry)
 a. 기능
  - 도커 이미지 관리 서비스










https://www.youtube.com/watch?v=bEr_98NRlzc&t=894s



 - 기능
  1. NAT(Network Address Translation)     : 사설 IP 주소를 공인 IP주소로 바꾸는데 사용하는 통신망의 주소 변조기
  2. Tunneling                            : 인터넷상에서 눈에 보이지 않는 통로를 만들어 통신할 수 있게하는 개념
  3. DSR(Dynamic Source Routing protocol) : 로드밸런서 사용시 서버에서 클라이언트로 되돌아가는 경우 목적지 주소를 스위치의 IP주소가 아닌 클라이언트의 IP주소로 전달해서 네트워크 스위치를 거치지 않고 바로 클라이언트를 찾아가는 개념
