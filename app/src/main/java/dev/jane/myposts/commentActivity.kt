package dev.jane.myposts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.jane.myposts.databinding.ActivityCommentsBinding
import okhttp3.Response
import retrofit2.Call
import retrofit2.Callback

class commentActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentsBinding
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPost()





    }
    fun obtainPostId() {
        postId = intent.extras?.getInt("POST_ID") ?: 0
    }
    fun fetchPost() {
        var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = retrofit.getpostById(postId)

        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: retrofit2.Response<Post>) {
                var post = response.body()
                if (post != null) {
                    binding.tvPostTitle.text = post.title
                    binding.tvPostBody.text = post.body
                }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
            }
            fun obtainCommentId(){
                commentId=intent.extras?.getInt("COMMENT_ID")?:0
            }
            fun getComments(){
                val retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
                val requests=retrofit.getComments(commentId )
                request.enqueue(object : Callback <List<Comment>>{
                    override fun onResponse(call: Call<List<Comment>>, response: retrofit2.Response<List<Comment>>{
                        if (response.isSuccessful){
                            val comment=response.body()
                            if (comment!=null){
                                displayComments(comments)
                            }
                    }
                        override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                        Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
                    }
                })
            }
            fun displayComment(commentlist:List<Comment>){
                binding.rvComments.layoutManager=LinearLayoutManager(this)
                binding.rvComments.adapter=CommentRVAdapter(commentlist)
            }


                    ) {

                    }
                    }
                })
            }

        }) 
    }
}