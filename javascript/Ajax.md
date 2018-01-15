# jQuery.ajax()
## jQuery.ajax(url, [,settings])
 - 정의
 	 - 비동기적 HTTP(Ajax)요청을 수행
 - url
 	 - Type: String
 	 - 요청을 전달할 URL을 내포하고 있음
 - settings
 	 - Type: PlainObject
 	 - Ajax 요청의 환경설정을 하기 위한 key/value형식의 세트
 	 - default는 $.ajaxSetup()을 통해 어떤 옵션도 설정할 수 있음
 	 - 아래의 jQuery.ajax(settings)를 통해 모든 설정을 설명

## jQuery.ajax(settings)
 - accepts
 	 - default: depends on DataType
 - async
 	 - default: true

 - complete

 - converters
 	 - default: "* text": window.String / "text html": true, "text json": jQuery.parseJSON, "text xml" : jQuery.parseXML
 	 - Type: PlainOjbect
 	 - 데이터 타입 변화기를 갖고있는 객체
 	 - 1.5버전 이후 추가

 - CrossDomain
 	 - default: false(same-domain), true(cross-domain)
 	 - Type: Boolean
 	 - 만약 같은 도메인에서 crossDomain 요청(JSONP와 같은)을 강제하고 싶은 경우 사용
 	 - 예를들면 서버측의 다른 도메인으로의 redirection을 허용한다.
 	 - 1.5버전 이후 추가

 - dataType
 	 - default: Intelligent Guess( xml, json, script, or html)
 	 - Type: String
 	 - 서버로부터 받는 돌려받는 예상되는 데이터의 형식
 	 - 아무것도 명시되어 있지 않다면, jQuery는 MIME타입의 응답에 근거하여 제공한다.
 	 	 - XML: jQuery를 통해 가공된 XML 문서를 전달함
 	 	 - HTML: HTML을 일반적 문자로 전달함
 	 	 - script: JavaSciprt의 응답을 확인하고 일반 문자로 전달함
 	 	 	 - `_=[TIMESTAMP]`: cache 옵션을 `true`로 설정 하지 않는 한 쿼리의 문자 파라미터에 의한 캐싱을 막을 수 있음
 	 	 - json: JSON의 응답을 평가하고 JavaScript Object를 전달함
 	 	 	 - Cross-domain의 json의 경우 `jsonp:false`를 설정 하지 않는 한 요청이 jsonp로 전환됨
 	 	 	 - JSON 데이터는 규정된 manner로 분석된다.; 기형의 JSON의 경우 거절되고 parse error가 전달
 	 	 	 - jQuery 1.9이후, 비어있는 응답또한 거절된다. 서버는 null 또는 {}로 응답을 전달해야함]
 	 	 - text: 일반 text 문자
 	 	 - multiple: jQuery 1.5이후, jQuery는 받은 Content-Type header에서 원하는 타입으로 DataType을 바꿀 수 있음
 	 	 	 - ex. `text xml`: text로 수신한 응답을 xml의 형식으로 다룸
 	 	 	 - ex. `jsonp text xml`: JSONP 요청을 text로 수신하고 XML로 해석
 	 	 	 - ex. `jsonp xml`: 먼저 jsonp를 xml으로 전환을 시도하고 실패시 jsonp를 text로 전환 그 후 text를 xml로 전환

 - method
 	 - default: 'GET'
 	 - Type: String
 	 - 요청을 보내기 위한 HTTP method('POST', 'GET', 'PUT')
 - type
 	 - default: 'GET'
 	 - Type: String
 	 - method라 불린다.
 	 - jQuery 1.9.0이전의 버젼들은 type을 사용해야만 한다.

  - error
 	 - Type: Function(jqXHR jqXHR, String textStatus, String errorThrown)
 		 - jqXHR(jQuery 1.4.x, XMLHttpRequest): 예외 처리된 object와 발생한 에러의 타입
 		 - textStatus: "null", "timeout", "error", "abort", "parsererror"
 		 - errorThrown: HTTP에러가 발생한 경우, HTTP의 원문 일부를 받는다("Not Found", "Internal Server Error") 
 		 	 - 1.5 jQuery이후, `erroe`환경은 함수의 array들을 받을 수 있음
 		 	 - 각 함수는 
 - success
 	 - Type: Function(Anything data, String, textStatus, jqXHR jqXHR)
 	 	 - 1.5 jQuery이후, 


## CROSS-ORIGIN HTTP 요청
 - 처음 전송되는 리소스의 도메인과 다른 도메인으로부터 리소스가 요청될 경우 해당 리소스는 cross-origin HTTP 요청에 의해 요청됩니다.
 - 보안 상의 이유로 브라우저들은 스크립트 내에서 초기화되는 cross-origin HTTP 요청을 제한합니다.

 
## Type vs Method
 - 새로운 버전에서 명칭이 바뀐거임

## 와우..., 상세 조사 및 정리 필요
 - 일단 DELETE, PUT 같은 경우 RequestParam을 받질 못함
 - ReqeustBody의 형태로 받아야하는데
 - 이게 또 form태그로 보낼때 추가되는 application/x-www-form-urlencoded의 Content-Type으로는 보안상 전송이 안됨
 - 그렇기 때문에 /json 또는 /xml의 형식으로 전송해야하고, 데이터를 JSON형식으로 바꿔야함
	 - JSON.stringify($("#frm").serializeArray()사용
	 - https://stackoverflow.com/questions/22195065/how-to-send-a-json-object-using-html-form-data

## ERROR 
 - Required String parameter '인자아!' is not present
 	 - 인자로 넘어오는 값이 없다는 의미
 	 - defaultValue를 설정해 주거나 값을 제대로 넘겨 주거나

## 참고
 - [api.jQuery](http://api.jquery.com/jquery.ajax/ "jQuery")
	 - 모든 내용
	 - 필요 부분만 해석함