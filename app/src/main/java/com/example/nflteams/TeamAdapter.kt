package com.example.nflteams

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TeamAdapter(
    private val teams: List<Team>,
    private val onClick: (Team) -> Unit
) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logoBadge: View = itemView.findViewById(R.id.logoBadge)
        val tvAbbr: TextView = itemView.findViewById(R.id.tvAbbr)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        val color = Color.parseColor(team.color)

        // Tint the circular badge with the team's primary color.
        holder.logoBadge.backgroundTintList = ColorStateList.valueOf(color)

        holder.tvAbbr.text = team.abbr
        holder.tvName.text = team.name

        holder.itemView.setOnClickListener { onClick(team) }
    }

    override fun getItemCount(): Int = teams.size
}
