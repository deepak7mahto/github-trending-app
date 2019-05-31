package com.dpk.githubtrendingrepositories.main;

import com.dpk.githubtrendingrepositories.model.Repo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepositoriesService {

//    ?language=java&since={since}

    @GET("developers")
    Call<Repo[]> listRepos(@Query("language") String langugae, @Query("since") String since);
}
