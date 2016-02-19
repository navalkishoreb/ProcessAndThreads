package edu.navalkishoreb.processandthreads;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FirstService extends Service {
    private static final String LOG_TAG = FirstService.class.getSimpleName();
    public FirstService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, this.toString());
        Log.d(LOG_TAG,getApplicationContext().getApplicationInfo().processName);
        printProcess("onCreate");
    }

    private void printProcess(String name) {
        Log.d(LOG_TAG, "---------------------" + name + "-----------------------------");
        Log.d(LOG_TAG, "myPid " + android.os.Process.myPid());
        Log.d(LOG_TAG, "myTid " + android.os.Process.myTid());
        Log.d(LOG_TAG, "myUid " + android.os.Process.myUid());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        printProcess("onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
