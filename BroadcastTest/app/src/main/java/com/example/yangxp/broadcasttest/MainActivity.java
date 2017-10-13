package com.example.yangxp.broadcasttest;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yangxp.broadcasttest.db.MyDatabaseHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private NetWorkChangeReceiver netWorkChangeReceiver;

    private MyDatabaseHelper dbHelper;

    private Uri imageUri;

    private ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netWorkChangeReceiver = new NetWorkChangeReceiver();
        registerReceiver(netWorkChangeReceiver, intentFilter);
        Button button = (Button) findViewById(R.id.create_database);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        button.setOnClickListener(v -> {
            SQLiteDatabase writableDatabase = dbHelper.getWritableDatabase();
            Log.i(TAG, "onCreate: 获取写数据库");
            writableDatabase.close();
        });
        Button add = (Button) findViewById(R.id.add_data);
        add.setOnClickListener(v -> {
            SQLiteDatabase writableDatabase = dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", "The Da Vinci Code");
            contentValues.put("author", "Dan Brown");
            contentValues.put("pages", 454);
            contentValues.put("price", 16.96);
            writableDatabase.insert("Book", null, contentValues);
            writableDatabase.close();
        });
        Button query = (Button) findViewById(R.id.query_data);
        query.setOnClickListener(v -> {
            SQLiteDatabase readableDatabase = dbHelper.getReadableDatabase();
            Cursor book = readableDatabase.query("Book", null, null, null, null, null, null);
            if (book.moveToFirst()) {
                do {
                    String name = book.getString(book.getColumnIndex("name"));
                    String id = book.getString(book.getColumnIndex("id"));
                    Log.i(TAG, "onCreate: " + name);
                    Log.i(TAG, "onCreate: " + id);
                } while (book.moveToNext());
            }
            book.close();
        });
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(v -> {
            Intent intent = new Intent(this, NotificationActivity.class);
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 0);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Notification build = new NotificationCompat.Builder(this)
                    .setContentTitle("This is content title")
                    .setContentText("This is content text")
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentIntent(activity)//点击跳转
                    .setAutoCancel(true)//自动消失
                    .setVibrate(new long[]{0, 1000, 1000, 1000})//手机震动
                    .setLights(Color.GREEN, 1000, 1000)
                    .setDefaults(NotificationCompat.DEFAULT_ALL)
                    .build();
            notificationManager.notify(1, build);
        });

        imageView = (ImageView) findViewById(R.id.picture);

        Button takePhoto = (Button) findViewById(R.id.take_photo);
        takePhoto.setOnClickListener(v -> {
            File file = new File(getExternalCacheDir(), "output_image.jpg");
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
            } catch (IOException e) {
                Log.e(TAG, "onCreate: ", e);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                imageUri = FileProvider.getUriForFile(MainActivity.this, "com.example.yangxp.broadcasttest", file);
            } else {
                imageUri = Uri.fromFile(file);
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            startActivityForResult(intent, 1);
        });

        Button choose = (Button) findViewById(R.id.choose_from_album);
        choose.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                boolean s = ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
                Log.i(TAG, "onCreate: s"+s);
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            }else {
                openAlbum();
            }
        });



    }

    private void openAlbum(){
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,CHOOSE_PHOTO);
    }

    private final int CHOOSE_PHOTO = 2;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openAlbum();
                }else {
                    Toast.makeText(this,"You denied the permission",Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        imageView.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case CHOOSE_PHOTO:
                if (resultCode == RESULT_OK){
                    if (Build.VERSION.SDK_INT >= 19){
                        handleImageBeforeKitKat(data);
                    }else {
                        Log.i(TAG, "onActivityResult: 版本低");
                    }
                }
                break;
        }
    }

    private void handleImageBeforeKitKat(Intent data){
        Uri uri = data.getData();
        String imagePath = getImagePath(uri, null);
        displayImage(imagePath);
    }
    
    private void displayImage(String imagePath){
        if (imagePath != null){
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            imageView.setImageBitmap(bitmap);
        }else {
            Toast.makeText(this,"failed to get image",Toast.LENGTH_SHORT).show();
        }
    }
    
    private String getImagePath(Uri uri,String selection){
        String path = null;
        Cursor query = getContentResolver().query(uri, null, selection, null, null);
        if (query != null){
            if (query.moveToFirst()){
                path = query.getString(query.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            query.close();
        }
        return path;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netWorkChangeReceiver);
        if (dbHelper != null) {
            dbHelper.close();
        }
    }

    class NetWorkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(context.CONNECTIVITY_SERVICE);
            Log.i(TAG, "onReceive: " + connectivityManager.getActiveNetworkInfo());

            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (null != activeNetworkInfo) {
                String builder = activeNetworkInfo.getExtraInfo() + ";" +
                        activeNetworkInfo.getReason() + ";" +
                        activeNetworkInfo.getSubtypeName() + ";" +
                        activeNetworkInfo.getTypeName() + ";";

                Toast.makeText(context, builder, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
