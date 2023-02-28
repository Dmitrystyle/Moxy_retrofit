package com.example.moxy_retrofit.ui.main
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moxy_retrofit.R
import com.example.moxy_retrofit.data.model.Repo

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.DataViewHolder>() {

       var repoList: List<Repo> = ArrayList()
          set(value) {
            field = value
            notifyDataSetChanged()
           }

    //______чтение нажатия клавиши_____
    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
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
        val ItemsViewModel = repoList[position]
        holder.textView.text = ItemsViewModel.name

    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    class DataViewHolder(ItemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(ItemView) {
       val textView: TextView = itemView.findViewById(R.id.textViewUserName)

    init {
        ItemView.setOnClickListener { listener.onItemClick(adapterPosition) }
    }

    }

}