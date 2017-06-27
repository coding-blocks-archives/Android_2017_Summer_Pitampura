package com.codingblocks.restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostCommentActivity extends AppCompatActivity {
    public static final String TAG = "RETRO";
    TextView tvPostId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_comment);

        int postId = getIntent().getIntExtra("postId", 0);
        tvPostId = (TextView) findViewById(R.id.tvPostId);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostAPI postAPI = retrofit.create(PostAPI.class);

//        postAPI.getPost(postId).enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//                String postTitle = response.body().getTitle();
//                tvPostId.setText(postTitle);
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//
//            }
//        });

//        postAPI.getPostComments(postId).enqueue(new Callback<ArrayList<PostComment>>() {
//            @Override
//            public void onResponse(Call<ArrayList<PostComment>> call,
//                                   Response<ArrayList<PostComment>> response) {
//
//                Log.d(TAG, "onResponse: " + response.body().size());
//
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<PostComment>> call, Throwable t) {
//
//            }
//        });

        postAPI.getUser(1).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "onResponse: " + response.body().getName());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


    }












}
