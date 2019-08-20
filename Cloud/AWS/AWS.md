0. 인프라
 - InfraStructure
  - 20개 Rsgions
  - 61개의 Availability Zones
 - Edge Network(Cloud Front)
  - 155개의 Edge Location
  - 11개의 Region Edge Cache

a. Setting
 - Route 53   : Domain Mapping
 - Elastic IP : IP주소 고정

b. DB
  1. RDS      : RDS
  2. DynamoDB : Logical
   - 완전 관리형 NoSQL 데이터베이스
   - Time-to-Live(TTL)
   - Global Table(Multi Region, Multi Master)
  3. Neptune  : Graph
  4. Aurora
   - AWS 자체 DB
   - 스토리지 용량에 대한 관리 가능
   - serverless Option(CPU, Memory)

c. 공통기능 제공
  - Amazon Cognito

d. 보안(IAM)
 - Cloud Trail     : API간 호출 로그 확인
 - GuardDuty       : 불법적 침입 침투에 대한 탐지
 - Shield          : DDoS방어 Solution 제공(+Advanced)
 - Secrets Manager : DB암호 변경 시 보안
  - WAF             : Web Application 암호 변경 시 보안
 - Certificate Manager : SSL,PL..? 보안
 - Key Management Service : 키 암호화 보안
 - Config          : 전체적으로 관리

e. LoadBalancing (ELB, Elastic Load Balancing)
  1. ALB(Application Load Balancer) : L7
  2. NLB(Network Load Balancer)     : L4
  3. CLB(Classic Load Balancer)     : 초기버전 사용성↓

f. File & data(Cache)
 1. S3(Simple Storage Service)
  - HardDisk, SSD와 같음
  - Public한 파일서버로 사용 가능
  - 오브젝트 기반 스토리지
  - 정적 자산에 최적화 & 콘텐츠 부하 분리
 2. CloudFront
  - 빠른 컨텐츠 전달을 위한 캐싱(TTL)
  - 오리진(웹서버)측의 부담을 덜어줌
  - 동적 / 정적 컨텐츠 / 스트리밍 비디오를 사용 가능
 3. ElasticCache
  - 관리형 Memcached or Redis
  - 한 개에서 여러 개의 노드로 분산

g. 가용 영역
 1. AutoScaling
  - CloudWatch 지표 기반 스케일링
  - Pool Size 최소/최대 지정
  - Instance 수 지정
 2. Multi-AZ
 3. Multi-Region
 4. SNS(Simple Notification Service)
  - 서비스의 Publish 알림
 5. SQS(Simple Queue Service)
  - 서비스가 Down이 된 경우 or 몰린경우 Queue로써 메시지를 받아줌

h. 자동화
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

i. Serverless
 1. API Gateway
 2. Lambda
 - 이벤트 기반 컴퓨트
 - 내부적 스케일링

j. ETC
 - Elasticsearch Service
  - Fargate
 - Simple Email Service
 - Step Functions
 - Elemental MediaConvert
 - SageMaker
 - X-Ray
  - 서비스 호출 그래프의 시각화









+. Plus
 1. About Charging
  a. Elastic IP
   - ec2에 연결해 두지 않으면 과금
   - 정지된 ec2에 연결한 경우
  b. RDS
   - In 프리티어 1개까지 무료
   - RDS생성시 Multi-AZ와 고성능 I/O인 Provisioned IOPS Storate를 사용하지 않도록 설정
  c. ElasticCache
   - In 프리티어 1개(t2.micro & Multi-AZ 해제) 무료
  d. EBS
   - In 프리티어 30GB까지 무료
   - 여러개를 동시에 사용하지만 않으면 괜찮음
   - But 합쳐서 계산
  z. Reference
   - https://gun0912.tistory.com/45
