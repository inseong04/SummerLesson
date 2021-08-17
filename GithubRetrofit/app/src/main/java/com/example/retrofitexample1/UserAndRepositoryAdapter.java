package com.example.retrofitexample1;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

// shift + F6
public class UserAndRepositoryAdapter extends ListAdapter<Object, RecyclerView.ViewHolder> {


    protected UserAndRepositoryAdapter() {
        super(new UserAndRepositoryDiffUtil());
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;

        switch (viewType) {
            case 1 : {
                view = inflater.inflate(R.layout.row_user, parent, false);
                return new UserViewHolder(view);
            }
            case 2 : {
                view = inflater.inflate(R.layout.row_repository, parent, false);
                return new RepositoryViewHolder(view);
            }
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UserViewHolder) {
            GithubUser user = (GithubUser) getCurrentList().get(position);
            ((UserViewHolder) holder).bind(user);
        }
        else if (holder instanceof RepositoryViewHolder) {
            GithubRepository user = (GithubRepository) getCurrentList().get(position);
            ((RepositoryViewHolder) holder).bind(user);
        }
    }


    @Override
    public int getItemViewType(int position) {
        Object item = getCurrentList().get(position);
        if (item instanceof GithubUser) {
            return 1;
        } else if (item instanceof GithubRepository) {
            return 2;
        }

        return -1;
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImageView;
        TextView nameTetView;
        TextView emailTetView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImageView = itemView.findViewById(R.id.profileImageView);
            nameTetView = itemView.findViewById(R.id.nameTextView);
            emailTetView = itemView.findViewById(R.id.emailTetView);
        }

        public void bind(GithubUser user) {
            nameTetView.setText(user.name);
            emailTetView.setText(user.login);
            profileImageView.setImageURI(Uri.parse(user.avatar_url));
            String imageUrl = user.avatar_url;
            Glide.with(itemView.getContext())
                    .load(imageUrl)
                    .into(profileImageView);
        }
    }

    class RepositoryViewHolder extends RecyclerView.ViewHolder {

        TextView repoNameText;
        TextView repoDescriptionText;

        public RepositoryViewHolder(@NonNull View itemView) {
            super(itemView);
            repoNameText = itemView.findViewById(R.id.repoNameText);
            repoDescriptionText = itemView.findViewById(R.id.repoDescriptionText);
        }

        public void bind(GithubRepository repository) {
            repoNameText.setText(repository.name);
            repoDescriptionText.setText(repository.description);
        }
    }


}
