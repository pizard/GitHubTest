#WildFly
## Window CMD에서 Linux tail 명령어 사용하기!
 1. windows Server 2003 Resource Kit Tools 또는 이 파일 안의 tail.exe 파일을 받는다.
 2. window설치폴더(Windows)/System32에 복사한다.
 3. 사용한다.(바로 사용 가능)

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

## CMD 명령어 한줄에 2개 사용하기
 - 명령어
 	 1. `echo hello`
 	 2. `echo world`
 - 결과
 	 1. `echo hello && echo world`
 - 즉 명령어 사이에 &&를 넣으면 된다.


## 출처
 - [DEV BIBLE](http://devbible.tistory.com/375 "[Tips] 리눅스의 tail 명령어를 윈도우에서 사용하기")
 	 - Window CMD에서 Linux tail 명령어 사용하기!
 - [bgasparotto](https://bgasparotto.com/start-stop-restart-wildfly/ "Start, Stop and Restart Wildfly")
 	 - Start, Stop and Restart Wildfly
 - [제타위키](https://zetawiki.com/wiki/윈도우_CMD_명령어_한줄로_합치기 "윈도우_CMD_명령어_한줄로_합치기")
 	 - CMD 명령어 한줄에 2개 사용하기