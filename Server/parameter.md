# Parameter
 - array(배열, int[]/String[]...)
 	 - query에서 parameterType에는 Class의 완전한 경로가 들어가야함
 	 - 하지만 배열의 경우 Object가 아니기 때문에 parameterType에서 선언해 줄 수도 없고 array라는게 typeAlias가 된 상태가 아니라면 MyBatis는 어떤 개체인지 알지도 못함
 	 - 즉, 이상태로는 사용할 수 없음
 	 ➜ DTO를 만들어서 데이터를 넣거나 ArrayList에 넣거나 HashMap을 이용해서 보냄
	 - https://okky.kr/article/330602