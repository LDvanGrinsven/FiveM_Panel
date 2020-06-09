package com.example.FiveM_Panel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.FiveM_Panel.database.DBRows
import com.example.FiveM_Panel.ui.DBRowsActivity
import kotlinx.android.synthetic.main.dbrows_item.view.*

val rec = DBRowsActivity()
class DBRowsAdapter(private val DbList: List<DBRows>) :
    RecyclerView.Adapter<DBRowsAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(DbList[position])
    }

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

    override fun getItemCount(): Int {
        return DbList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(game: DBRows) {
            val id = Glide.with(context).load(itemView.tvuseridentifier.setText(game.useridentifier))
            val fn = Glide.with(context).load(itemView.tvfirstname.setText(game.firstname))
            val ln = Glide.with(context).load(itemView.tvlastname.setText(game.lastname))
            val dob = Glide.with(context).load(itemView.tvdateofbirth.setText(game.dateofbirth))
            val h = Glide.with(context).load(itemView.tvheight.setText(game.height.toString()))
            val g = Glide.with(context).load(itemView.tvgroup.setText(game.group))
            val btn = Glide.with(context).load(itemView.tvUpdate.setOnClickListener{
                rec.onRowClick(game,
                    itemView.tvuseridentifier.getText().toString(),
                    itemView.tvfirstname.getText().toString(),
                    itemView.tvlastname.getText().toString(),
                    itemView.tvdateofbirth.getText().toString(),
                    itemView.tvheight.getText().toString().toInt(),
                    itemView.tvgroup.getText().toString())})
        }
    }
}