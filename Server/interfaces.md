# interfaces
 - JBoss의 경우 처음 설치를 했을때 IP binding이 되어 있어서 localhost에서만 접근이 가능해 외부에서 접속이 안된다.
 - 이를 해제하기 위해 interface부분을 다음과 같이 변경해줘야한다.
 	```
 	<interfaces>
        <interface name="management">
            <inet-address value="${jboss.bind.address.management:114.203.87.148}"/>
        </interface>
        <interface name="public">
            <inet-address value="${jboss.bind.address:114.203.87.148}"/>
        </interface>
        <interface name="unsecure">
            <inet-address value="${jboss.bind.address.unsecure:114.203.87.148}"/>
        </interface>
    </interfaces>
    ```
 - unsecure
 	 - jacob 서브시스템이 추가된 경우 사용
 	 - standard configuration에 IIOP 소켓에 사용
 	 - JabORB를 보홓하기위해 SSL을 설치해야함
 	 - ㅇ.ㅇ..
