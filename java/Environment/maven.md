# Maven이란?
- 기능
    - 라이브러리 관리 기능
    -
- attribute
    - groupId
        - 프로젝트에 속하는 그룹 식별 값(ex. 회사, 단체)
        - 패키지 형식으로 계층을 표현
    - artifactId
        - 프로젝트 결과물의 식별 값 프로젝트나 모듈을 의미하는 값
    - version
        - 결과물의 버전
    - package
        - 기본적으로 생성할 패키지
        - default: groupId의 구조로 생성

## Maven LifeCycle
- 순서
    - compile > test > package
        - compile
            - src/main/java 디렉토리 아래의 모든 소스 코드를 컴파일
        - test
            - src/test/java, src/test/resources 테스트 자원 복사 및 테스트 소스 코드 컴파일
        - packaging
            - 컴파일과 테스트가 완료된 후 jar, war와 같은 형태로 압축
## Transitive Dependency
-

## maven scope
- 종류
    - compile(default)
        - 프로젝트의 모든 classpath에 추가
    - provided
        - 실행시 의존관계를 제공하는 JDK나 Web Container에 대해서 적용
        - 컴파일/테스트에는 필요하지만 실행때는 필요없는 것을 제공
    - runtime
        - 컴파일 시에는 필요하지 않지만 실행시에는 필요할 경우
    - test
        - 테스트시에만 필요한 경우
    - system
        - provided와 유사하지만 해당 jar를 포함해야 한다고 명시적으로 입력하는 것
    - import
        - <dependencyManagement> 섹션에서 pom 의존관계에 대해 사용
