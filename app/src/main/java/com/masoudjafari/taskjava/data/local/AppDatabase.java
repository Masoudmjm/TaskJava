package com.masoudjafari.taskjava.data.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context){
        if (instance == null)
            instance = Room.databaseBuilder(context, AppDatabase.class, "Users")
                    .fallbackToDestructiveMigration()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Executors.newSingleThreadScheduledExecutor().execute(() ->
                                    instance.userDao().insertData(getDefaultUsers()));
                        }
                    })
                    .build();
        return instance;
    }

    public static List<User> getDefaultUsers() {
        List<User> myList = new ArrayList<>();
        User user1 = new User();
        user1.name = "ali";
        user1.position = "manager";

        User user2 = new User();
        user2.name = "reza";
        user2.position = "manager";

        User user3 = new User();
        user3.name = "hasan";
        user3.position = "manager";

        myList.add(user1);
        myList.add(user2);
        myList.add(user3);

        return myList;
    }
}
