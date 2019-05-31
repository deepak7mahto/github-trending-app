package com.dpk.githubtrendingrepositories.model;

import com.google.gson.annotations.SerializedName;

public class Repo {

    @SerializedName("username")
    private final String username;

    @SerializedName("name")
    private final String name;

    @SerializedName("type")
    private final String type;

    @SerializedName("url")
    private final String url;

    @SerializedName("avatar")
    private final String avatar;

    @SerializedName("repo")
    private final RepoDetails repoDetails;

    public Repo(String username, String name, String type, String url, String avatar, RepoDetails repoDetails) {
        this.username = username;
        this.name = name;
        this.type = type;
        this.url = url;
        this.avatar = avatar;
        this.repoDetails = repoDetails;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public RepoDetails getRepoDetails() {
        return repoDetails;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getAvatar() {
        return avatar;
    }
}
