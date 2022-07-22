package com.masoudjafari.taskjava.data;

import android.content.Context;

import com.masoudjafari.taskjava.data.local.LocalDataSource;
import com.masoudjafari.taskjava.data.local.User;
import com.masoudjafari.taskjava.data.model.SearchResponse;
import com.masoudjafari.taskjava.data.remote.RemoteDataSource;

import java.util.List;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class Repository implements DataSource{

    private final LocalDataSource localDataSource;
    private final RemoteDataSource remoteDataSource;
    
    public Repository(Context context) {
        this.localDataSource = new LocalDataSource(context);
        this.remoteDataSource = new RemoteDataSource();
    }
    
    @Override
    public Completable insertData(List<User> users) {
        return localDataSource.insertData(users);
    }

    @Override
    public Single<Integer> delete(User user) {
        return localDataSource.delete(user);
    }

    @Override
    public Maybe<Integer> update(User user) {
        return localDataSource.update(user);
    }

    @Override
    public Single<List<User>> getAll() {
        return localDataSource.getAll();
    }

    @Override
    public Single<List<User>> loadById(String id) {
        return localDataSource.loadById(id);
    }

    @Override
    public Completable nukeTable() {
        return localDataSource.nukeTable();
    }

    @Override
    public Completable update(String id, String name) {
        return localDataSource.update(id, name);
    }

    @Override
    public Single<SearchResponse> getSearchResult(String query, int offset, int count) {
        return remoteDataSource.getSearchResult(query, offset, count);
    }
}
