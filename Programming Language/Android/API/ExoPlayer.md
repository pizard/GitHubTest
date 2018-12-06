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
