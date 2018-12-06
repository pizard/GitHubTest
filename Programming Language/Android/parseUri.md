## Uri 구조
- intent:#Intent;component=패키지명/.세부패키지명.클래스명;i.data=인트형데이터;end
- 데이터
    - action
        - 수행될 action(ACTION_vIEW, URI_INTENT_SCHEME, ACTION_MAIN...etc)
    - data
        - 가동하기 위한 데이터(db값... etc)
- examples of action/data
    - ACTION_VIEW content://contacts/people


- Method
    - `public static Intent parseUri(String uri, int flags)`
        - 기능
            - URI로부터 인텐트를 생성함
            - 이 URI는 action, category 그리고 만약 toUri(int)로 부터 반환됐다면 다른 intent field들을 encode하고 있음
            - 만약 Intent가 toUri()를 통해 생성된게 아니라면, 이 데이터들은 전체 URI일 것이고 ACTION_VIEW일 것임
        - parameter
            - uri: Intent로 바꿀 URI
            - flags: 추가적 진행 flags
                - 0, URI_ALLOW_UNSAFE, URI_ANDROID_APP_SCHEME, URI_INTENT_SCHEME
            - return(Type: Intent)
                - 새롭게 생성된 Intent
            - URISyntaxException
                - 기본 syntax가 잘못된 경우 또는 URI의 Intent 데이터가 잘못된 경우 에러 발생
    - `public String toUri(int flags)`
        - 기능
            - 반환값 URI는 적절하게 URI로 encode되어 있음
            -
    - URI_INTENT_SCHEME
        - toUri(int) or parseUri(String, int)와 함께 사용하기 위한 Flag
        - URI string은 항상 "intent:" scheme를 갖는다.
        -




intent://scan/#Intent;scheme=zxing;package=com.google.zxing.client.android;S.browser_fallback_url=http%3A%2F%2Fzxing.org;end



https://developer.android.com/reference/android/content/Intent

http://gwons.blogspot.com/2014/11/android.html

http://aggapple.tistory.com/17
