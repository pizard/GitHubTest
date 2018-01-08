# ContentNegotiatingViewResolver
  - View를 찾기 위해 요청 URL의 확장자와 AcceptHeader를 사용하는 ViewResolver
  - 자체적으로 View를 찾지는 않으며 viewResolver에 설정된 ViewResolver를 사용하여 View를 찾음
 	```
 	<bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
		<!-- 확장자와 contentType 을 연결해 준다. -->
		<property name="mediaTypes">
			<map>
			  <entry key="atom" value="application/atom+xml"/>
			  <entry key="html" value="text/html"/>
			  <entry key="json" value="application/json"/>
			</map>
		</property>
		<property name="viewResolvers">
			<list>
			  <bean class="org.springframework.web.servlet.view.BeanNameViewResolver"/>
			  <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
				<property name="prefix" value="/WEB-INF/jsp/"/>
				<property name="suffix" value=".jsp"/>
			  </bean>
			</list>
		</property>
		<!-- 위의 viewResolvers 에 의해 view를 얻지 못했을 경우에 사용되는 view -->
		<property name="defaultViews">
			<list>
			<bean class="org.springframework.web.servlet.view.json.MappingJacksonJsonView" />
			</list>
		</property>
		<property name="defaultContentType" value="application/json" />
	</bean>
 	```
 	 - mediaTypes
 	 	 - URL의 확장자와 contentType을 연결해주는 일종의 맵
 	 	 - ex. 
 	 	 	 - 'http://localhost/user.html': html에 연결된 text/html을 처리하는 View 참조
 	 	 	 - 'http://localhost/user.json': json객체로 응답 처리하는 View 참조
 	 - ViewResolvers
 	 	 - ContentNegotiatingViewResolver가 View를 찾기 위해 사용하는 ViewResolver
 	 - defaultViews
 	 	 - viewResolvers가 View를 찾지 못한 경우에 사용되는 view 