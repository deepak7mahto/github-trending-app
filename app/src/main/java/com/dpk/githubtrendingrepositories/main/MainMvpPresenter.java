package com.dpk.githubtrendingrepositories.main;

import com.dpk.githubtrendingrepositories.model.Repo;

interface MainMvpPresenter {
    void loadTrendingRepositories();

    void loadTestData(Repo[] repos);
}
