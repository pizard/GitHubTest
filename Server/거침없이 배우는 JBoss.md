# 거침없이 배우는 JBoss
## Chapter 18. 애플리케이션 배포
 - 이번장에서는 JBoss EAP 6에서 애플리케이션을을 배포하는 방법에 대해서 설명
 - standalone 모드 & domain모드
 - 배포 방법
 	 - CLI
 	 - 관리 콘솔
 	 - 배포 스캐너(standalone만 가능)

### 1. StandAlone 모드에서 배포
 - 관리도구를 사용하여 배포
 - 간편한 배포방법으로는 배포 스캐너를 이용할 수 있는 것이 특징
 - 배포 상태
 	 - STOPPED
 	 	 - 애플리케이션이 서버에 배포되어 있지만 사용하지 않는 상태
 	 - OK
 	 	 - 애플리케이션이 서버에 배포되어 사용하고 있는 상태
 - 배포 상태는 CLI의 deployment-info 명령어를 사용하여 확인 가능
 	`deployment-info --name=example.war`

### 2. Domain 모드에서 배포
 - 관리도구를 사용해 도메인 컨트롤러를 경유하여 배포
 - 도메인 환경에서는 배포 스캐너를 지원하지 않는다.
 - 배포 대상도 standalone모드와 달리 서버가 아니라 서버 그룹을 대상으로 배포
 - 배포 상태
 	 - NOT ADDED
 	 	 - 레파지토리에 애플리케이션이 등록된 상태로 어느 서버 그룹에도 할당되어 있지 않은 상태
 	 - ADDED
 	 	 - 레파지토리에 어플리케이션이 등록된 상태로 몇 개의 서버 그룹에 할당되어 있지만, 사용하지 않도록 설정되어있기 때문에 애플리케이션에 접근할 수 없는 상태
 	 - ENABLED
 	 	 - 레파지토리에 애플리케이션이 등록된 상태로 서버 그룹에 할당되어 사용하고 있는 상태
 - 배포 상태는 CLI의 deployment-info 명령어를 사용하여 확인 가능

### 3. 배포 방식 비교
 - JBoss의 어플리케이션 배포 방법은 Managed/Unmanaged 방식, 그리고 Archive/Exploded 방식이 있다.
 - Archive
 	 - 압축된 파일을 사용하는 배포 방법
 - Exploded
 	 - 압축을 풀어놓은 디렉터리를 사용하는 방식
 	 - JSP파일 등 특정 파일만 변경하여 배포하고자 할 경우
 - Managed(archive)
 	 - JBoss가 애플리케이션을 관리하는 경우
 	 - 관리콘솔의 Deployments배포 또는 CLI에서 특정 애플리케이션을 직접 배포하는 경우
 		 - 내부적으로 data 디렉터리에 파일을 보관하여 배포
 	 - 도메인 모드에서도 콘솔이나 CLI에서 Managed방식으로 배포하면 다른 머신이 있더라도 호스트 컨트롤러에 애플리케이션을 JBoss가 내부적으로 복사하고 배포
 - UnManaged
 	 - 사용자가 직접 애플리케이션 파일을 관리하는 방식
 	 - 여러 머신을 사용하는 도메인 모드에서 Unmanaged방식을 이용하면 사용자가 직접 각각의 머신에 애플리케이션 파일을 복사해야함
 	 - 애플리케이션의 크기가 매우 큰 경우 선호

### 4. CLI에서 배포
#### 4.1 CLI에서 애플리케이션 배포
 - deploy명령어를 실행
 `deploy /EAP6book/download/example.war`

#### 4.2 CLI에서 애플리케이션 제거
 - undeploy
 `undeploy example.war`

### 5. 관리 콘솔에서 배포
- 관리콘솔 > Runtime > Server > Manage Deployment 선택....등등

### 6.Unmanaged 배포
 - WAR나 EAR로 패키징된 하나의 파일을 사용하지 않고 별도의 디렉터리에 보관된 애플리케이션을 사용하려고 할 때 사용하는 방법

### 7. 배포스캐너를 이용한 배포(도메인모드에서 사용 X)
 - 두가지 방법으로 배포를 제어
 	 1. 배포 디렉터리에 있는 배포파일(WAR,EAR,JAR,SAR)을 주기적으로 스캔하여 배포
 	 2. 마커파일을 이용하여 수동으로 배포를 제어

