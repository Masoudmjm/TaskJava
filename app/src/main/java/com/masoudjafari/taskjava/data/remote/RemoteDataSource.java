package com.masoudjafari.taskjava.data.remote;

import com.masoudjafari.taskjava.data.DataSource;
import com.masoudjafari.taskjava.data.local.User;
import com.masoudjafari.taskjava.data.model.SearchResponse;

import java.util.List;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class RemoteDataSource implements DataSource {

    private final ApiService apiService = ApiProvider.apiProvider();

    @Override
    public Completable insertData(List<User> users) {
        return null;
    }

    @Override
    public Single<Integer> delete(User user) {
        return null;
    }

    @Override
    public Maybe<Integer> update(User user) {
        return null;
    }

    @Override
    public Single<List<User>> getAll() {
        return null;
    }

    @Override
    public Single<List<User>> loadById(String id) {
        return null;
    }

    @Override
    public Completable nukeTable() {
        return null;
    }

    @Override
    public Completable update(String id, String name) {
        return null;
    }

    @Override
    public Single<SearchResponse> getSearchResult(String query, int offset, int count) {
        return apiService.getSearchResult(query, offset, count);
    }
}
