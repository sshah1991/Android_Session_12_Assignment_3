package com.example.sumeet.expandblenotification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private final int ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Notification.Builder builder = new Notification.Builder(getApplicationContext());
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("Message");
                builder.setContentText("Body");
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                builder.setLargeIcon(icon);

                Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
                String[] events = new String[]{"Line 1", "Line 2", "Line 3", "Line 4"};
                inboxStyle.setBigContentTitle("Details :");
                for (int i = 0; i < 4; i++) {
                    inboxStyle.addLine(events[i]);
                }

                builder.setStyle(inboxStyle);
                Notification notification = builder.build();

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(ID, notification);
            }
        });
    }
}
