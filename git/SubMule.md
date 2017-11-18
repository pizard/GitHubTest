# submodule 이해하기
 	정의
 	 - git Repository아래 다른 하위 git Repository를 관리하기 위한 도구
 - Function
 	 - `git submodule add <repository> [path]`
 	 - repository: 리파지터리 명
 	 - path: 생략가능, 생략 시 리파지터리 이름과 동일한 디렉터리 사용

# subtree 이해하기
 1. git은 merge명령어를 사용하여 2개의 브랜치를 합치는 기능을 제공하는데 이 때 2개의 브랜치의 root를 기준으로 하여 합친다.
 2. 

## Git Subtree VS Submodule
 - Submodule
 	 - CBD(Component-based Development)에 적합한 모델이며, 메인 프로젝트는 다른 컴포넌트들에 의존적이다.
 	 - Submodule은 링크이다.
 	 - 저장소를 여러개의 작은 저장소로 나눌 때 사용, 만약 서브 모듈에서 변경을 한다면 서브 모듈안에서 커밋/푸쉬를 한 후 메인 저장소에서 한번 더 커밋/푸쉬를 해야 함
 - Subtree
 	 - SBD(System-based Development)에 더욱 가까우며 모든 저장소는 모든것을 포함하고 있으며 각 부분을 수정 가능
 	 - subtree는 copy이다.(?) 뭐여..?
 	 - 다른 저장소를 하나의 저장소로 이력과 함께 통합할 수 있다. 통합을 하게 된다면 저장소의 크기는 커지지만 코드와 이력을 재사용하기 더욱 좋다.



### 참고
 - [SK플래닛 기술 블로그](http://readme.skplanet.com/?p=8542 "git subtree를 사용하여 재사용할 코드 독립 시키기")
	 - subtree 이해하기
 - [Jonathan's Blog.](https://select995.github.io/2017/08/22/subtree/ "g(Git) Subtree 사용법 정리.")
	 - Git Subtree VS Submodule