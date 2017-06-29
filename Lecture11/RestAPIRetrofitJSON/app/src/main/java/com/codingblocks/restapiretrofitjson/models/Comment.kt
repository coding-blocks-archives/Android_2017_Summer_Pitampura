package com.codingblocks.restapiretrofitjson.models

/**
 * Created by championswimmer on 29/06/17.
 */
data class Comment (
        val postId: Int,
        val id: Int,
        val name: String,
        val email: String,
        val body: String
)