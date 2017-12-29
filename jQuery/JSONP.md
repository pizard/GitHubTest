# JSONP
 - JSON데이터를 cross-domain 문제 걱정없이 전송하기 위한 method
 - XMLHttpRequest object를 이용하지 않고 `<script>`를 이용

## JSONP Intro
 - JSONP는 충전재가 포함된 JSON
	 - cross-domain정책에 의해, 다른 도메인으로 파일을 요청하는 것은 문제가 발생할 수 있다.
	 - 또다른 도메인으로부터 외부 script를 요청하는 것은 이런 문제로 부터 자유롭다.
	 - JSONP는 이런 이점을 이용하는데, XMLHttpRequest 객체로 요청을 하는 대신 script로 요청한다.
	 - `<script src="demo_jsonp.php>`

## The Server File
 - 서버안의 파일은 결과를 function call안에 감싼다.
	```
	<?php
	$myJSON = '{ "name":"John", "age":30, "city":"New York" }';

	echo "myFunc(".$myJSON.");";
	?>
	```
	-> `myFunc({ "name":"John", "age":30, "city":"New York" });`
	 - result는 JSON데이터를 "myFunc"라는 function안에 담아 parameter로 return한다.

## The JavaScript function
 - "myFunc"라는 함수는 client에 위치해 있고, JSON 데이터를 다룰 준비를 한다.
 	```
 	function myFunc(myObj) {
	document.getElementById("demo").innerHTML = myObj.name;
	}
	```

## Creating a Dynamic Script Tag
 - 위의 예시에서는 script tag를 놓는 위치에 따라 페이지가 로딩되면서 "myFunc"함수를 시행시키는데 이는 매우 안전하지 않다.
 - 다음은 버튼 클릭되었을때 `<script>` tag를 생성하는 예시이다.
 	```
 	function clickButton() {
		var s = document.createElement("script");
		s.src = "demo_jsonp.php";
		document.body.appendChild(s);
	}
 	```

## Dynamic JSONP Result
 - 위의 예시 또한 여전히 정적이다.
 - 다음은 JSON을 php파일에 보냄으로써 동적으로 만드는 예시이다. 그리고 php파일은 JSON 객체를 반환한다.
 	 - PHP파일
	```
 	<?php
	header("Content-Type: application/json; charset=UTF-8");
	$obj = json_decode($_GET["x"], false);

	$conn = new mysqli("myServer", "myUser", "myPassword", "Northwind");	
	$result = $conn->query("SELECT name FROM ".$obj->$table." LIMIT ".$obj->$limit);
	$outp = array();
	$outp = $result->fetch_all(MYSQLI_ASSOC);

	echo "myFunc(".json_encode($outp).")";
	?>
	```
	 - 설명
		 - PHP 함수 `json_decode()`를 이용하여 요청을 객체로 변환한다.
		 - 데이터베이스에 접근해서 배열을 요청된 데이터로 채운다.
		 - 배열을 객체에 추가한다.
		 - `json_encode()`함수를 이용해서 배열을 JSON으로 변환한다.
		 - 리턴 객체를 `myFunc()`로 감싼다.
	 - JavaScript 예제
	 	 - `myFunc()`는 위의 php 파일로부터 호출된다.
	```
	function clickButton() {
    	var obj, s
    	obj = { "table":"products", "limit":10 };
    	s = document.createElement("script");
    	s.src = "jsonp_demo_db.php?x=" + JSON.stringify(obj);
    	document.body.appendChild(s);
	}
	function myFunc(myObj) {
	    var x, txt = "";
	    for (x in myObj) {
	        txt += myObj[x].name + "<br>";
	    }
	    document.getElementById("demo").innerHTML = txt;
	}
	```

### Callback Function
 - 서버 파일을 대한 통제 할 수 없을때, 어떻게 서버파일을 옮은 함수로 전달할 것인가?
 - 때때로 서버 파일은 callback 함수를 parameter로 제공한다.
 - Example
	```
	function clickButton() {
	    var s = document.createElement("script");
	    s.src = "jsonp_demo_db.php?callback=myDisplayFunction";
	    document.body.appendChild(s);
	}
	function myDisplayFunction(myObj) {
		document.getElementById("demo").innerHTML = myObj.name;
	}
	```

### AbstractJsonpResponseBodyAdvice
 - public abstract class AbstractJsonpResponseBodyAdvice extends AbstractMappingJacksonResponseBodyAdvice


# JSNOP
 - 동일 근원정책(Same-Origin Policy, SOP)
 	 - 자바스크립트는 서로 다른 도메인(cross-domain)에 대한 요청을 보안상 제한함
 - Spring MVC 4.2가 배포된 이후, @ResponseBody와 ResponseEntity 함수에 JSONP를 지원하기 위해 AbstractJsonpResponseBodyAdvice를 확장시킨 `@ControllerAdvice` bean을 선언했다.
 - `@ControllerAdvice`가 등록되면, 다른 domain으로 부터 `<script />` tag를 사용한 JSON 웹 서비스를 요청할 수 있다.

 - 아래의 bean은 URL을 이용한 JSONP를 통해 접근할 수 있다. 그리고 전달받은 JSONP payload는 그 아래와 같다.
	```
 	public class Post {
		private int id;
		private String title;
		private String body;
	}
 	```
 	 - JSONPpayload
	 	```
		postCallback({
			id: 11,
			title: "Post title",	
			body: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim 	ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ",
		})
 		```


 - 참조문서
 	 - https://www.w3schools.com/js/js_json_jsonp.asp
