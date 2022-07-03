package com.masoudjafari.taskjava;

import android.app.Application;
import androidx.room.Room;
import com.masoudjafari.taskjava.data.local.AppDatabase;

public class MyApp extends Application {

    public static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
//        database =  Room.databaseBuilder(this, AppDatabase.class, "MyDatabase").build();
        database =  AppDatabase.getInstance(this);
    }
}
