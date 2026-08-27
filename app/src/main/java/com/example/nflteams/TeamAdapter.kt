package com.example.nflteams

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
        val ivLogo: ImageView = itemView.findViewById(R.id.ivLogo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        val context = holder.itemView.context

        // Look up a real logo drawable by name, if this team has one set.
        val resId = team.logoRes?.let { name ->
            context.resources.getIdentifier(name, "drawable", context.packageName)
        } ?: 0

        if (resId != 0) {
            // Real logo image found — show it, hide the generated badge.
            holder.ivLogo.setImageResource(resId)
            holder.ivLogo.visibility = View.VISIBLE
            holder.logoBadge.visibility = View.GONE
            holder.tvAbbr.visibility = View.GONE
        } else {
            // No real logo — fall back to the generated colored badge.
            holder.ivLogo.visibility = View.GONE
            holder.logoBadge.visibility = View.VISIBLE
            holder.tvAbbr.visibility = View.VISIBLE
            holder.logoBadge.backgroundTintList = ColorStateList.valueOf(Color.parseColor(team.color))
            holder.tvAbbr.text = team.abbr
        }

        holder.tvName.text = team.name
        holder.itemView.setOnClickListener { onClick(team) }
    }

    override fun getItemCount(): Int = teams.size
}