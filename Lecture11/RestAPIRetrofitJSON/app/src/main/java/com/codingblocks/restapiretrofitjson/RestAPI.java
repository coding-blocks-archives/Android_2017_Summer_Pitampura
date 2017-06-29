package com.codingblocks.restapiretrofitjson;

import com.codingblocks.restapiretrofitjson.api.CommentsAPI;
import com.codingblocks.restapiretrofitjson.api.PostsAPI;
import com.codingblocks.restapiretrofitjson.api.UsersAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by championswimmer on 29/06/17.
 */

public class RestAPI {

    private static RestAPI apiInstance;

    private Retrofit retrofitInstance;
    private PostsAPI postsAPI;
    private UsersAPI usersAPI;
    private CommentsAPI commentsAPI;

    public PostsAPI getPostsAPI() {
        return postsAPI;
    }

    public UsersAPI getUsersAPI() {
        return usersAPI;
    }

    public CommentsAPI getCommentsAPI() {
        return commentsAPI;
    }

    private RestAPI() {
        retrofitInstance = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();


        postsAPI = retrofitInstance.create(PostsAPI.class);
        usersAPI = retrofitInstance.create(UsersAPI.class);
        commentsAPI = retrofitInstance.create(CommentsAPI.class);
    }

    public static RestAPI getInstance () {

        if (apiInstance == null) {
            apiInstance = new RestAPI();
        }

        return apiInstance;

    }
}
