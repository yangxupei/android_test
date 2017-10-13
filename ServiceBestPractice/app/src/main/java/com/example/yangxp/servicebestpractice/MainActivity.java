package com.example.yangxp.servicebestpractice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private DownloadService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downloadBinder = (DownloadService.DownloadBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = (Button) findViewById(R.id.start_download);
        Button pause = (Button) findViewById(R.id.pause_download);
        Button cancel = (Button) findViewById(R.id.cancel_download);
        String url = "https://download.jetbrains.8686c.com/idea/ideaIU-2017.2.5.exe";
        start.setOnClickListener(view -> downloadBinder.startDownload(url));
        pause.setOnClickListener(view -> downloadBinder.pauseDownload());
        cancel.setOnClickListener(view -> downloadBinder.cancelDownload());
        Intent intent = new Intent(this,DownloadService.class);
        startService(intent);
        bindService(intent,connection,BIND_AUTO_CREATE);
    }
}