#### 7.1 자동 배포
 - 배포 디렉터리($jboss.server.base.dir/deployments)를 주기적으로 체크하고 있다가 새로운 애플리케이션이나 변경이 있으면 로드하여, 배포, 재배포 진행
 - 애플리케이션의 개발 시점에서는 유용하지만 운영 환경에서는 자동 배포하지 않도록 변경해야 함
 	 - CLI의 subsystem=deployment-scanner 서브시스템에서 설정 변경
 	 	 1. `cd subsystem=deployment-scanner`
 	 	 2. `:read-resource(recursive=true)`
 	 - 파라미터
 	 	 - name: 스캐너의 이름(기본값: default)
 	 	 - path: 스캐너가 감시하는 파일
 	 	 	 - relative-to가 설정되지 않은 경우: 절대 경로
 	 	 	 - relative-to가 설정된 경우: 상대 경로
 	 	 - scan-enable: 스캔을 사용할 것인지를 지정
 	 		 - `:write-attribute(name=scan-enabled, value=-----)`를 통해 수정 가능
 	 		 - true: 스캐너 동작
 	 		 - false: 서버 시작시에만 배포
 	 	 - scan=interval: 스캔 간격을 밀리 세컨드로 지정
 	 	 - auto-deploy-zipped: 압축된 애플리케이션 콘텐츠를 .dodeploy마커 파일을 사용하지 않고 배포할 것인지를 지정
 	 	 - auto-deploy-exploded: exploded(압축이 풀린) 형식인 애플리케이션 콘텐츠를 .dodeploy 마커 파일을 사용하지 않고 배포할 것인지를 지정(비추천)
 	 	 - deployment-timeout: 배포의 타임아웃(기본값: 60초)

#### 7.2 수동 배포
 - 배포 스캐너는 애플리케이션 배포 디렉터리에 있는 콘텐츠 자체는 감시하지 않는다.
 - 대신 스캐너는 마커 파일 시스템을 사용하여 그 마커파일을 추가, 삭제하는 것을 명령어로 스캐너에 전달하여 콘텐츠를 배포, 제거한다. 

#### 7.2.1 마커파일
 - .dodeploy
 	 - 애플리케이션을 배포하라고 알린다.
 	 - 이미 배포했을경우 재배포
 	 - 사용자가 작성하는 파일
 - .skipdeploy
 	 - 자동배포하지 않는다는 것을 의미한다.
 	 - exploded 애플리케이션을 업데이트 할때, 재 배포되지 않도록 사용할 수 있다.
 - .isdeploying
 	 - 애플리케이션이 배포 중임을 나타내는 파일이다.
 	 - 배포스캐너가 작성하는 파일
 - .deployed
 	 - 애플리케이션 배포가 완료되었음을 나타낸다.
 	 - 배포스캐너가 작성하는 파일로 사용자가 이 파일을 삭제했을 경우엔 콘텐츠가 배포되지 않는다.
 - .failed
 	 - 애플리케이션 배포 중 오류가 발생하여 배포 실패한 것을 나타낸다.
 	 - 배포 스캐너가 작성하는 파일로 파일 안에 배포 오류 메시지가 들어 있다.
 - .isundeplyoing
 	 - .dodeploy파일이 삭제되어 애플리케이션이 undeply되고 있는 상태를 나타낸다.
 	 - 배포 스캐너가 작성하는 파일이다.
 	 - undeploy가 완료되면, 이 마커파일은 삭제된다.
 - .undeployed
 	 - 애플리케이션이 undeploy된 상태를 나타낸다.
 - .pending
 	 - 서버에서 애플리케이션을 배포하고 있거나, 문제가 생겨 애플리케이션 배포 명령을 서버에 보내지 못한 상태


 배포하기 위한 마커 파일명은 -----.war.dodeploy가 된다.
 - 마커 파일은 파일 내에 내용이 없는 0바이트 비어있는 파일을 만들면 된다.
 - 파커파일의 종류



## ※ Chapter03. JBoss EAP 6설치하기
### 2.10. CLI사용법
 - CLI(Command Line Interface)
 	 - JBoss를 관리하기 위한 도구
 	 - $JBOSS-HOME > bin > jboss-cli.sh 스크립트 실행
 - 주요 옵션
 	 - help
 	 	 - jboss-cli의 도움말 표시
 	 - controller
 	 	 - connect의 명령으로 접속할 호스트 IP와 포트번호를 '--controller=IP주소:포트'와 같이 지정한다.
 	 	 - 생략하면 localhost:9999를 사용
 	 - connect(-c)
 	 	 - 시작후 바로 서버에 접속한다.
 	 - gui
 	 	 - GUI모드로 시작한다.
 	 - command
 	 	 - 한개의 명령어 또는 오퍼레이션을 지정하여 실행한다.
 	 - commands
 	 	 - 여러 개의 명령어 또는 오퍼레이션을 콤마로 지정하여 실행한다.
 	 - ex.
 	 	 `./jboss-cli.sh --connect --controller=localhost:9999`
