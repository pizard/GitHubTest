## 0. 사용자 == 0명
- 어디에서 서비스를 시작할 것 인가? by 사용자
    - InfraStructure
    - 20개 Regions
    - 61개의 Availability Zones
- Edge Network(Cloud Front)
    - 155개의 Edge Location
    - 11개의 Region Edge Cache

## 1. 사용자 == 1명
A. 페일오버 & 이중화 필요 없음
B. IP고정
    - Route 53  : Domain Mapping
C. 개발도구
    - Lightsail
    - 적절한 EC2 사용

## 2. 사용자 > 1
1. DataBase를 분산 & 운영해야 함
  - 성능, 장애 포인트 분산
  - RDS      : RDS
  - DynamoDB : Logical
  - Neptune  : Graph
  + Aurora
   - AWS 자체 DB
   - 스토리지 용량에 대한 관리 가능
   - serverless Option(CPU, Memory)
 b. 등록, 로그인 등등 공통 기능 제공
  - Amazon Cognito
 c. 보안(IAM) : 정책 할당
  - Cloud Trail     : API간 호출 로그 확인
  - GuardDuty       : 불법적 침입 침투에 대한 탐지
  - Shield          : DDoS방어 Solution 제공(+Advanced)
  - Secrets Manager : DB암호 변경 시 보안
  - WAF             : Web Application 암호 변경 시 보안
  - Certificate Manager : SSL,PL..? 보안
  - Key Management Service : 키 암호화 보안
  - Config          : 전체적으로 관리
3. 사용자 > 1,000
 a. LoadBalancing 필요
  - 웹 서버의 수평적 증설
  - ELB(Elastic Load Balancing)
   - ALB(Application Load Balancer) : L7
   - NLB(Network Load Balancer)     : L4
   - CLB(Classic Load Balancer)     : 초기버전 사용성↓
4. 사용자 > 10,000
 a. DB의 확장
  - Master을 두고 각각의 age에 여러 개의 읽기 전용 복제본 확장
 b. 정적 콘텐츠의 부하 분산
  - S3
   - 오브젝트 기반 스토리지
   - 정적 자산에 최적화 & 콘텐츠 부하 분리
  - CloudFront
   - 빠른 컨텐츠 전달을 위한 캐싱(TTL)
   - 오리진(웹서버)측의 부담을 덜어줌
   - 동적 / 정적 컨텐츠 / 스트리밍 비디오를 사용 가능
 c. 데이터 레이어의 부하 분산
  - ElasticCache
   - 관리형 Memcached or Redis
   - 한 개에서 여러 개의 노드로 분산
 d. DynamoDB
   - 완전 관리형 NoSQL 데이터베이스
   - Time-to-Live(TTL)
   - Global Table(Multi Region, Multi Master)
5. 사용자 수 > 500,000
 a. AutoScaling
  - CloudWatch 지표 기반 스케일링
  - Pool Size 최소/최대 지정
  - Instance 수 지정
 b. 자동화
  - Systems Manager
   - AWS Cloud + On-Premise 지원
   - 쉡 접근(베스천 서버 없이)
  - AWS Code
   - CodeStar : 전체 통합 UI
   - CodePipeline : 전체적 파이프라인 관리
   - Cloud9       : 웹에서 개발 IDE 환경 제공
   - CodeCommit   : 형상관리
   - CoeBuild     : 빌드
   - Third-party tooling :
   - CodeDeploy   : 배포
6. 사용자 수 > 1,000,000
 a. 가용영역을 최대한 이용
  - Multi-AZ
 b. Auto Scaling 세분화
  - Web & Worker(배치) & App
 c. ELB 세분화
  - Internal & External
 d. 컨텐츠 전송 최적화
  - Amazon S3, CloudFront
 e. DB Cache사용
 f. 테스트 서버 운영
  - API Gateway + Lambda + DynamoDB
 g. 과도한 요청 or Downtime 대비
  - SQS, SNS
7. 사용자 수 > 5,000,000
 a. 데이터 베이스 이슈
 a-1. 역할별 DB 분할
 a-2. 샤딩 : 여러 DB인스턴스로 하나의 데이터 셋 분할
 a-3. 기능별 데이터에 적합한 DB로 이관(NoSQL, Graph 등)
8. 사용자 수 > 10,000,000
 a. 어플리케이션 튜닝
 b. MSA 적용
 c. 멀티 AZ -> Multi Region
  - DynamoDB
 d. 전체 스택에 대한 깊은 분석 진행
0. MSA(MicroService Architecture)
 a. 서비스 간의 의존도 제거
  - SNS(Simple Notification Service)
  - SQS(Simple Queue Service)
 b. Event 기반 컴퓨트(Serverless)
  - Lambda
  - API Gateway
 c. ETC
  - Elasticsearch Service
  - Fargate
  - Simple Email Service
  - Step Functions
  - Elemental MediaConvert
  - SageMaker
  - X-Ray
