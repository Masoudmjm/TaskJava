package com.masoudjafari.taskjava.ui.dashboard;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.masoudjafari.taskjava.data.Repository;
import com.masoudjafari.taskjava.data.local.User;
import com.masoudjafari.taskjava.data.model.SearchResponse;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<SearchResponse> mSearchResponse;
    private final MutableLiveData<List<User>> mUsers;
    private final MutableLiveData<String> errorMessage;
    private final MutableLiveData<Boolean> loading;
    private final Repository repository;
    private final CompositeDisposable compositeDisposable;

    public DashboardViewModel(Context context) {
        repository = new Repository(context);
        mSearchResponse = new MutableLiveData<>();
        mUsers = new MutableLiveData<>();
        errorMessage = new MutableLiveData<>();
        loading = new MutableLiveData<>();
        compositeDisposable = new CompositeDisposable();

        getSearchResponse("f", 0, 10);
    }

    private void getSearchResponse(String query, int offset, int count) {
        loading.postValue(true);
        repository.getSearchResult(query, offset, count)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<SearchResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(SearchResponse searchResponse) {
                        loading.postValue(false);
                        mSearchResponse.postValue(searchResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loading.postValue(false);
                    }
                });
    }

    private void getUsers() {
        loading.postValue(true);
        repository.getAll()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<User> users) {
                        loading.postValue(false);
                        mUsers.postValue(users);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loading.postValue(false);
                        errorMessage.postValue(e.getMessage());
                    }
                });
    }

    public MutableLiveData<SearchResponse> getSearchResponse() {
        return mSearchResponse;
    }

    public MutableLiveData<List<User>> getUsersList() {
        return mUsers;
    }

    public void getUsersOnClick() {
        getUsers();
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

}