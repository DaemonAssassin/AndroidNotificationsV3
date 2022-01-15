package com.gmail.mateendev3.androidnotificationsv3.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.gmail.mateendev3.androidnotificationsv3.activity.MainActivity;
import com.gmail.mateendev3.androidnotificationsv3.application.App;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (intent.hasExtra(App.CHANNEL_2_ID)) {
                Toast.makeText(context, "value: " + intent.getStringExtra(App.CHANNEL_2_ID), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
