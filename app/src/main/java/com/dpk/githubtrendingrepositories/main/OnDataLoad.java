package com.dpk.githubtrendingrepositories.main;

import com.dpk.githubtrendingrepositories.model.Repo;

interface OnDataLoad {
    void success(Repo[] repos);

    void error();
}
