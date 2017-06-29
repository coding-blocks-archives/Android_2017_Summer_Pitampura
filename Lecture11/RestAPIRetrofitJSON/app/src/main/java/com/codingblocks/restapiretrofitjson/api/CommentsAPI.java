package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by championswimmer on 29/06/17.
 */

public interface CommentsAPI {

    @GET("/comments")
    Call<ArrayList<Comment>> getComments ();

    @GET("/comments")
    Call<ArrayList<Comment>> getCommentsByPostId (
            @Query("postId") int postId
    );

}
