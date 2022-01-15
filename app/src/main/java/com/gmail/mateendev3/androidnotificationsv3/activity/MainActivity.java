package com.gmail.mateendev3.androidnotificationsv3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.gmail.mateendev3.androidnotificationsv3.R;
import com.gmail.mateendev3.androidnotificationsv3.application.App;
import com.gmail.mateendev3.androidnotificationsv3.broadcast.MyReceiver;
import com.gmail.mateendev3.androidnotificationsv3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Declaring members
    NotificationManagerCompat mManager;
    ActivityMainBinding mMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mMainBinding.getRoot());

        mManager = NotificationManagerCompat.from(this);

        //setting listener to button
        setNotificationOnButton();
    }

    private void setNotificationOnButton() {

        mMainBinding.btnSendNotification.setOnClickListener(v -> {
            String message = mMainBinding.etMessage.getText().toString();

            if (!message.isEmpty()) {

                //creating Intent and PendingIntent for notification as whole
                Intent intent1 = new Intent(this, SecondActivity.class);
                intent1.putExtra(App.CHANNEL_1_ID, message);
                PendingIntent pendingIntent = PendingIntent.getActivity(
                        this, 0, intent1, PendingIntent.FLAG_ONE_SHOT
                );

                //creating notification
                Notification notification = new NotificationCompat.Builder(
                        this, App.CHANNEL_1_ID
                )
                        .setSmallIcon(R.drawable.ic_android)
                        .setContentTitle("Message")
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setAutoCancel(true)
                        .addAction(R.drawable.ic_android, "Reply", pendingIntent)
                        .addAction(R.drawable.ic_android, "Order", pendingIntent)
                        .addAction(R.drawable.ic_android, "Cancel", null)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setColor(ContextCompat.getColor(this, R.color.black))
                        .setContentIntent(pendingIntent)
                        .setOnlyAlertOnce(true)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();

                mManager.notify(0, notification);

            } else
                Toast.makeText(this, "Please add message",
                        Toast.LENGTH_SHORT).show();
        });
        mMainBinding.btnSendNotification2.setOnClickListener(v -> {
            String message = mMainBinding.etMessage.getText().toString();

            if (!message.isEmpty()) {

                //creating Intent and PendingIntent for notification as whole
                Intent intent1 = new Intent(this, MyReceiver.class);
                intent1.putExtra(App.CHANNEL_2_ID, message);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT
                );

                //creating notification
                Notification notification = new NotificationCompat.Builder(
                        this, App.CHANNEL_2_ID
                )
                        .setSmallIcon(R.drawable.ic_android)
                        .setContentTitle("Geo")
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true)
                        .addAction(R.drawable.ic_android, "Reply", pendingIntent)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setOnlyAlertOnce(true)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();

                mManager.notify(0, notification);

            } else
                Toast.makeText(this, "Please add message",
                        Toast.LENGTH_SHORT).show();
        });
    }
}