# InternalResourceViewResolver
 - Default(기본) ViewResolver
 - UrlBasedViewResolver를 상속받아 사용법은 유사
 - 뷰 이름으로부터 JSP나 Tiles연동을 위한 AbstractUrlBasedView객체를 리턴
	```
	<bean id="jspViewResolver" class="org.springframework.web.sevlet.view.InternalResourceViewResolver">
		<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
		<property name="prefix" value="/WEB-INF/jsp/"/>
		<property name="suffix" value=".jsp"/>
	</bean>
	```
 - ex. 위의 경우
	 - controller에서 넘겨준 modelAndView 값이 index인 경우
	 - `/WEB-INF/jsp/index.jsp`로 이동