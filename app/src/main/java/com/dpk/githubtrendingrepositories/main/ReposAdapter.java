package com.dpk.githubtrendingrepositories.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dpk.githubtrendingrepositories.App;
import com.dpk.githubtrendingrepositories.R;
import com.dpk.githubtrendingrepositories.helpers.Constants;
import com.dpk.githubtrendingrepositories.model.Repo;
import com.dpk.githubtrendingrepositories.repo_details.RepoDetailsActivity;
import com.squareup.picasso.Picasso;

class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.RepoViewHolder> {
    private Repo[] repos;

    ReposAdapter(Repo[] repos) {
        this.repos = repos;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        return new RepoViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder viewHolder, int i) {
        final Repo repo = repos[i];
        viewHolder.repoTextView.setText(String.format("Repo Name : %s", repo.getRepoDetails().getName()));
        viewHolder.userTextView.setText(String.format("User Name : %s", repo.getUsername()));
        Picasso.get().load(repo.getAvatar()).into(viewHolder.avatarImageView);
        viewHolder.repoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.getContext(), RepoDetailsActivity.class);
                intent.putExtra(Constants.NAME, repo.getName());
                intent.putExtra(Constants.USER_NAME, repo.getUsername());
                intent.putExtra(Constants.AVATAR, repo.getAvatar());
                intent.putExtra(Constants.URL, repo.getUrl());
                intent.putExtra(Constants.TRENDING_REPO_NAME, repo.getRepoDetails().getName());
                intent.putExtra(Constants.TRENDING_REPO_DESCRIPTION, repo.getRepoDetails().getDescription());
                intent.putExtra(Constants.TRENDING_REPO_URL, repo.getRepoDetails().getUrl());
                App.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return repos.length;
    }

    class RepoViewHolder extends ViewHolder {
        CardView repoCardView;
        TextView userTextView;
        TextView repoTextView;
        ImageView avatarImageView;

        RepoViewHolder(View listItem) {
            super(listItem);
            repoCardView = listItem.findViewById(R.id.repoCardView);
            userTextView = listItem.findViewById(R.id.userNameTextView);
            repoTextView = listItem.findViewById(R.id.repoNameTextView);
            avatarImageView = listItem.findViewById(R.id.avatarImageView);
        }
    }
}
