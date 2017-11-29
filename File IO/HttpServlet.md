## **HttpServletRequest**
 - 기능
 	 - 클라이언트의 모든 요청 정보 보유
 	 - form data, query parameter, request header
 	 - InputStream(클라이언트로부터 전송되는 데이터)
 	 - 세션 정보, 쿠키, path...
 - Function
	 - request.getHeader(“User-Agent”);
	 	 - 클라이언트 플랫폼 정보 및 브라우저 정보
	 - `request.getCookies();`
	 	 - Request에 관련된 쿠키
	 - `request.getSession();`
	 	 - 클라이언트 세션 정보
	 - request.getMethod();
	 	 - Request의 HTTP 메소드
	 - request.getInputStream();
	 	 - Request의 입력 스트림, 

## **HttpServletResponse**
 - 역할
 	 - 클라이언트에 데이터를 전송하기 위해 사용
 	 - Response객체의 setContentType()과 getWriter() 메소드 사용
 	 - 위의 두 메소드를 사용한 후 html을 작성하거나 다른 컨텐츠를 기록하는 I/O작업 진행
 	 - 헤더 정보를 설정하거나 오류를 발생시키거나 쿠키를 추가하는 경우에도 사용
 - 출력방식
 	 - ServletOutputStream(OutputStream)
 	 	 - 바이트(Byte) Data를 출력할 때 사용
 	 	 - 무엇이든 사용 가능
 	 - PrintWriter
 	 	 - 문자(Character) Data를 출력할 때 사용
 	 	 - OutputStream으로 문자를 쓸 수 있지만, PrintWriter가 바로 문자를 사용하기 위해 만들어 짐
 	 	 ` 	PrintWriter writer = response.getWriter(); `
		 `	writer.println("some text and HTML"); `
	 - 특징
	 	 - PrintWriter는 사실 ServletOutputStream을 둘러싼(wrap) 것입니다. 즉 PrintWriter는 내부에 Servlet에 대한 참조를 가지고 있으며, 작업을 ServletOutputStream에게 부탁합니다.
	 	 - 즉 클라이언트에 대한 출력 Stream은 OutputStream뿐이고 PrintWriter는 좀 더 쓰기 쉽게 만든 Method

 - Header값 설정, 추가
 	 - setHeader() 
	 	 - Response의 Header에 값을 덮어(set) 씀
 	 - addHeader()
	 	 - Response의 Header에 값을 추가(add) 함
	 - setContentType("text/html") -> setHeader("content-type", "text/html"); 가능

 - Redirect / Dispatch
 	 - 요청에 대한 응답을 누가 할지 선택
 	 - Redirect
 	 	 - 요청을 완전히 다른 URL로 보냄
 	 - Dispatch
 	 	 - 웹 어플리케이션에 있는 다른 컴포넌트(JSP...)에게 처리 위임
 	 	 ` 	if (worksForMe) {
		    	// 요청을 핸들링합니다.
			} else {
		    	response.sendRedirect("http://www.redirect.com");
			} `