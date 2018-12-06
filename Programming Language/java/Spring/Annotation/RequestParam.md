# RequestParam
 - HTTP요청 파라미터를 메서드의 파라미터로 전달받을 때 사용
 - key=value 형태로 화면에서 넘어오는 쿼리스트링 혹은 폼 데이터를 메서드의 파라미터로 지정한다.
 - 대체로 파라미터의 개수가 적을때 사용
 - 단일 HTTP 요청 파라미터를 메소드 파라미터에 넣어주는 애노테이션
 - 하나이상의 파라미터를 적용할 수 있도 Map<String, Object>을 선언하면 모든 요청 파라미터를 담은 맵으로 받을 수 있음
 - 특정 Servlet request parameters로 연결된 파라미터?

 
https://stackoverflow.com/questions/28039709/what-is-difference-between-requestbody-and-requestparam