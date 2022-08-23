package dev.jane.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.jane.myposts.databinding.ActivityCommentsBinding
import dev.jane.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPosts()

    }
    fun getPosts() {
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(
                call: Call<List<Post>>, response:
                Response<List<Post>>
            ) {
                if (response.isSuccessful) {
                    val posts = response.body()
                if (posts != null) {
//                        displayPosts(posts)
//
//                    }
                }
                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

                }
            }

            fun displayPosts(postsList: List<Post>) {
               binding.cvPosts.layoutManager = LinearLayoutManager(this)
              val postsAdapter = PostRvAdapter(postsList)

               binding.cvPosts.rvAdapter = postsAdapter
           }

       })
   })
    }
}


