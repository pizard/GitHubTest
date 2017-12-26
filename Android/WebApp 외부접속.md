# 톰캣 외부접속 허용으로 설정하기
 - 안드로이드 웹앱의 웹뷰 test를 위해 외부에서 로컬 접속이 필요한 경우 확인 사항! 
	 1. 방화벽 인바운드 규칙 확인(포트 연결)
	 2. Avast 같은 백신프로그램확인
	 3. 톰캣 서버의 server.xml확인
 	 - Connector부분에 address확인!
	 `<Connector acceptCount="100" address="0.0.0.0" connectionTimeout="20000" disableUploadTimeout="true" emptySessionPath="true" enableLookups="false" maxHttpHeaderSize="8192" maxThreads="250" port="6080" protocol="HTTP/1.1" redirectPort="8181"/>`

### 6. 참고
 - [개발창고](http://asm0628.tistory.com/176 "톰캣 외부접속 허용으로 설정하기")
 	 - 톰캣 서버의 server.xml 확인
