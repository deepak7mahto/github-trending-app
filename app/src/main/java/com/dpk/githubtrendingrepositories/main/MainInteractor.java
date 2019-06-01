package com.dpk.githubtrendingrepositories.main;

import android.util.Log;

import com.dpk.githubtrendingrepositories.helpers.RetrofitInstance;
import com.dpk.githubtrendingrepositories.model.Repo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainInteractor implements MainMvpInteractor {

    private static final String TAG = "MainInteractor";

    @Override
    public void fetchRepositoriesData(final OnDataLoad onDataLoad) {

        RepositoriesService repositoriesService = RetrofitInstance.getRetrofitInstance().create(RepositoriesService.class);

        Call<Repo[]> repoListCall = repositoriesService.listRepos("java", "weekly");

        repoListCall.enqueue(new Callback<Repo[]>() {
            @Override
            public void onResponse(Call<Repo[]> call, Response<Repo[]> response) {
                onDataLoad.success(response.body());
            }

            @Override
            public void onFailure(Call<Repo[]> call, Throwable t) {
                Log.d(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");
                onDataLoad.error();
            }
        });

    }
}
