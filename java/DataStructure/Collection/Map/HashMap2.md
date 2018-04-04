# HashMap
## Java HashMap은 어떻게 동작하는가?
 - Java 7, Java 8을 기준으로 구현 방식 설명
 - HashMap 자체의 소스코드는 Oracle JDK나 OpenJDK나 같기 때문에 둘 모두 설명이 가능
 - Java Collections Framework에 속한 구현체 클래스
 	 - 1998년 12월, Java 2부터 적용
 - Map 인터페이스
 	 - Java 5에서 Generic이 적용된 것 이외에 변화가 없음
 - HashMap 구현체
 	 - **성능 향상을 위해 지속적으로 변화해왔음** <- 이글의 포인트
 	 	 - Amortize Constant Time을 위해서 어떻게 해시 충돌(hash collision) 가능성을 줄이고 있는가?

## HashMap과 HashTable
 - HashTable
 	 - JDK 1.0부터 있던 Java API의 이름
 - HashMap
 	 - Java Collections Framework에 속한 API
 