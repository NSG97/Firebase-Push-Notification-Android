package com.example.nishantgahlawat.pushnotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "FirebaseTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Set Activity in PushNotificationService - Required to show toast on UI Thread.*/
        PushNotificationService.setActivity(this);

        /*Get Token for firebase messaging.*/
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.i(TAG, "Token: "+refreshedToken);

        Button sButton = (Button) findViewById(R.id.subscribeButton);

        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Subscribe to 'ALL' Notifications*/
                FirebaseMessaging.getInstance().subscribeToTopic("ALL");
                Toast.makeText(getBaseContext(),"Subscribed to Notifications.",Toast.LENGTH_SHORT).show();
            }
        });

        Button usButton = (Button) findViewById(R.id.unsubscribeButton);

        usButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Unsubscribe to 'ALL' Notifications*/
                FirebaseMessaging.getInstance().unsubscribeFromTopic("ALL");
                Toast.makeText(getBaseContext(),"Unsubscribed to Notifications.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
