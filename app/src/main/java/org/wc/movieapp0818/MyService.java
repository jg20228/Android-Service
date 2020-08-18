package org.wc.movieapp0818;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";
    private MediaPlayer mp;
    
    public MyService() {
    }

    //startService() 실행
    //bindService() 실행
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: 호출됨");
    }

    //startService() 실행 - 액티비티가 종료되도 백그라운드로 돌고 있음.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: 호출됨");
        String musicNmae = intent.getStringExtra("musicName");
        if(musicNmae.equals("sample1")){
            //media를 create로 만드네
            mp = MediaPlayer.create(this,R.raw.sample1);
        }else{
            mp = MediaPlayer.create(this,R.raw.sample2);
        }
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }

    // bindService()실행 - 액티비티에 바인드됨. 액티비티와 생명주기를 같이 합니다.
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: 호출됨");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // stopService()
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: 호출됨");
        mp.stop();
    }
}
