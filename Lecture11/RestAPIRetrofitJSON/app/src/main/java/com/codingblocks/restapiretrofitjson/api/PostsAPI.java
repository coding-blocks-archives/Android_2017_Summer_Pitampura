package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Comment;
import com.codingblocks.restapiretrofitjson.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by championswimmer on 29/06/17.
 */

public interface PostsAPI {

    @GET("/posts")
    Call<ArrayList<Post>> getPosts ();

    @GET("/posts/{id}")
    Call<Post> getPostById (
            @Path("id") int id
    );

    @GET("/posts")
    Call<ArrayList<Post>> getPostsByUserId (
            @Query("userId") int userId
    );

    interface CommentsAPI {

        @GET("/posts/{postId}/comments")
        Call<ArrayList<Comment>> getCommentsOfPostId (
                @Path("postId") int postId
        );

    }
}
