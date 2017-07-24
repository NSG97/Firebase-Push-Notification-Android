package com.example.nishantgahlawat.pushnotification;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Nishant Gahlawat on 23-07-2017.
 */

public class PushNotificationIDService extends FirebaseInstanceIdService {

    private static final String TAG = "FirebaseTAG";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.i(TAG, "onTokenRefresh: "+refreshedToken);
    }
}
