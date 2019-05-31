package com.dpk.githubtrendingrepositories.main;

import com.dpk.githubtrendingrepositories.model.Repo;

class MainPresenter implements MainMvpPresenter {
    private final MainMvpView mainMvpView;
    private final MainMvpInteractor mainMvpInteractor;

    MainPresenter(MainMvpView mainMvpView, MainMvpInteractor mainMvpInteractor) {
        super();
        this.mainMvpView = mainMvpView;
        this.mainMvpInteractor = mainMvpInteractor;
    }

    @Override
    public void loadTrendingRepositories() {
        mainMvpInteractor.fetchRepositoriesData(new OnDataLoad() {

            @Override
            public void success(Repo[] repos) {
                if (mainMvpView != null) {
                    mainMvpView.showRepoList(repos);
                }
            }

            @Override
            public void error() {

            }
        });
    }
}
