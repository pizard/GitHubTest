# jindo.js
 - NHN이 오픈소스로 제공하는 Ajax프레임워크이다.
 - Naver에서 제공하는 UI의 상당수에서 사용되었고 크로스 브라우징에 있어서는 거의 완벽한 호환성된단다.
 - 여러 기능들이 많은데 이중에 Cookie부분을 쓸라했었다...
 - 하지만 최근(2017년)부터 더이상 기능 추가도 안하고 유지보수도 안한단다ㅜㅜ 
 - 그래서 Pass~

#jquery.cookie.js
## 사용법
 - 뭐 딱히 적을건 없다. 아래 사이트 가면 잘 설명되어 있음

## 도메인 간 쿠키 공유하기
 - cookie를 사용하려한 목적이 이거를 통한 웹추적이었는데 결론적으로 말하면 안된단다.
 - 동일한 사이트의 서브도메인 쿠키는 이용할 수 있지만 다른 도메인같의 쿠키값은 공유될 수 없다.
 - 아마 보안의 문제나 그 뭐냐 따라다니는 광고? 이런게 이유일 것 같다
 - 쨋든 URL Parameter를 사용하는 방식으로 바꿔야긋다...ㅜ

### SampleCode
 - URL Parsing 및 쿠키 추가(put)
	 - url parameter를 확인하고 조건에 따라 1시간 동안 유지되는 쿠키 추가

	```
 	$(document).ready(function() {
		var parser = document.createElement('a'),
    	searchObject = {},
    	queries, split, i;
		parser = parseURL(document.location.href);

		function parseURL(url) {
	    	// Let the browser do the work
	    	parser.href = url;
	    	// Convert query string to object
	    	queries = parser.search.replace(/^\?/, '').split('&');
	    	for( i = 0; i < queries.length; i++ ) {
	    	    split = queries[i].split('=');
	    	    searchObject[split[0]] = split[1];
	    	}
	    	return {
	        	protocol: parser.protocol,
	        	host: parser.host,
	       		hostname: parser.hostname,
	        	port: parser.port,
	        	searchObject: searchObject,
	        	hash: parser.hash
	    	};
		}
		if(parser.searchObject.parameter_check == 'check_value'){
			var date = new Date();
			date.setTime(date.getTime() + 60*60*1000); // 60분, 1시간
			$.cookie('parameter_cookie', searchObject.parameter_cookie, {expires: date, path:'/'});
		}
 	});
	```

 - 쿠키 확인
 	```
 	function cookieCheck(check_value) {
		if(check_value == $.cookie('parameter_cookie')){
			// check_value와 cookie의 값이 일치한 경우
		}else{
			// check_value와 cookie의 값이 다른 경우
		}
		return null;
	}
 	```


### 참고
 - [werty](http://naminsik.com/blog/1864 "werty") / [쿡래빗XE센터](http://xecenter.com/xe/open_tip/4684 "werty")
	 - jQuery.cookie.js 사용법
 - [Jinolog](http://jinolog.com/programming/etc/2011/11/13/sharing-cookies-across-multiple-domains.html "여러 도메인들 간 쿠키 공유하기")
	 - 여러 도메인들 간 쿠키 공유하기
 - [abeautifulsite](https://www.abeautifulsite.net/parsing-urls-in-javascript "Parsing URL, in JavaScript")
 	 - SampleCode > URL 파싱부분 참고