# TilesViewResolver
 - 런타임 시 전체 페이지에 조립되는 페이지의 조각을 배치하기 위한 템플릿 프레임워크
 - dispatcher-servlet.xml
	```
	<bean id="tilesViewReseolver" class="org.springframework.web.servlet.view.UrlBasedViewResolver"
		<property name="viewClass" value="org.springframework.web.servlet.view.tiles2.TilesView"/>
	</bean>
	<bean id="tilesConfigurer" class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<property name="definitions">
			<list>
				<value>classpath:/config/tiles/tiles.xml</value>
			</list>
		</property>
	</bean>
	```
	 - UrlBasedViewResolver를 정의한 후 viewClass를 TilesView 정의
	 - Tiles 매핑 관련 정보가 작성되어 있는 tiles definition 파일의 위치를 정의

 - tiles.xml
	```
    <!--  메인 페이지 구조 정의  -->
    <definition name="plaform/main/*" template="/WEB-INF/views/_layout/contents/main.jsp">
        <put-attribute name="title" value="COSCOI PLAFORM Administrator" />
        <put-attribute name="header" value="/WEB-INF/views/_layout/header.jsp" />
        <put-attribute name="aside" value="/WEB-INF/views/_layout/aside.jsp" />
        <put-attribute name="contents" value="/WEB-INF/views/plaform/main/{1}.jsp" />
        <put-attribute name="footer" value="/WEB-INF/views/_layout/footer.jsp" />
    </definition>
    <!--  2depth 구조 정의  -->
    <definition name="*/*" template="/WEB-INF/views/_layout/contents/basic.jsp">
        <put-attribute name="title" value="COSCOI PLAFORM Administrator" />
        <put-attribute name="header" value="/WEB-INF/views/_layout/header.jsp" />
        <put-attribute name="aside" value="/WEB-INF/views/_layout/aside.jsp" />
        <put-attribute name="page-info" value="/WEB-INF/views/_layout/page-info.jsp" />
        <put-attribute name="contents" value="/WEB-INF/views/{1}/{2}.jsp" />
        <put-attribute name="footer" value="/WEB-INF/views/_layout/footer.jsp" />
    </definition>
    ```
	 - Tiles 구성



	 http://isstory83.tistory.com/117