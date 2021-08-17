package com.example.retrofitexample1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ImageView profileImageView;
    TextView nameTetView;
    TextView emailTetView;
    RecyclerView recyclerView;

    GithubUser githubUser;
    List<GithubRepository> githubRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profileImageView=findViewById(R.id.profileImageView);
        nameTetView=findViewById(R.id.nameTextView);
        emailTetView=findViewById(R.id.emailTetView);
        recyclerView = findViewById(R.id.recyclerView);

        UserAndRepositoryAdapter adapter = new UserAndRepositoryAdapter();

        recyclerView.setAdapter(adapter);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        GitHubService service = retrofit.create(GitHubService.class);
        Call<GithubUser> userCall = service.getUser("inseong04");
        userCall.enqueue(new Callback<GithubUser>() {
            @Override
            public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
                GithubUser user = response.body();
                MainActivity.this.githubUser = user;

                if(MainActivity.this.githubRepository != null) {
                    List<Object> itemList = new ArrayList<>();
                    itemList.add(user);
                    itemList.addAll(githubRepository);

                    adapter.submitList(itemList);
                }

/*                nameTetView.setText(user.name);
                emailTetView.setText(user.login);
                profileImageView.setImageURI(Uri.parse(user.avatar_url));
                String imageUrl = user.avatar_url;
                Glide.with(MainActivity.this).load(imageUrl).into(profileImageView);*/
            }

            @Override
            public void onFailure(Call<GithubUser> call, Throwable t) {
                t.printStackTrace();
            }
        });

        Call<List<GithubRepository>> repoCall = service.getUserRepos("inseong04");

        repoCall.enqueue(new Callback<List<GithubRepository>>() {
            @Override
            public void onResponse(Call<List<GithubRepository>> call, Response<List<GithubRepository>> response) {
                if (response.isSuccessful()) {
                    List<GithubRepository> reposList = response.body();
                    MainActivity.this.githubRepository = reposList;

                    if(MainActivity.this.githubUser != null) {
                        List<Object> itemList = new ArrayList<>();
                        itemList.add(githubUser);
                        itemList.addAll(githubRepository);

                        adapter.submitList(itemList);
                    }

/*                    adapter.submitList(reposList);*/
                }
            }

            @Override
            public void onFailure(Call<List<GithubRepository>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}