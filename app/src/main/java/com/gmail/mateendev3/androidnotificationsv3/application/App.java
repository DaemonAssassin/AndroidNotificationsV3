package com.gmail.mateendev3.androidnotificationsv3.application;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.core.app.NotificationManagerCompat;

public class App extends Application {

    //Declaring members
    public static final String CHANNEL_1_ID = "ID_1";
    public static final String CHANNEL_2_ID = "ID_2";
    NotificationManagerCompat mManager;

    @Override
    public void onCreate() {
        super.onCreate();

        //Instantiating members
        mManager = NotificationManagerCompat.from(this);

        //creating notification channels
        createNotificationChannels();
    }

    private void createNotificationChannels() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            //channel
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID, "Notification", NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This category is for simple notifications");
            channel1.setShowBadge(true);

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID, "Video", NotificationManager.IMPORTANCE_DEFAULT
            );
            channel2.setDescription("This category is for Video notifications");
            channel2.setShowBadge(true);

            mManager.createNotificationChannel(channel1);
            mManager.createNotificationChannel(channel2);

        }

    }
}
