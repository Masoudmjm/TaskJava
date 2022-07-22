package com.masoudjafari.taskjava.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface UserDao {

    @Insert
    Completable insertData(List<User> users);

    @Delete
    Single<Integer> delete(User user);

    @Update
    Maybe<Integer> update(User user);

    @Query("SELECT * FROM User")
    Single<List<User>> getAll();

    @Query("SELECT * FROM User WHERE id IN (:id)")
    Single<List<User>> loadById(String id);

    @Query("DELETE FROM User")
    Completable nukeTable();

    @Query("UPDATE  User SET id =:id, name =:name")
    Completable update(String id, String name);

}
