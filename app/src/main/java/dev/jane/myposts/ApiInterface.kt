package dev.jane.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("/posts/{id}")
    fun getpostById(@Path("id") postId:Int):Call<Post>

    @GET("/comments")
    fun getComments():Call<List<Comment>>
    @GET("/posts/{id}/comments")
    fun getComments(@Path("id") commentId: Int):Call<List<Comment>>

    @GET("/comments/{id}")
    fun getcommentById(@Path("id")commentId:Int):Call<Comment>




}