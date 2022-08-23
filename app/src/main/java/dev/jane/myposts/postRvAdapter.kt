package dev.jane.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.jane.myposts.databinding.ActivityViewPostBinding
import dev.jane.myposts.databinding.ActivityMainBinding.inflate
import dev.jane.myposts.databinding.ActivityViewPostBinding.bind
import dev.jane.myposts.databinding.ActivityViewPostBinding.inflate


class PostRvAdapter(var context: Context, var postList: List<Post>): RecyclerView.Adapter<RetrofitViewHolder>() {


    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem = postList.get(position)
        with(holder.bindingView) {
            tvId.text = currentItem.id.toString()
            tvUserId.text = currentItem.userId.toString()
            tvTitle.text = currentItem.title
            tvBody.text = currentItem.body
            val context=holder.itemView.context
            holder.bindingView.cvCard.setOnClickListener {
                val intent = Intent(holder.itemView.context, commentActivity::class.java)
                intent.putExtra("POST_ID", currentItem.id)
                context.startActivity(intent)
            }
        }

        }
        override fun getItemCount(): Int {
            return postList.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
            var binding =
                ActivityViewPostBinding.inflate(LayoutInflater.from(context), parent, false)
            return RetrofitViewHolder(binding)
        }
    }


    class RetrofitViewHolder(var bindingView: ActivityViewPostBinding) :
        RecyclerView.ViewHolder(bindingView.root) {

    }

