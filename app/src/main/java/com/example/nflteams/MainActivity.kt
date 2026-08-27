package com.example.nflteams

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerTeams)
        recyclerView.layoutManager = GridLayoutManager(this, 4)
        recyclerView.adapter = TeamAdapter(TeamRepository.teams) { team ->
            openDepthChart(team.depthChartUrl)
        }
    }

    private fun openDepthChart(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "No browser app found to open the link", Toast.LENGTH_SHORT).show()
        }
    }
}