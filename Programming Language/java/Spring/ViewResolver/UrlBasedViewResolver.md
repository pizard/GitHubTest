# UrlBasedViewResolver
 - ViewResolver의 구현체로 특별한 맵핑 정보 없이 의미상 view이름을 URL로 사용
 - View이름과 실제 view자원과의 이름이 같은 경우 사용
 - 사용자에게 보여줄 prefix, suffix를 지정할 수 있음
	```
	<bean id="viewResolver" class="org.springframework.web.sevlet.view.UrlBasedViewResolver">
 		<property name="prefix" value="WEB-INF/jsp/"/>
 		<property name="suffix" value=".jsp"/>
	</bean>
	```
 - ex. 위의 경우
 	 - controller에서 넘겨준 modelAndView 값이 index인 경우
 	 - `/WEB-INF/jsp/index.jsp`로 이동