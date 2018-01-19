# RequestBody
 - 파라미터로 HTTP 요청의 body부분이 그대로 전달된다.
 - HttpMessageConverter를 이용함으로써 request body를 전환시킨다
 - HashMap을 이용할 수 없음
 	 - 대신 MultiValueMap을 넘겨서 처리해야함
 	 - http://javaiyagi.tistory.com/457
 - 일반적인 GET/POST 보다는 XML또는 JSON형식에서 유용하게 사용된다.

 - ex.
	```
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String TestController(@RequestBody String **body**) {
		return body;
	}
	```
	 - POST방식으로 전송된 HTTP 요청 데이터를 String 타입의 body 파라미터로 전달
https://stackoverflow.com/questions/28039709/what-is-difference-between-requestbody-and-requestparam