# Customizing ExoPlayer's UI components
- ExoPlayer V2는 몇가지 독창적인 UI 컴포넌트를 포함한다.
    1. PlayerbackControlView
        - ExoPlayer instance의 형태를 관리함
        - play/pause button과 같이 일반적인 재생 제어를 나타낸다.
    2. SimpleExoPlayerView
        - SimpleExoPlayer 미디어 재생을 위한 높은 수준의 형태
        - 재생되는동안 비디오 부제, 앨범아트 등을 보여주고 PlayBackControlView를 이용하여 재생제어기를 보여줌
- 이런 상자 밖의 view를 사용하는 것은 선택입니다.
- 만약 추가 작업의 비용을 지불하는 것보다 완전한 제어를 선호한다면 개발자들은 그들 자신의 UI를 사용하는 것으로부터 자유롭습니다.
- 이런 접근이 진보된 사용 케이스로 남는것이 필요한 반면에 V2.1.0부터 더이상 기본 customization이 필요 없게 되었습니다.
- 상자밖의 외관은 (가장 간단한 것부터 가장 복잡한것까지) 다음 3가지 방식으로 직접적으로 지원됩니다.
    1. view의 attribute 설정
    2. 전체적으로 view layout 파일을 overriding
    3. 특정 view에 대해 custom layout file로 교체
- 이런 3가지 접근의 Full Document는 다음 Javadoc에서 찾을 수 있습니다.
    1. [PlayerbackControlView](http://google.github.io/ExoPlayer/doc/reference/index.html?com/google/android/exoplayer2/ui/PlaybackControlView.html)
    2. [SimpleExoPlayerView](http://google.github.io/ExoPlayer/doc/reference/index.html?com/google/android/exoplayer2/ui/SimpleExoPlayerView.html)

## Attributes
-

### 사전
- out-of-box
