package com.masoudjafari.taskjava.data.remote;

import com.masoudjafari.taskjava.data.model.SearchResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("video-contents")
    Single<SearchResponse> getSearchResult(
            @Query("query")String query,
            @Query("offset")int offset,
            @Query("count")int count);
}
