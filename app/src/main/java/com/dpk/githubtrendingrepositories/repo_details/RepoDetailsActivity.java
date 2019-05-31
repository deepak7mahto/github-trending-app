package com.dpk.githubtrendingrepositories.repo_details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.dpk.githubtrendingrepositories.R;
import com.dpk.githubtrendingrepositories.helpers.Constants;
import com.squareup.picasso.Picasso;

public class RepoDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView userNameTextView = findViewById(R.id.userNameTextView);
        TextView urlTextView = findViewById(R.id.urlTextView);
        TextView repoNameTextView = findViewById(R.id.repoNameTextView);
        TextView repoDescriptionTextView = findViewById(R.id.repoDescriptionTextView);
        TextView repoUrlTextView = findViewById(R.id.repoURLTextView);
        ImageView avatarImageView = findViewById(R.id.avatarImageView);

        nameTextView.setText(getIntent().getStringExtra(Constants.NAME));
        userNameTextView.setText(getIntent().getStringExtra(Constants.USER_NAME));
        urlTextView.setText(getIntent().getStringExtra(Constants.URL));
        repoNameTextView.setText(getIntent().getStringExtra(Constants.TRENDING_REPO_NAME));
        repoDescriptionTextView.setText(getIntent().getStringExtra(Constants.TRENDING_REPO_DESCRIPTION));
        repoUrlTextView.setText(getIntent().getStringExtra(Constants.TRENDING_REPO_URL));

        Picasso.get().load(getIntent().getStringExtra(Constants.AVATAR)).into(avatarImageView);
    }
}
