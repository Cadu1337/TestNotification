package com.example.carlosribeiro.testnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    Intent intent = new Intent();
                    PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                    Notification noti =  new Notification.Builder(MainActivity.this)
                            .setTicker("TickerTitle")
                            .setContentTitle("Organiza Enem")
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .addAction(R.mipmap.ic_launcher, "Está na hora de estudar", pIntent)
                            .setContentIntent(pIntent).getNotification();

                    noti.flags = Notification.FLAG_AUTO_CANCEL;
                    NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                    nm.notify(0,noti);
                }
            }
        );
    }
}

