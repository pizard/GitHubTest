# ContentNegotiatingViewResolver
  - View를 찾기 위해 요청 URL의 확장자와 AcceptHeader를 사용하는 ViewResolver
  - 자체적으로 View를 찾지는 않으며 viewResolver에 설정된 ViewResolver를 사용하여 View를 찾음
  - ex.
 	```
 	<bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
 		<!-- ViewResolver 우선순위 설정 -->
 		<property name="order" value="1" />
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
 	 - order
 	 	 - Spring MVC에 등록된 View Resolver 중 우선순위
 	 - mediaTypes
 	 	 - URL의 확장자와 contentType을 연결해주는 일종의 맵
 	 	 - ex. 
 	 	 	 - 'http://localhost/user.html': html에 연결된 text/html을 처리하는 View 참조
 	 	 	 - 'http://localhost/user.json': json객체로 응답 처리하는 View 참조
 	 - ViewResolvers
 	 	 - ContentNegotiatingViewResolver가 View를 찾기 위해 사용하는 ViewResolver
 	 - defaultViews
 	 	 - viewResolvers가 View를 찾지 못한 경우에 사용되는 view 
 	 	 - Content-Type에 따라 기본으로 제공되는 View 클래스를 지정 할 수 있습니다


 - spring-mvc 3.2 이후 수정
 	```
 	<bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
		<property name="contentNegotiationManager">
			<bean class="org.springframework.web.accept.ContentNegotiationManager">
				<constructor-arg>
				<bean class="org.springframework.web.accept.PathExtensionContentNegotiationStrategy">
					<constructor-arg>
						<map>
							<entry key="json" value="application/json" />
							<entry key="xml" value="application/xml" />
						</map>
					</constructor-arg>
				</bean>
				</constructor-arg>
			</bean>
		</property>
		<!-- 위의 viewResolvers 에 의해 view를 얻지 못했을 경우에 사용되는 view -->
		<property name="defaultViews">
			<list>
				<!-- JSON View -->
				<bean class="org.springframework.web.servlet.view.json.MappingJacksonJsonView" />
				<!-- XML View -->
				<bean class="org.springframework.web.servlet.view.xml.MarshallingView">
					<constructor-arg>
						<bean class="org.springframework.oxm.jaxb.Jaxb2Marshaller">
							<property name="packagesToScan">
								<list>
									<value>com.tistory.redtrain.SampleDTO</value>
								</list>
							</property>
						</bean>
					</constructor-arg>
				</bean>
			</list>
		</property>
	</bean>
 	```
 	 - xml에 관한 DTO 모델을 선언할 때 XML 마샬링(Marshalling)을 해줘야 한다



 창조적 고찰 http://ismydream.tistory.com/139 ContentNegotiatingViewResolver 이해하기


 레드트레인 http://redtrain.tistory.com/821 
