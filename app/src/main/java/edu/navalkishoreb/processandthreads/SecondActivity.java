package edu.navalkishoreb.processandthreads;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = SecondActivity.class.getSimpleName();
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(LOG_TAG, this.toString());
        printProcess(TAG);

        findViewById(R.id.activity_second_click_me).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printProcess("onClick");
                Intent intent = new Intent(getApplicationContext(), FirstService.class);
                SecondActivity.this.startService(intent);

            }
        });

        findViewById(R.id.activity_second_stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printProcess("onClick");
                Intent intent = new Intent(getApplicationContext(), FirstService.class);
                SecondActivity.this.stopService(intent);

            }
        });

        Log.d(LOG_TAG,SecondActivity.this.getApplicationInfo().processName);
    }


    private void printProcess(String name) {
        Log.d(LOG_TAG, "---------------------" + name + "-----------------------------");
        Log.d(LOG_TAG, "myPid " + android.os.Process.myPid());
        Log.d(LOG_TAG, "myTid " + android.os.Process.myTid());
        Log.d(LOG_TAG, "myUid " + android.os.Process.myUid());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
