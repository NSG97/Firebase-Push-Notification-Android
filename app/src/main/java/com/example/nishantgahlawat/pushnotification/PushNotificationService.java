package com.example.nishantgahlawat.pushnotification;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Nishant Gahlawat on 23-07-2017.
 */

public class PushNotificationService extends FirebaseMessagingService {

    private static final String TAG = "FirebaseTAG";

    /*Main Activity to show a toast*/
    private static Activity activity;

    public static void setActivity(Activity activity) {
        PushNotificationService.activity = activity;
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        final String message = remoteMessage.getNotification().getBody();

        Log.i(TAG, "onMessageReceived: "+message);

        /*Run a toast on the UI Thread.*/
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity,message,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
