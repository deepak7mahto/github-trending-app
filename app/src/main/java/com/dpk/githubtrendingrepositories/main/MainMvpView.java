package com.dpk.githubtrendingrepositories.main;

import com.dpk.githubtrendingrepositories.model.Repo;

interface MainMvpView {
    void showRepoList(Repo[] repos);
}
