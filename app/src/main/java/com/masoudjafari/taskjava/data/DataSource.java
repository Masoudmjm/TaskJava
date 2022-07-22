package com.masoudjafari.taskjava.data;

import com.masoudjafari.taskjava.data.local.User;
import com.masoudjafari.taskjava.data.model.SearchResponse;

import java.util.List;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface DataSource {
    Completable insertData(List<User> users);

    Single<Integer> delete(User user);

    Maybe<Integer> update(User user);

    Single<List<User>> getAll();

    Single<List<User>> loadById(String id);

    Completable nukeTable();

    Completable update(String id, String name);

    Single<SearchResponse> getSearchResult(String query, int offset, int count);
}
