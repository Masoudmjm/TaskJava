package com.masoudjafari.taskjava.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE id IN (:id)")
    List<User> loadById(String id);

    @Insert
    void insertData(List<User> users);

    @Delete
    void delete(User customer);

    @Query("DELETE FROM User")
    void nukeTable();

    @Query("UPDATE  User SET id =:id, name =:name")
    void update(String id, String name);

}
