# ExoPlayer
- 개발사
    - Google
- 최소 사양
    - Android Studio 3.0↑
    - Android 4.1↑ (API level 16, Jelly Bean)
- 지원
    - [Supported formats](https://google.github.io/ExoPlayer/supported-formats.html)
    - [Supported devices](https://google.github.io/ExoPlayer/supported-devices.html)
- 기능
    - 로컬 또는 인터넷을 통한 비디오 혹은 오디오를 재생하기 위한 안드로이드의 MediaPlayer API의 대안을 제공하는 안드로이드를 위한 앱단위 미디어 플레이어
- 소개
    - 비디오나 음악을 재생하는것은 안드로이드 기기에서 흔한 작업이다. 안드로이드 프레임워크는 `MediaPlayer`을 최소한의 코드로 미디어를 재생하기 위한 빠른 solution으로 제공한다. 뿐만아니라 custom media player solution을 만들기 위해 사용할 수 있는 `MediaCodec`, `AudioTrack` `MediaDrm`과 같은 low level 미디어 API 또한 제공한다.
    - ExoPlayer는 안들외드의 low level 미디어 API위에 구축된 앱단위의 미디어플레이어 오픈소스이다. 이 가이드는 ExoPlayer Library와 그것의 사용법을 묘사한다. 이것은 ExoPlayer의 main demo app의 코드들을 구체적인 예시를 제공하기 위해 언급한다. 가이드는 ExoPlayer을 사용하는데 장/단점을 다룬다. 이것은 ExoPlayer가 어떻게 수만은 포맷들 뿐만아니라 DASH, SmoothStreaming 그리고 HLS adaptive streams들을 사용할 수 있는지 보여준다. 이것은 또한 ExoPlayer 이벤트들과 메시지들 개인화 그리고 DRM 제공에 대해 언급한다.

## vs.MediaPlayer Pros and cons
- Pros
    - Dynamic Adaptive Streaming over HTTP(DASH)와 SmoothStreaming지원
    - 많은 형태의 포맷 제공
    - `#EXT-X-DISCONTINUITY`태그를 교정하는 것과 같이 진보된 HLS 특징 지원
    - loop를 돌거나 연쇄하는 미디어에 대해 매끄러운 merge 능력
    - 너의 앱과 마찬가지로 성장중임
        - ExoPlayer는 너의 apk에 포함된 라이브러리임으로 너가 버전을 제어할 수 있으며 새로운 버전으로 쉽게 업데이트할 수 있다.
    - 안드로이드의 여러 device와 version에 대해 이슈가 거의 발생하지 않고 덜 변이적임
    - Android 4.4(API lvel 19)이상에 대해 공통된 암호화 Widevine DRM 제공
    - customize와 extend가 쉬움, ExoPlayer은 이것을 고려하며 만들어졌고 많은 Component가 커스텀으로 대체 가능
    - 공식 extenstion을 이용한 수많은 추가 라이브러리들과 빠르게 통합하는 능력
- Cons
    - 일부 device에서 오디오 재생에 한해 MediaPlayer에 비해 배터리 소모량이 많음

## Library overview
- Exoplayer Library의 핵심은 `ExoPlayer` 인터페이스이다.






## Customization
- Exoplayer는 수많은 인터페이스들과 추상화 클래스들을 정의하여 커스터마이징을 고려하며 디자인 된 라이브러리이다.
- custom Component
    - `Renderer`
        - 기본 라이브러리에의해 제공되지 않는 미디어 타입들을 커스텀
    - `TrackSelector`
        - 앱 개발자가 이용가능한 Renderer들에 의해 소비되는 선택된 미디어 소스들에 의한 트랙들의 노출 방식 조정
    - `LoadControl`
        - 앱 개발자가 사용자들의 버퍼링 정책 조정
    - `Extractor`
        - `ExtractorMediaSource`와 함께 사용하여 라이브러리가 지원하지 않는 컨테이너 형식 추가 지원
    -  `MediaSource`..?
        - custom `MediaSource`를 합치거나 렌더러에 피드할 샘플을 조정
    - `Datasource`
        - 개인 HTTP stack을 사용한 개인 프로토콜이나 개인 영구 캐쉬와 같은 너의 `Datasource`를 추가로 로드할 수 있음






# Demo application
- ExoPlayer의 메인 데모 앱은 두가지 주요한 목적을 갖고 있다.
    1. ExoPlayer의 사용법을 상대적으로 쉽게 제공하기 위함
    2. ExoPlayer을 쉽게 시도하게 하기 위함. 데모앱은 추가적인 당신의 콘텐츠들을 쉽게 재생할 수 있다.
- 이 페이지는 데모앱을 어떻게 얻고 컴파일할지 더해서 당신의 미디어를 플레이하는데 어떻게 사용해야할지를 적었다.

## Getting the code
- 메인 대모앱의 소스코드는 우리의 깃헙 프로젝트의 `demos/main` 폴더안에서 찾을 수 있다.
    - `git clone https://github.com/google/ExoPlayer.git`
- 이 프로젝트를 안드로이드 스튜디오에서 열고 다음과 같은 프로젝트 뷰를 볼 수 있다.(데모앱과 관련된 폴더들이 펼쳐져 있음)
    - 이미지이미지이미지이미지

## Compiling and running
- 데모앱을 컴파일하고 실행시키기 위해 안드로이드 스튜디오에서 `demo`의 환경설정을 실행시켜라. 데모앱은 다운되고 연결된 안드로이드 디바이스에서 실행될 것이다.
- 만약 가능하다면 실제 device에서 사용하기를 권장한다. 만약 에뮬레이터를 사용한다면 [FAQ - Does ExoPlayer support emulators?](https://google.github.io/ExoPlayer/faqs.html#does-exoplayer-support-emulators) 를 읽어보고 적어도 23이상의 API레벨을 가진 시스템 이미지를 사용해야 한다.
- 데모앱은 `SampleChooserActivity`에서 샘플들의 리스트를 나타내고 선택된 샘플들은 두번째 액티비티 `PlayerActivity`에서 재생된다.
- 데모앱의 특징은 재생 컨트롤과 기능적인 트랙 선택이다.
- `EventLogger`을 통해 시스템로그에서 유용한 디버그 정보들을 얻을 수 있다.
    - 이 로깅은 (다른 에러로그 태그들과 함께) `adb logcat EventLogger:V *:E` 명령어를 통해서 볼 수 있다.

### Including extension decoders
- ExoPlayer는 소프트웨어 디코더에서 사용할 수 있는 수 많은 확장자를 갖고 있다.
- 데모앱은 이런 확장자들을 아래와 같이 따라하면 만들 수 있다.
    1. 너가 원하는 확장자들을 각각을 Build해라. 이것은 manual 과정임을 명심하고 `README.md`에 언급해라.
    2. 안드로이드 스튜디오의 Build Variants에서 데모 모듈을 `withExtensionDebug` 혹은 `withExtensionsRelease`로 설정해라
    3. `demo` 환경설정을 컴파일하고 실행시켜라
- 기본적으로 확장 디코더는 적합한 플랫폼 디코더가 없는 경우에만 사용됩니다.
- 아래 섹션에서 설명하는 것 처럼 확장디코더가 선호될 수도 있습니다.

https://google.github.io/ExoPlayer/guide.html

## Playing you own content



##사전

- built on top of
- concrete
- along with
- seamlessly
- concatenate
- variation
- Widevine
- encryption
- implementation
- exposes


- implementation
- compositing
- persistent cache

- configuration
- By default

- 특징
    - 로컬 저장소 또는 HTTP통신을 통한 비디오 재생
    - 플레이리스트 지원
    - 외부 블루투스 헤드폰으로 해당 미디어를 제어하기 위한 MediaSession지원
    - 사용자가 다른것을 재생하거나 전화가 왔을때 재생을 멈추기 위한 오디오 포커스 지원
    - 다른 앱과 동시에 사용하는 팝업기능 지원(Picture in picture, PIP)
