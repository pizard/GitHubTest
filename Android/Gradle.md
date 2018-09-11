# Gradle

## Android Lint
- 기능
    - 안드로이드 애플리케이션을 구성하는 코드를 정적 분석하는 도구
- 검사 항목
    - 사용하지 않는 리소스
    - 국제화 지원시 이상 여부
    - 성능상 문제가 될 수 있는 부분
    - minSdkLevel, targetSdkLevel, compileSdkLevel에 따라 오류가 발생할 수 있는 부분
- 검사 ID
    - CheckResult
        - 메서드의 결과값을 사용하지 않는 경우
    - MissingTranslation
        - 특정언어에 대한 번역 테스트 없음
    - NewApi
        - 구 버전 OS에서 새 버전에서 추가된 API
    - RelativeOverlap
        - RelativeLayout을 사용하는 경우, 언어에 따라 다른 구성요소의 영역을 침범할 가능성이 있음
    - UnusedResource
        - 사용하지 않는 리소스
- 검출단계
    - 정보(Information)
        -

- 옵션
    - abortOnError
        -
