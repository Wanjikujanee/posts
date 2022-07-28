package dev.jane.myposts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//class postRvAdapter {
//}


class postRvAdapter(var post:List<Post>):
    RecyclerView.Adapter<postViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {
        var itemView= LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_view_post,parent,false)
        return postViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {
        var currentPost=post.get(position)
        holder.tvUserId.Int=currentPost.userId
        holder.tvId.Int=currentPost.id
        holder.tvTitle.text=currentPost.title
        holder.tvBody.text=currentPost.body



    }

    override fun getItemCount(): Int {
        return post.size
    }
}
class postViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var tvUserId=itemView.findViewById<TextView>(R.id.tvUserId)
    var tvId=itemView.findViewById<TextView>(R.id.tvId)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBody)
    var tvTitle=itemView.findViewById<TextView>(R.id.tvTitle)


}

