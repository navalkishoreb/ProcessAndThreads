package edu.navalkishoreb.processandthreads;

import android.os.HandlerThread;
import android.util.Log;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by NavalB on 13-01-2016.
 */
public class TestThread1 extends HandlerThread {
    private static final String TAG = TestThread1.class.getSimpleName();

    private Lock lock = new ReentrantLock();

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"media recorder is recording");
        }
    };
    public TestThread1() {
        super(TAG);
        start();
    }
}
