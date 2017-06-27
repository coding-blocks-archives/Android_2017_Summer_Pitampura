package com.codingblocks.restapi

/**
 * Created by championswimmer on 27/06/17.
 */

data class PostComment (
        val postId: kotlin.Int,
        val id: kotlin.Int,
        val name: String,
        val email: String,
        val body: String
)