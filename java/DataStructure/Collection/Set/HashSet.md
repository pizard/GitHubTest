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
 	 - `public boolean add(E e)`
 	 	 - 해당 set에 특정 element e가 없는경우 e를 추가
 	 	 - 해당 e를 추가한 경우 true 반환
 	 - `public void clear()`
 	 	 - 해당 set의 모든 요소들을 제거
 	 - `public Object clone()`
 	 	 - 해당 HashSet의 객체를 얕은 복사(shallow copy)하여 반환한다.
 	 - `public boolean contains(Object o)`
 	 	 - 해당 set이 특정 element을 포함한 경우 true 반환
 	 - `public boolean isEmpty()`
 	 	 - 해당 set의 element가 없는경우 true 반환
 	 - `public Iterator iterator()`
 	 	 - 해당 set의 모든 element를 iterator로 반환
 	 - `public boolean remove(Object o)`
 	 	 - 해당 set에서 특정 element이 존재하는 경우 삭제
 	 - `public int size()`
 	 	 - 해당 set의 element의 개수를 반환(cardinality)

 - inherited from java.util.AbstractSet
 	 - equals()
 	 - hashCode()
 	 - removeAll()
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
 - [oracle](https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html "Class HashSet<E>")
	 - 젠부!