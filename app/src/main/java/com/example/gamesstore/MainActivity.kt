package com.example.gamesstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesstore.adapter.GamesStoreAdapter
import com.example.gamesstore.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataset = DataSource().loadGames()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = GamesStoreAdapter(this, dataset)

        recyclerView.adapter = adapter

        recyclerView.setHasFixedSize(true)
    }
}