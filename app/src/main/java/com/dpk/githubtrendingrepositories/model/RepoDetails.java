package com.dpk.githubtrendingrepositories.model;

import com.google.gson.annotations.SerializedName;

public class RepoDetails {

    @SerializedName("name")
    private final String name;

    @SerializedName("description")
    private final String description;

    @SerializedName("url")
    private final String url;

    public RepoDetails(String name, String description, String url) {

        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
