# ResponseBody
 - 자바 객체를 HTTP 요청의 body 내용으로 매핑하는 역할
 - 메소드에서 @ResponseBody가 있으면 리턴되는 값은 View를 통해서 출력되지 않고 HTTP Response Body에 직접 쓰여지게 됩니다.
 - 쓰여지기 전에 리턴되는 데이터 타입에 따라 MessageConverter에서 변환이 이뤄진 후 쓰여짐
 - Spring 3.1 이후 <mvc:annotation-driven/>을 통해 annotation을 스캔한다면 HttpMessageConverter를 기본적으로 등록하기 때문에 별다른 설정 없이 JAXB2와 Jackson 라이브러리만 추가하면 따로 설정하지 않아도 Jaxb2RootElementHttpMessageConverter, MappingJacksonHttpMessageConverter가 자동으로 추가 등록
 - ex.
	```
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String TestController(@RequestBody String body) {
		return **body**;
	}
	```
	 - 해당 메소드의 리턴값을 HTTP 응답데이터로 사용