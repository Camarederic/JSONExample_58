package com.example.jsonexample_58.Model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonexample_58.R
import kotlinx.android.synthetic.main.item_user_layout.view.*

class UserAdapter(val context: Context, private val items: ArrayList<UserModelClass>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = items[position]

        holder.textViewId.text = item.id.toString()
        holder.textViewUserName.text = item.name
        holder.textViewUserEmail.text = item.email
        holder.textViewUserGender.text = item.gender
        holder.textViewUserWeight.text = item.weight.toString()
        holder.textViewUserHeight.text = item.height.toString()
        holder.textViewUserMobileNumber.text = item.phone.mobile
        holder.textViewUserOfficeNumber.text = item.phone.office
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewId: TextView = view.textViewId
        val textViewUserName: TextView = view.textViewUserName
        val textViewUserEmail: TextView = view.textViewUserEmail
        val textViewUserGender: TextView = view.textViewUserGender
        val textViewUserWeight: TextView = view.textViewUserWeight
        val textViewUserHeight: TextView = view.textViewUserHeight
        val textViewUserMobileNumber: TextView = view.textViewUserMobileNumber
        val textViewUserOfficeNumber: TextView = view.textViewUserOfficeNumber
    }
}