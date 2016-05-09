package com.kejuntong.hahawestern.UtilClasses;

import android.app.Application;
import android.content.Context;

import com.firebase.client.Firebase;

/**
 * Created by kejuntong on 16-05-08.
 */
public class MyApp extends Application {

    static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        this.context = getApplicationContext();
        Firebase.setAndroidContext(this);

    }

    public static Context getContext(){
        return context;
    }
}
