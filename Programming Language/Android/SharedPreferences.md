# SharedPreferences
 - 해당 프로세스(어플리케이션)내에 File의 형태로 Data 저장
 	 - /data/---packagename---/shared_prefs/ 내에 xml형태로 저장
 - 해당 어플리케이션이 삭제되기 전까지 Data를 보관해 줌

## 생성자
 - `getPreferences(int mode)`
 	 - 하나의 액티비티에서만 사용하는 SharedPreferences를 생성
 	 - 해당 액티비티 이름으로 생성
 - `getSharedPreferences((String)Preferences_name, (int) MODE)`
 	 - 특정 일므을 가진 SharedPreferences를 생성
 	 - 애플리케이션 전체에서 사용 가능

 - Parameter
	 - mode: 설정 파일을 불러올때의 모드
	 	 - MODE_PRIVATE: 자기 APP내에서만 사용(Default, 0)
	 	 - MODE_WORLD_READABLE: 다른 APP에서 읽기 가능
	 	 - MODE_WORLD_WRITEABLE : 다른 APP에서 쓰기 가능
	 - Preferences_name: 설정 값들이 저장되는 파일의 이름

## SharedPreferences.Editor
 - 함수
 	 - `putString(String key, String value)`
 	 	 - 해당 key에 value값을 입력
 	 - `getString(String key, String default_value)`
 	 	 - 해당 key에 해당하는 값 출력, 없는 경우 default_value 입력
 	 	 - Boolean / Float / Int / Long / String 가능
 	 - `remove(String key)`
 	 	 - 특정 데이터 삭제
 	 - `clear()`
 	 	 - 모든 데이터 삭제
 	 	 - 기존 데이터의 형을 변경시키고 싶다면 클리어 한 후 적용해야 함
 	 - `commit()`
 	 	 - editor에 대한 수정사안 적용!

 - Parameter
	 - Key: 값의 변수명 역할을 수행하는 이름(String 형태)
	 - Default_value: Key에 해당하는 저자값이 없을때, 불러올 기본 값

## Example
 - 데이터 저장
 	```
 	SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
	SharedPreferences.Editor editor = pref.edit();
	editor.putString("Check_Parameter", "Installed");
	editor.commit();
	```
 - 데이터 불러오기
 	```
 	SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
	pref.getString("Check_Parameter", "");
 	```
 - 데이터 삭제
 	```
	SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
	SharedPreferences.Editor editor = pref.edit();
	editor.remove("Check_Parameter");
	editor.commit();
	```
 -  모든 데이터(ALL Data) 삭제
 	```
	SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
	SharedPreferences.Editor editor = pref.edit();
	editor.clear();
	editor.commit();
 	```


## 참고
 - [진규의 Playground](http://humble.tistory.com/9 "[안드로이드]SharedPreferences란?")
 	 - 생성자
 	 - SharedPreferences.Editor
 - [레필리아의 잡동사니](http://repilria.tistory.com/305 "[Android] SharedPreferences Class")
 	 - SharedPreferences.Editor
 	 - 톰캣 서버의 server.xml 확인



