# ViewResolver
 - DispatcherServlet에게 뷰 정보를 전달하는 방법
 	 1. View 타입의 오브젝트 전달
 	 2. String 타입의 뷰 이름 전달
 	 	 - 이름으로부터 실제로 사용할 뷰 객체를 결정해주는 ViewResolver가 필요
 - 뷰 오브젝트 < String 
 	 - 뷰 리졸버는 보통 뷰 오브젝트를 캐싱하기 때문

## ViewResolver의 종류
 1. [InternalResourceViewResolver](./ViewResolver/InternalResourceViewResolver.md)
 2. [ContentNegotiatingViewResolver](./ViewResolver/ContentNegotiatingViewResolver.md)