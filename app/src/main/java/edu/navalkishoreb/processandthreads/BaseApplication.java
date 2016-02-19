package edu.navalkishoreb.processandthreads;

import android.app.Application;
import android.util.Log;

/**
 * Created by NavalB on 10-01-2016.
 */
public class BaseApplication extends Application {
    private static final String LOG_TAG = BaseApplication.class.getSimpleName();

    //    private static final String LOG_TAG = LogConstants.Process;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, this.toString());
        Log.d(LOG_TAG, getApplicationContext().getApplicationInfo().processName);
        printProcess("onCreate");
    }

    private void printProcess(String name) {
        Log.d(LOG_TAG, "---------------------" + name + "-----------------------------");
        Log.d(LOG_TAG, "myPid " + android.os.Process.myPid());
        Log.d(LOG_TAG, "myTid " + android.os.Process.myTid());
        Log.d(LOG_TAG, "myUid " + android.os.Process.myUid());
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        printProcess("onTerminate");
    }
}
