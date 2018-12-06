## Call By Reference or Call By Value ?
 - List의 경우 Call By Reference로 주소값을 참조한다.
 - 즉 Java 소스내에서 같은 객체를 이용하여 아무리 수정하면서 List에 추가 하더라도 동일한 Reference를 참조하기 때문에 결국 수정된 마지막 값을 출력한다.
 - 테스트 코드 

 - JAVA 소스 내에서 `new Object();`를 수행하는 순간 하나의 객체가 메모리 상에 생성된다.
 - 이것의 데이터를 여러번 바꾼다 하여도 결국 같은 메모리 주소의 값만 변경되고
 - 

 http://its21c.net/248