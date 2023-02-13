package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moxy_retrofit.R
import com.example.moxy_retrofit.model.Repo
import kotlinx.android.synthetic.main.item_repository.view.*
import retrofit2.Response

class RepositoryAdapter(private val userRepository: List<Repo>) : RecyclerView.Adapter<RepositoryAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        val viewInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repository, parent, false)
        return DataViewHolder( viewInflater)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        val ItemsViewModel = userRepository[position]

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.name

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return userRepository.size
    }

    // Holds the views for adding it to image and text
    class DataViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
       val textView: TextView = itemView.findViewById(R.id.textViewUserName)
    }





/*    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: Repo) {
            itemView.apply {
                textViewUserName.text = user.name

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false))

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<Repo>) {
        this.users.apply {
            clear()
            addAll(users)
        }

    }*/
}