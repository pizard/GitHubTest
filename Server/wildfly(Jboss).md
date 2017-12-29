#WildFly
## Start, Stop and Restart Wildfly
 - Start
 	 - Linux: `$ ./standalone.sh`
 	 - Windows: `> standalone.bat`
 - Stop
 	 - Linux: `$ ./jboss-cli.sh --connect command=:shutdown`
 	 - Windows: `> jboss-cli.bat --connect command=:shutdown`
 - Restart
 	 - Linux: `$ ./jboss-cli.sh --connect command=:reload`
 	 - Windows: `> jboss-cli.bat --connect command=:reload`
 - Start in domain mode
 	 - Linux: `$ ./domain.sh &`
 	 - Windows: `> domain.bat`

## Window CMD에서 Linux tail 명령어 사용하기!
 1. windows Server 2003 Resource Kit Tools 또는 이 파일 안의 tail.exe 파일을 받는다.
 2. window설치폴더(Windows)/System32에 복사한다.
 3. 사용한다.(바로 사용 가능)

## CMD 명령어 한줄에 2개 사용하기
 - 명령어
 	 1. `echo hello`
 	 2. `echo world`
 - 결과
 	 1. `echo hello && echo world`
 - 즉 명령어 사이에 &&를 넣으면 된다.
 - 인데 원래 윈도우 서버에서 실행을 하면서 동시에 log파일이 뜨도록 하고싶었는데

## CMD 명령어 한줄에 2개 사용하기
 - 명령어
 	 1. `echo hello`
 	 2. `echo world`
 - 결과
 	 1. `echo hello && echo world`
 - 즉 명령어 사이에 &&를 넣으면 된다.
 - 인데 원래 윈도우 서버에서 실행을 하면서 동시에 log파일이 뜨도록 하고싶었는데 


## service.bat
 - 이거 정확한 파일의 기능은 잘 모르겠다. 
 - 아마 서비스와 관련된 배치파일인 것 같은데 이걸 종료시키고 계속 Wildfly를 실행시켰더니 계속 undelpoyed가 뜨며 실행되지 않는다.
 - 찾기로는 Window Service에서 WildFly standalone server를 돌릴 때, standalone.bat파일을 옵션 없이 실행시킨다고 한다.
 - 근데 이해가 안되는거는 이 파일이 꺼져있을때도 알아서 deployment 파일을 찾아가 실행자체는 시켰던거 같은데... 확인필요!


## wildfly 설정파일(standalone.xml)
 - 위치
	 - ...(파일위치)\wildfly-9.0.2.Final\standalone\configuration
 - 설정
 	 - 아래 요런 느낌으로 수정
 	 ```
 	 <socket-binding-group name="standard-sockets" default-interface="public" port-offset="${jboss.socket.binding.port-offset:0}">
        <socket-binding name="management-http" interface="management" port="${jboss.management.http.port:----}"/>
        <socket-binding name="management-https" interface="management" port="${jboss.management.https.port:----}"/>
        <socket-binding name="ajp" port="${jboss.ajp.port:----}"/>
        <socket-binding name="http" port="${jboss.http.port:----}"/>
        <socket-binding name="https" port="${jboss.https.port:----}"/>
        <socket-binding name="txn-recovery-environment" port="----"/>
        <socket-binding name="txn-status-manager" port="----"/>
        <outbound-socket-binding name="mail-smtp">
            <remote-destination host="localhost" port="----"/>
        </outbound-socket-binding>
    </socket-binding-group>
 	 ```
 	 
## 출처
 - [bgasparotto](https://bgasparotto.com/start-stop-restart-wildfly/ "Start, Stop and Restart Wildfly")
 	 - Start, Stop and Restart Wildfly
 - [DEV BIBLE](http://devbible.tistory.com/375 "[Tips] 리눅스의 tail 명령어를 윈도우에서 사용하기")
 	 - Window CMD에서 Linux tail 명령어 사용하기!
 - [제타위키](https://zetawiki.com/wiki/윈도우_CMD_명령어_한줄로_합치기 "윈도우_CMD_명령어_한줄로_합치기")
 	 - CMD 명령어 한줄에 2개 사용하기