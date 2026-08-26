package com.example.nflteams

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
            Toast.makeText(this, "${team.name} (${team.conference})", Toast.LENGTH_SHORT).show()
        }
    }
}
