package com.example.gamesstore

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class Cart : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    companion object {
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val nameId = intent?.extras?.getString("name").toString()
        val priceId = intent?.extras?.getString("price").toString()
        val imageId = intent?.extras?.getInt("image")

        var name:TextView = findViewById(R.id.tvName)
        name.text = nameId

        var image:ImageView = findViewById(R.id.itemImageView)
        var price:TextView = findViewById(R.id.tvPrice)
        price.text = priceId
        if (imageId != null) {
            image.setImageResource(imageId)
        }else{
            image.setImageResource(R.drawable.ic_launcher_background)
        }

        image.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${SEARCH_PREFIX}${nameId}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            startActivity(intent)
        }
        name.setOnClickListener {

            val intent =Intent(Intent.ACTION_SEND).apply {

                val queryUrl: Uri = Uri.parse("${SEARCH_PREFIX}${nameId}")
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TITLE, "$nameId")
                putExtra(Intent.EXTRA_TEXT, "$queryUrl")
                type = "text/*"
            }
            startActivity(intent)
        }



    }
}