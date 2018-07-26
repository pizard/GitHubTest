# ExoPlayer
- 개발사
    - Google
- 기능
    - 로컬 또는 인터넷을 통한 비디오 혹은 오디오를 재생하기 위한 안드로이드의 MediaPlayer API의 대안을 제공하는 안드로이드를 위한 앱단위 미디어 플레이어
- 소개
    - 비디오나 음악을 재생하는것은 안드로이드 기기에서 흔한 작업이다. 안드로이드 프레임워크는 `MediaPlayer`을 최소한의 코드로 미디어를 재생하기 위한 빠른 solution으로 제공한다. 뿐만아니라 custom media player solution을 만들기 위해 사용할 수 있는 `MediaCodec`, `AudioTrack` `MediaDrm`과 같은 low level 미디어 API 또한 제공한다.
    - ExoPlayer는 안들외드의 low level 미디어 API위에 구축된 앱단위의 미디어플레이어 오픈소스이다. 이 가이드는 ExoPlayer Library와 그것의 사용법을 묘사한다. 이것은 ExoPlayer의 main demo app의 코드들을 구체적인 예시를 제공하기 위해 언급한다. 가이드는 ExoPlayer을 사용하는데 장/단점을 다룬다. 이것은 ExoPlayer가 어떻게 수만은 포맷들 뿐만아니라 DASH, SmoothStreaming 그리고 HLS adaptive streams들을 사용할 수 있는지 보여준다. 이것은 또한 ExoPlayer 이벤트들과 메시지들 개인화 그리고 DRM 제공에 대해 언급한다.

## vs.MediaPlayer Pros and cons
    - 장점
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
    - 단점
        - 일부 device에서 오디오 재생에 한해 MediaPlayer에 비해 배터리 소모량이 많음

## Library overview
- Exoplayer Library의 핵심은 `ExoPlayer` 인터페이스이다.



https://google.github.io/ExoPlayer/guide.html



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

- 특징
    - 로컬 저장소 또는 HTTP통신을 통한 비디오 재생
    - 플레이리스트 지원
    - 외부 블루투스 헤드폰으로 해당 미디어를 제어하기 위한 MediaSession지원
    - 사용자가 다른것을 재생하거나 전화가 왔을때 재생을 멈추기 위한 오디오 포커스 지원
    - 다른 앱과 동시에 사용하는 팝업기능 지원(Picture in picture, PIP)
