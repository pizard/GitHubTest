# Class HashMap<K,V>
 - K(Key)
 	 - 이 map에 의해 유지되는 키들의 유형
 - V(Value)
 	 - map된 값들의 유형
 - Object.hashCode()를 이용하는 java.util.Map 인터페이스의 구현체
 - Key-Value를 묶어 하나의 entry로 저장함
 - 순서를 보장하지 않음
 - key값은 중복이 되지 않고, value는 중복이 허용됨
 - hashCode()와 equals()
 - hashing을 사용하기 때문에 많은 양의 데이터를 검색하는데 뛰어남
 - 멀티쓰레드에서 동시에 HashMap을 건들면 문제가 생기기에 멀티 쓰레드의 경우 HashTable을 사용

## 생성자/메서드
 - HashMap()
 	 - HashMap 객체를 생성
 	 - ex. `HashMap<String, Integer> map = new HashMap<String, Integer>();`
 - HashMap(int initialCapacity)
 	 - 지정된 값을 초기 용량으로 하는 HashMap 객체를 생성한다.
 - HashMap(int initialCapctity, float loadFactory)
 	 - 지정된 값을 초기 용량과 load factory의 HashMap 객체를 생성한다.
 - HashMap(Map m)
 	 - 주어진 Map에 저장된 모든 요소를 포함하는 HashMap을 생성한다.
 - void clear()
 	 - HashMap에 저장된 모든 객체를 제거한다.
 - Object clone()
 	 - 현재 HashMap을 복제하여 변환한다.
 - boolean contatinsKey(Object Key)
 	 - HashMap에 지정된 키(Key)가 포함되어 있는지 알려준다.
 - boolean containsValue(Object Value)
 	 - HashMap에 지정된 값(Value)가 포함되어 있는지 알려준다.
 - Set entrySet()
 	 - HashMap에 저장된 Key - Value값을 엔트리의 형태로 Set에 저장하여 반환
 - Object get(Object Key)
 	 - 지정된 Key의 값을 반환한다.
 - boolean isEmpty()
 	 - HashMap이 비어있는지 확인한다.
 - Set keySet()
 	 - HashMap에 저장된 모든 키가 저장된 Set을 반환한다.
 - Object put(Object Key, Object Value)
 	 - HashMap에 키와 값을 저장
 - void putAll(Map m)
 	 - Map에 해당하는 모든 요소를 HashMap에 저장한다.
 - Object remove(Object key)
 	 - HashMap에서 지정된 키로 지정된 값을 제거한다.
 - int size()
 	 - HashMap에 저장된 요소의 개수를 반환한다.
 - Collection values()
 	 - HashMap에 저장된 모든 값을 컬렉션 형태로 반환한다.

## Java HashMap은 어떻게 동작하는가?
 - Java 7, Java 8 을 기준으로 HashMap이 어떻게 구현되어 있는지
 - Java Collections Framework에 속한 구현체 클래스

### HashMap과 HashTable
 - HashTable
 	 - JDK 1.0부터 있던 Java의 API
 - HashMap
 	 - Java 2에서 처음 선보인 Java Collections Framework에 속한 API
 	 


Oracle Help Center https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html

http://d2.naver.com/helloworld/831311
