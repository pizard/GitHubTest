# **Calendar vs java Date**
 - java.util.Date
 	 - JSK1.0부터 사용
 - java.util.Calendar
 	 - JDK1.1에 좀더 기능을 향상시켜 추가

 - 다른 날짜를 계산한다면 Calendar, Calendar은 다른 주 날짜 사이의 차이를 이용하여 계산
 - Date는 명확한 그 순간을 이용하여 계산

 - 문제점
 	 - 불변객체가 아니다.
 	 	 - VO(Value Object)는 값에 의해 동등성이 판단되는 객체이다.
 	 	 - Java의 기본 날짜, 시간 클래스는 불변객체가 아니다.
 	 	 - Calendar, Date 클래스에는 set메서드를 호출해서 날짜를 지정하고, 다른 같은 객체에서도 set메서드를 호출하면 수행한 날짜 연산 결과는 같은 인스턴스에 저장된다.
 	 	 - 이 때문에 Calendar 객체나 Date객체가 여러 객체에서 공유되면 한 곳에서 바꾼 값이 다른 곳에 영향을 미치는 부작용이 생길 수 있음
 	 - 해결 방법
 	 	 - **객체를 복사해서 반환하는 기법 권장**
 	 	 	```
 	 		public Date getStartTime() {
	 	 		return this.startTime;						// 비권장
 	 	 	}
 	 	 	public Date getEndTime() {
	 	 		return new Date(this.endTime.getTime());	// 권장
	 	 	}
 	 	 	```
 	 - 헷갈리는 월 지정
	 	 - 1월 ~ 12월을 0 ~ 11로 표현
 	 	` calendar.set(1582, Calendar.OCTOBER , 4); // 이경우 Calendar.OCTOBER의 값은 '9'`
 	 	` calendar.set(1582, 10 , 4); 	// 1582년 11월 4일`
 	 - 해결방법
 	 	 - 가독성을 위해 아래와 같은 기법을 사용하는 사람도 있지만 완벽하진 않음
	 	 	` calendar.set(1582, 10 - 1 , 4); `


 - Calendar -> Date 변환
 	```
 	 Calendar cal = Calendar.getInstance();
			 ...
	 Date d = new Date(cal.getTimeInMillis()); // Date(long date)
 	```

 - Date -> Calendar 변환
	```
	 Date d = new Date();
			 ...
	 Calendar cal = Calendar.getInstance();
	 cal.setTime(d);
	```

### 참고
 - [아라비안나이트](http://arabiannight.tistory.com/entry/%EC%9E%90%EB%B0%94Java-Calendar-%EC%82%AC%EC%9A%A9%EB%B2%95-%EA%B8%B0%EB%B3%B8%EC%98%88%EC%A0%9C-%ED%8F%AC%ED%95%A8 "아라비안나이트")
 - [NaverD2](http://d2.naver.com/helloworld/645609 "NaverD2")
