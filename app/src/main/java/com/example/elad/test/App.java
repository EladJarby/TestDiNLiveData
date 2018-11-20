package com.example.elad.test;


import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.elad.test.data.local.AppDatabase;

public class App extends Application {
    private static Context context;
    private static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getMyContext(){
        return context;
    }
}
