package com.dpk.githubtrendingrepositories.main;

import com.dpk.githubtrendingrepositories.model.Repo;

public interface MainMvpView {
    void showRepoList(Repo[] repos);
}
