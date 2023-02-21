package com.example.moxy_retrofit.ui.main
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moxy_retrofit.R
import com.example.moxy_retrofit.data.model.Repo

class RepositoryAdapter(private val userRepository: List<Repo>) : RecyclerView.Adapter<RepositoryAdapter.DataViewHolder>() {

    //    private var userRepository: List<Repo>
    //    set(value) {
    //        field = value
    //        notifyDataSetChanged()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repository, parent, false)
        return DataViewHolder( viewInflater)
    }
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val ItemsViewModel = userRepository[position]
        holder.textView.text = ItemsViewModel.name
    }

    override fun getItemCount(): Int {
        return userRepository.size
    }

    class DataViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
       val textView: TextView = itemView.findViewById(R.id.textViewUserName)
    }

}