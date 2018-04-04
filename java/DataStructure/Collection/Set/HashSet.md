# Class HashSet <E>
 - package name
 	 - java.util.HashSet<E>
 - java.lang.Object > java.util.AbstractCollection > java.util.AbstractSet > java.util.HashSet
 - Type Parameter
 	 - SET을 이용하여 요소의 상태를 유지한다.
 - Implemented Interface
 	 - Serializable, Cloneable, Iterable<E>, Collection<E>, Set<E>
 - 데이터를 해쉬 테이블에 담는 클래스로 순서없이 저장

## Constructor
 - `HashSet()`
 	 - 비어있는 새 set을 구성한다.
 	 - HashMap 지원하기 위한 객체로 default로 수용량(16) 적재율(0.75)로 설정되어있다.
 - `HashSet(Collection<? extends E> c)`
 	 - 특정 collection의 요소를 포함하는 새로운 set을 구성한다.
 - `HashSet(int initialCapacity)`
 	 - 수용량을 initialCapacity로, 적재율은 default로 생성
 - `HashSet(int initialCapacity, float loadFactor)`
 	 - 수용량을 initialCapacity로, 적재율은 loadFactor로 생성

## Method
 - 고유
 	 - add(E e)
 	 	 - return Type: boolean
 	 	 - 해당 set에 특정 element e가 없는경우 e를 추가
 	 - clear()
 	 	 - return Type: void
 	 	 - 해당 set의 모든 요소들을 제거
 	 - clone()
 	 	 - return Type: Object
 	 	 - 해당 HashSet의 객체를 얕은 복사(shallow copy)하여 반환한다.
 	 - contains(Object o)
 	 	 - return Type: boolean
 	 - isEmpty()
 	 	 - return Type: boolean
 	 - iterator()
 	 	 - return Type: boolean
 	 - remove(Object o)
 	 	 - return Type: boolean
 	 - size()
 	 	 - return Type: boolean
 - inherited from java.util.AbstractSet
 	 - equals()
 	 - hashCode()
 	 - removeAll
 - inherited from java.util.AbstractCollection
 	 - addAll()
 	 - containAll()
 	 - retainAll()
 	 - toArray()
 	 - toString()
 - inherited from java.util.Object
 	 - finalize()
 	 - getClass()
 	 - notify()
 	 - notifyAll()
 	 - wait()
 - inherited from java.util.Set
 	 - addAll()
 	 - containsAll()
 	 - equals()
 	 - hashCode()
 	 - removeAll()
 	 - retainAll()
 	 - toArray()



## 참고
 - http://sysnet.pe.kr/221026178373
	 - 얕은 복사(shallow copy)
	 	 - 객체가 가진 멤버의 값들을 새로운 객체로 복사하는데 객체가 참조 타입의 멤버를 갖고 있으면 참조 값(Referece Value)만 복사
	 - 깊은 복사(deep copy)
	 	 - 해당 객체를 복사할 때, 필드 유형이 참조 타입의 멤버일지라도 별도의 메모리에 개별 인스턴스로 복사
