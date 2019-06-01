package com.dpk.githubtrendingrepositories.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dpk.githubtrendingrepositories.R;
import com.dpk.githubtrendingrepositories.base.BaseActivity;
import com.dpk.githubtrendingrepositories.model.Repo;

public class MainActivity extends BaseActivity implements MainMvpView {

    private MainMvpPresenter mainMvpPresenter;
    private RecyclerView reposRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reposRecyclerView = findViewById(R.id.reposRecyclerView);
        reposRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainMvpPresenter = new MainPresenter(this, new MainInteractor());
        mainMvpPresenter.loadTrendingRepositories();

        //For espresso testing
//        Repo[] repos = new Repo[]{new Repo("testUsername", "testName", "testType", "testUrl", "https://google.com", new RepoDetails("testRepoName", "testDescription", "testUrl"))};
//        mainMvpPresenter.loadTestData(repos);
    }

    @Override
    public void showRepoList(Repo[] repos) {
        reposRecyclerView.setAdapter(new ReposAdapter(repos));
    }
}
