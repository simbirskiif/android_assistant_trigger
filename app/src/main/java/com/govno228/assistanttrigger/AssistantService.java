package com.govno228.assistanttrigger;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class AssistantService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(() -> {
           try {
               SharedPreferences prefs = getSharedPreferences("Default", MODE_PRIVATE);
               int value = prefs.getInt("time", 0);
               Thread.sleep(value);
               Intent intent1 = new Intent(Intent.ACTION_VOICE_COMMAND);
               intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               startActivity(intent1);
           }catch (Exception e){
               e.printStackTrace();
           }
            stopSelf();
        }).start();
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
