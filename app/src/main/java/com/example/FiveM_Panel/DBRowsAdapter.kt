package com.example.FiveM_Panel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.FiveM_Panel.database.DBRows
import kotlinx.android.synthetic.main.dbrows_item.view.tvfirstname
import kotlinx.android.synthetic.main.dbrows_item.view.tvlastname
import kotlinx.android.synthetic.main.dbrows_item.view.tvdateofbirth
import kotlinx.android.synthetic.main.dbrows_item.view.tvheight
import kotlinx.android.synthetic.main.dbrows_item.view.tvgroup

class DBRowsAdapter(private val DbList: List<DBRows>) :
    RecyclerView.Adapter<DBRowsAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(DbList[position])
    }

    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.dbrows_item,
                parent,
                false
            )
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return DbList.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(game: DBRows) {
            val fn = Glide.with(context).load(itemView.tvfirstname.setText(game.firstname))
            val ln = Glide.with(context).load(itemView.tvlastname.setText(game.lastname))
            val dob = Glide.with(context).load(itemView.tvdateofbirth.setText(game.dateofbirth))
            val h = Glide.with(context).load(itemView.tvheight.setText(game.height.toString()))
            val g = Glide.with(context).load(itemView.tvgroup.setText(game.group))
        }
    }
}