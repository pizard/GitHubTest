## STACKDRIVER MONITORING
 - 정의
 	 - Google Cloud Platform 및 Amazon Web Service에서 실행되는 애플리케이션용
 	 - 클라우드 기반 애플리케이션의 실적, 가동시간, 전반적 상태에 관한 정보를 제공
 - 기능
 	 - AS 통합
 	 	 - 사용 즉시 EC2, S3, 자동 확장, ELB, SQS, RDS, DynamoDB 등 AWS 리소스 및 애플리케이션 서비스를 모니터링 가능
 	 - ** GCP 통합 √ **
 	 	 - Compute Engine, App Engine, Kubernetes Engine, Cloud SQL, Datastore, BigQuery 등 GCP 리소스 및 서비스 모니터링 가능
 	 - 대시보드
 	 	 - 구성 없이도 클라우드 리소스 및 서비스의 핵심정보 파악 가능
 	 - 알림
 	 	 - 이벤트가 발생하거나 특정 시스템 또는 맞춤 측정항목이 정의된 규칙을 위반할 경우 알림이 제공되는 알림 정책을 구성 가능
 	 - ** 가동시간 모니터링 √ **
 	 	 - 인터넷 액세스 가능한 URL, VM, API, 부하 분산기의 가용성을 모니터링 가능

### Introduction to the Stackdriver Monitoring API
 - Stackdriver Monitoring API v3
 	 - 기능
 	 	 - 아마존 웹 서비스와 구글 클라우드 플래폼으로부터 900개가 넘는 Stackdriver Monitoring metrics로 접근할 수 있음
 	 	 - 


## Stackdriver Monitoring API
 - Service
	 - 모든 URI는 `http://monitoring.googleapis.com`과 관련되어 있음
	 - `https://monitoring.googleapis.com/$discovery/rest?version=v3`

### REST Resource
 - v3.projects.groups
 	 - 모니터되고 있는 리소스들의 동적 집합들을 설명한다.
 	 - 각 그룹들은 모니터되고 있는 리소스와 그들과 관련되어 있는 metadata들이 연결된 필터들을 갖고 있다.
 	 - 만약 그룹들의 필터가 사용가능한 모니터되고 있는 리소스와 매칭된다면 그 리소스는 이 그룹들의 멤버이다.
 	 - 그룹들은 몇개의 모니터된 리소스들을 포함할 수 있고 각 모니터되고 있는 리소스들은 어떤 그룹에도 멤버가 될 수 있다.
	 - create
 	 - delete
 	 - get
 	 - list
 	 - update
 - 

### Using Uptime Checks
 - 기능
	 - Stackdriver는 전세계의 어떤 위치에서든 너의 서비스를 이용가능한지 확인할 수 있다.
	 - alerting policy에서 uptime check를 통한 결과를 이용하거나 대시보드에서 결과를 바로 모니터링할 수 있다.
 - Before You Begin
 	 - Service Tier
		 - Basic Tier + Premium Tier
	 - Firewalls
 - Reviewing uptime checks
 	 - Stackdriver Monitoring은 모든 uptime checks와 각각의 check들의 상세 대시보드를 보여준다.
 - API
 	 - Method
 	 	 - projects.uptime.CheckCongigs.list
 	 - Http Request
 	 	 - GET, https://monitoring.googleapis.com/v3/{parent}/uptimeCheckConfigs
 	 - Path Parameter
 	 	 - parent
 	 	 	 - Type: string
 	 	 	 - format: projects/[PROJECT_ID]
 	 	 	 - Google IAM을 통한 인증을 요구
 	 	 	 - monitoring.uptimeCheckConfigs.list
 	 - Query Parameter
 	 	 - pageSize
 	 	 	 - Type: number
 	 	 	 - 단일 응답에서 결과의 최대 수
 	 	 - pageToken
 	 	 	 - Type: string
 	 	 	 - 이 필드가 비어있지 않는다면 nextPageToken을 항상 갖고있어야 한다.
 	 	 	 - 


### Using Custom Metrics
 - 
