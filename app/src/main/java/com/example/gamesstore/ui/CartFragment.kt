package com.example.gamesstore.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.gamesstore.MainActivity
import com.example.gamesstore.R
import com.example.gamesstore.databinding.FragmentCartBinding
import kotlin.properties.Delegates


class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private lateinit var nameId: String
    private lateinit var priceId: String
    private var imageId by Delegates.notNull<Int>()
    private lateinit var descriptionId: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
            nameId = it.getString("name").toString()
            priceId = it.getString("price").toString()
            imageId = it.getInt("image")
            descriptionId = it.getString("description").toString()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var name: TextView = binding.tvName
        name.text = nameId


        var price: TextView = binding.tvPrice
        price.text = priceId

        var description:TextView = binding.tvDescription
        description.text = descriptionId

        var image: ImageView = binding.itemImageView

        if (imageId != null) {
            image.setImageResource(imageId)
        }else{
            image.setImageResource(R.drawable.ic_launcher_background)
        }


        //search button
        var search = binding.searchImage
        var share = binding.shareImage

         search.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${MainActivity.SEARCH_PREFIX}${nameId}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            startActivity(intent)
        }
        share.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND).apply {

                val queryUrl: Uri = Uri.parse("${MainActivity.SEARCH_PREFIX}${nameId}")
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TITLE, "$nameId")
                putExtra(Intent.EXTRA_TEXT, "$queryUrl")
                type = "text/*"
            }
            startActivity(intent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}