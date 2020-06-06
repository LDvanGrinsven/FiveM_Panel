package com.example.FiveM_Panel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.FiveM_Panel.database.FiveM
import kotlinx.android.synthetic.main.content_add.view.*
import kotlinx.android.synthetic.main.game_item.view.*
import kotlinx.android.synthetic.main.game_item.view.tvDBName
import kotlinx.android.synthetic.main.game_item.view.tvIP
import kotlinx.android.synthetic.main.game_item.view.tvUsername
import kotlinx.android.synthetic.main.game_item.view.tvPassword
import java.text.SimpleDateFormat

class GameAdapter(private val games: List<FiveM>, private val onClick: (FiveM) -> Unit) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }


    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.game_item,
                parent,
                false
            )
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return games.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { onClick(games[adapterPosition]) }
        }

        fun bind(game: FiveM) {
            itemView.tvDBName.setText(game.DBname)
            itemView.tvIP.setText(game.ipaddress)
            itemView.tvUsername.setText(game.username)
            itemView.tvPassword.setText(game.password)
        }
    }
}