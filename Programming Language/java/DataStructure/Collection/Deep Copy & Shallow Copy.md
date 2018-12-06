# Cloning
## Cloning
 - 정의
 	 - 메모리에 존재하는 객체의 완전한 복사본을 생성하는 과정
 - 특징	
 	 - 자바에서 java.lang.Object안의 clone() method가 cloning작업을 담당한다.


## Shallow Copy(얕은 복사)
 - 정의
 	 - 복제의 대상을 참조하는 또 다른 인스턴스를 만드는 행위
 	 - 객체가 가진 멤버의 값들을 새로운 객체로 복사하는데 객체가 참조 타입의 멤버를 갖고 있으면 참조 값(Referece Value)만 복사

## Deep Copy(깊은 복사)
 - 정의
 	 - 해당 객체를 복사할 때, 필드 유형이 참조 타입의 멤버일지라도 별도의 메모리에 개별 인스턴스로 복사




## 참고
 - [techshare](http://sysnet.pe.kr/221026178373 "Shallow Copy와 Deep Copy")
 - [entry](http://javacan.tistory.com/entry/31 "객체 클로닝에 관하여")

## SourceCode
 - https://github.com/pizard/StudyTIL_SourceCode/tree/master/StudyTIL/src/DataType/Clone


