# Android Lint onPositionDisdontinuity
- 기능
    - 안드로이드 애플리케이션을 구성하는 코드를 분석
    - 코드내에서 발생할 수 있는 잠재적, 성능에 지장을 줄 수 있는 코드를 미리 검출하여 코드의 품질 향상
- 설정방법
    ```
    android {
        lintOptions {
            checkReleaseBuilds false
            abortOnError false
        }
    }
    ```
    - checkReleaseBuilds: Release 빌드시 Fatal 규칙에 저촉한다면 빌드 중단
    - abortOnError: 위험도가 Error 혹은 Fatal 규칙에 저촉한다면 빌드 중단
