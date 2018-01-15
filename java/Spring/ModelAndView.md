# ModelAndView
 - Spring 2.0이전 버전의 컨트롤러에서 주요 방법
 - Controller의 처리 결과를 보여줄 view와 view에서 사용할 값을 ViewResolver로 전달하는 클래스
 - 생성자
 	 - ModelAndView()
 	 - ModelAndView(Object view)
 	 - ModelAndView(Object view, Map model)
 	 - ModelAndView(Object view, String modelName, Object modelObject)
 	 - ModelAndView(String viewName)
 	 - ModelAndView(String viewName, Map model)
 	 - ModelAndView(String viewName, Map model, Object modelObject)
 - Parameter
 	 - Object view: 렌더링 할 view
 	 - Map model: view에 전달할 Map
 	 - String modelName: 전달할 객체의 이름
 	 - Object modelObject: 전달할 객체의 값
 	 - String viewName: View Resolver에 전달할 View 이름
 	 - Map model: View에 전달할 객체의 이름과 값
 - Method
 	 - addAllObject(Map modelMap)
 	 	 - modelMap에 저장된 키-값 쌍 전체를 View에 전달
 	 - addObject(Object attributeValue)
 	 	 - 클래스 명에 따라 View에 attributeValue를 전달
	 	 	 - 클래스 명이 ModelClass인 경우
	 	 	 	 - modelClass
	 	 	 - 클래스 명이 ModelClass[]인 경우
	 	 	 	 - modelClassList 
	 	 	 - Collection 클래스가 ModelClass를 갖는 경우
	 	 	 	 - modelClassList
 	 - addObject(String attributeName, Object attributeValue)
 	 	 - View에 attributeName의 이름으로 attributeValue 전달
 	 - setViewName(String viewName)
 	 	 - ViewResolver에 전달할 viewName 설정
 - Redirect 방식
 	 - setViewName에 view 이름으로 redirect: 접두어를 붙인다.
 	 - ex. `mv.setViewName("redirect:/test.do")`


 	 http://transcendto.tistory.com/entry/Spring-ModelAndView-%EC%A0%95%EB%A6%AC
 	 http://qqqqqq.tistory.com/entry/Spring-ModelAndView%EC%99%80-ViewResolver
