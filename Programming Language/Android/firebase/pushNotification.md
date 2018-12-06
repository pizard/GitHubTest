# pushNotification
## 앱이 죽은 상태에서 push data 받기
- 메시지를 수신하기 위해서는 FirebaseMessageingService를 확장하는 서비스를 사용
    - onMessageReceived & onDeleteMessage 콜백을 재정의해야함
- onMessageReceived
    - 메시지 유형 제공이 안되는 경우
        - 앱이 백그라운드 상태일 경우
        - 알림과 데이터 페이로드가 둘 다 포함된 메시지
    - 해결방법
        - fcm api를 직접 호출해 주면 됨
