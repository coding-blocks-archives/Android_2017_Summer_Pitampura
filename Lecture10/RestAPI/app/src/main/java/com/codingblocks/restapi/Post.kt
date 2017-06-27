package com.codingblocks.restapi

/**
 * Created by championswimmer on 27/06/17.
 */

data class Post (
        val userId: kotlin.Int,
        val id: kotlin.Int,
        val title: String,
        val body: String
)