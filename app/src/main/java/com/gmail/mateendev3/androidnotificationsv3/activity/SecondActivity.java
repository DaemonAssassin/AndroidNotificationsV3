package com.gmail.mateendev3.androidnotificationsv3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.os.Bundle;

import com.gmail.mateendev3.androidnotificationsv3.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.cancel(0);
    }
}