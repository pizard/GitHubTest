# RestTemplate
 - spring 3 부터 지원
 - 클라이언트 측의 HTTP 접근을 위한 핵심적인 Spring 클래스
 - 개념적으로는 이는 JdbcTemplate, JmsTemplate 및 Spring Framework와 다른 포트폴리오 프로젝트에 있는 다른 템플릿들과 매우 유사하다.
 - 이는 RestTemplate이 일단 생성되면 스레드에 안전하며 이것의 오퍼레이션을 직접 정의하기 위해 콜백을 사용할 수 있다는 것을 의미한다.

## RestTemplate Methods
 - HTTP
 	 - RestTemplate
 - DELETE
 	 - public void delete(String url, Object... urlVariables) throws RestClientException;
	 - public void delete(String url, Map<String, ?> urlVariables) throws RestClientException;
	 - public void delete(URI url) throws RestClientException;
 - GET
 	 - public <T> T getForObject(String url, Class<T> responseType, Object... urlVariables) throws RestClientException;
 	 - public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> urlVariables) throws RestClientException;
 	 - public <T> T getForObject(URI url, Class<T> responseType) throws RestClientException;
 	 - public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... urlVariables);
 	 - public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Map<String, ?> urlVariables);
 	 - public <T> ResponseEntity<T> getForEntity(URI url, Class<T> responseType) throws RestClientException;
 - HEAD
	 - public HttpHeaders headForHeaders(String url, Object... urlVariables) throws RestClientException;
	 - public HttpHeaders headForHeaders(String url, Map<String, ?> urlVariables) throws RestClientException;
	 - public HttpHeaders headForHeaders(URI url) throws RestClientException;
 - OPTIONS
 	 - public Set<HttpMethod> optionsForAllow(String url, Object... urlVariables) throws RestClientException;
 	 - public Set<HttpMethod> optionsForAllow(String url, Map<String, ?> urlVariables) throws RestClientException;
 	 - public Set<HttpMethod> optionsForAllow(URI url) throws RestClientException;
 - POST
 	 - public URI postForLocation(String url, Object request, Object... urlVariables) throws RestClientException;
 	 - public URI postForLocation(String url, Object request, Map<String, ?> urlVariables);
 	 - public URI postForLocation(URI url, Object request) throws RestClientException;
 	 - public <T> T postForObject( String url, Object request, Class<T> responseType, Object... uriVariables);
 	 - public <T> T postForObject( String url, Object request, Class<T> responseType, Map<String, ?> uriVariables);
 	 - public <T> T postForObject(URI url, Object request, Class<T> responseType) throws RestClientException;
 	 - public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Object... uriVariables);
 	 - public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException;
 	 - public <T> ResponseEntity<T> postForEntity(URI url, Object request, Class<T> responseType) throws RestClientException;
 - PUT
 	 - public void put(String url, Object request, Object... urlVariables) throws RestClientException;
 	 - public void put(String url, Object request, Map<String, ?> urlVariables) throws RestClientException;
 	 - public void put(String url, Object request, Map<String, ?> urlVariables) throws RestClientException;

## URI Template
 - 각각의 메소드는 첫번째 인자로 URI를 취한다. 이 URI는 URI template과 일반적인 URI로 템플릿을 확장하기 위해 사용되는 변수가 될 수 있다.
 - 템플릿 형태는 두가지 형태로 넘겨줄 수 있다.
 	 1. String 변수 인자 배열
 	 2. Map
 - 문자열 가변 변수는 주어진 템플릿 변수의 순서대로 확장된다.
 - ex. `http://example.com/hotel/42/bookcing/21`
	 -> `String result = restTemplate.getForObject("http://example.com/hotels/{hotel}/bookings/{booking}", String.class, "42", "21")`
 
	 -> ```
	 Map<String, String> vars = new HashMap<String, String>();
	 vars.put("hotel", "42");
	 vars.put("booking", "21");
	 String result = restTemplate.getForObject("http://example.com/hotels/{hotel}/bookings/{booking}", String.class, vars)
	 ```


