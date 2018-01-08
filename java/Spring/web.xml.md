# web.xml
 - 톰캣의 실행환경에 대한 정보를 담당하는 '환경설정' 파일
 - 각종 servlet의 설정과 servlet 매핑, 필터, 인코딩 등을 담당한다.
 - 톰캣에 있는 모든 web application의 기본설정을 정의한다.
 - application이 deploy될 때 각 application의 WEB-INF/web.xml deployment descripter에 따라 처리
 - 종류
 	 - DefaultServlet
 	 	 - 공유 자원을 제공하며 servlet mapping 을 가진 모든 요청을 처리한다. 
 	 	 ```
		<servlet>
		    <servlet-name>default</servlet-name>
		    <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>
		    <init-param>
		        <param-name>debug</param-name>
		        <param-value>0</param-value>
		    </init-param>
		    <init-param>
		        <param-name>listings</param-name>
		        <param-value>false</param-value>
		    </init-param>
		    <load-on-startup>1</load-on-startup>
		</servlet>
		```	
 	 - InvokerServlet
 	 	 - web.xml파일에 정의되지 않은 어떠한 servlet 클래스라도 실행할 수 있도록 한다.
	 	 ```
	 	 <servlet>
		    <servlet-name>invoker</servlet-name>
		    <servlet-class>org.apache.catalina.servlets.InvokerServlet</servlet-class>
    		<... 기타 속성들 ...>
		 </servlet>
	 	 ```
	 - JspServlet
	 	 - JSP의 컴파일과 실행을 담당
	 	 ```
	 	 <servlet>
    		<servlet-name>jsp</servlet-name>
    		<servlet-class>org.apache.jasper.servlet.JspServlet</servlet-class>
    		<... 기타 속성들 ...>
		 </servlet>
	 	 ```




 	 http://jinwoonote.tistory.com/entry/톰캣-webxml-설명