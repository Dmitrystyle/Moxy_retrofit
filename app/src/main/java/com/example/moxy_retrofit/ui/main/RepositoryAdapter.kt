package com.example.moxy_retrofit.ui.main
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moxy_retrofit.R
import com.example.moxy_retrofit.data.model.Repo

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.DataViewHolder>() {
       private lateinit var mListener: onItemClickListener
       var repoList: List<Repo> = ArrayList()
          set(value) {
            field = value
            notifyDataSetChanged()
           }

    //______чтение нажатия клавиши_____
     interface onItemClickListener{fun onItemClick(position: Int, textRepo:String)
    }
    fun setOnItemCkickListener(listener: onItemClickListener){
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repository, parent, false)
        return DataViewHolder( viewInflater, mListener)
    }
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.textView.text = repoList[position].nameOfRepo
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

   inner class DataViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
       val textView: TextView = itemView.findViewById(R.id.textViewUserName)

    init {
        itemView.setOnClickListener { listener.onItemClick(adapterPosition, repoList[adapterPosition].nameOfRepo) }
    }

    }

}