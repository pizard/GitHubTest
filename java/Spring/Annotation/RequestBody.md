# RequestBody
 - HTTP 요청의 body 내용을 자바 객체로 매핑하는 역할
 - HashMap을 이용할 수 없음
 	 - 대신 MultiValueMap을 넘겨서 처리해야함
 	 - http://javaiyagi.tistory.com/457

 - ex.
	```
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String TestController(@RequestBody String **body**) {
		return body;
	}
	```
	 - POST방식으로 전송된 HTTP 요청 데이터를 String 타입의 body 파라미터로 전달