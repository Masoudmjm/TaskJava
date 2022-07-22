package com.masoudjafari.taskjava.data.local;

import android.content.Context;

import com.masoudjafari.taskjava.data.DataSource;
import com.masoudjafari.taskjava.data.model.SearchResponse;

import java.util.List;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class LocalDataSource implements DataSource {

    private final UserDao userDao;

    public LocalDataSource(Context context) {
        this.userDao = AppDatabase.getInstance(context).userDao();
    }

    @Override
    public Completable insertData(List<User> users) {
        return userDao.insertData(users);
    }

    @Override
    public Single<Integer> delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public Maybe<Integer> update(User user) {
        return userDao.update(user);
    }

    @Override
    public Single<List<User>> getAll() {
        return userDao.getAll();
    }

    @Override
    public Single<List<User>> loadById(String id) {
        return userDao.loadById(id);
    }

    @Override
    public Completable nukeTable() {
        return userDao.nukeTable();
    }

    @Override
    public Completable update(String id, String name) {
        return userDao.update(id, name);
    }

    @Override
    public Single<SearchResponse> getSearchResult(String query, int offset, int count) {
        return null;
    }
}
