package com.example.gamesstore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesstore.R
import com.example.gamesstore.model.GamesStore
import com.example.gamesstore.ui.ItemListFragment
import com.example.gamesstore.ui.ItemListFragmentDirections

// TODO [1] Implement Adapter Class
class GamesStoreAdapter(private val context: Context,
                    private val dataset : List<GamesStore>)
    : RecyclerView.Adapter<GamesStoreAdapter.ViewHolder>() { // End of BookAdapter

    // TODO [3] Implement Adapter override methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return ViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        holder.itemName.text = context.resources.getString(item.name)
        holder.itemPrice.text = context.resources.getString(item.price)
        holder.itemImage.setImageResource(item.image)

        // Card view click listener
        holder.card.setOnClickListener{

            val action = ItemListFragmentDirections.actionItemListFragmentToCartFragment(name = holder.itemName.text.toString(), price = holder.itemPrice.text.toString(), image = item.image, description = context.resources.getString(item.description))
            holder.itemView.findNavController().navigate(action)


        }
    }

    override fun getItemCount() = dataset.size

    // TODO [2] Implement ViewHolder Class
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        // views in layout file
        val itemName : TextView = view.findViewById(R.id.tvName)
        val itemPrice : TextView = view.findViewById(R.id.tvPrice)
        val itemImage : ImageView = view.findViewById(R.id.itemImageView)
        //val itemDescription : TextView = view.findViewById(R.id.tvDescription)
        // card view in file
        val card : CardView =view.findViewById(R.id.cardView)

    } // End ViewHolder
} // End BookAdapter