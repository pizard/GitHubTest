# broadcastreceiver
## BroadCastReceiver 등록
 1. Manifests
```
<receiver
	android:name=".PackageReceiver"
	android:exported="true">
	<intent-filter>
		<action android:name="android.intent.action.ACTION_POWER_CONNECTED" />
		<action android:name="android.intent.action.ACTION_POWER_DISCONNECTED" />
		<action android:name="android.intent.action.PACKAGE_ADDED" />
		<action android:name="android.intent.action.PACKAGE_REMOVED" />
		<action android:name="android.intent.action.PACKAGE_REPLACED" />
		<data android:scheme="package" />
	</intent-filter>
</receiver>
```
 	 - application 내부 & activity 외부(아래) 위치
 	 - 해당 Intent의 정보를 가져옴

 2. PackageReceiver
```
 public class PackageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if(action.equals(Intent.ACTION_PACKAGE_ADDED))
        {
            if (intent.getDataString().contains(--- Package명 ---)){
                // do something when APP installed...
            }
        } else if(action.equals(Intent.ACTION_PACKAGE_REMOVED))
        {
            if (intent.getDataString().contains(--- Package명 ---)){
                // do something when APP Removed...
            }
        } else if(action.equals(ACTION_PACKAGE_REPLACED)){
            if (intent.getDataString().contains(--- Package명 ---)){
                // do something when APP Updated...
            }
        }
    }
}
```
	 - BroadcastReceiver의 경우 해당 핸드폰에서 발생하는 모든 앱에 대해 감시함
	 	 - 특정앱을 감시하기 위해서는 따로 if문을 통해 한번 더 걸러 줘야함
	 - ** `ACTION_PACKAGE_ADDED`와 `ACTION_PACKAGE_REMOVED`의 경우 스스로를 감시 불가능하데!!!!!! **
	 	 - REMOVED의 경우 구글에 데이터도 많고 딱 봐도 그럴 것 같은데 ADDED가 의외였다....ㅜㅜ(하루 버린건 안비밀ㅂㄷㅂㄷ)
	 	 - 이럴땐 SharedPreferences를 사용해서 ADDED와 유사한 기능을 만들면 됨!!!!(만든게 있지만 너무 조악해서 버린다...)