package com.example.gamesstore.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesstore.Cart
import com.example.gamesstore.R
import com.example.gamesstore.model.GamesStore

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
            val context = holder.itemView.context
            val intent = Intent(context,Cart::class.java)
            intent.putExtra("name",holder.itemName.text.toString())
            intent.putExtra("price",holder.itemPrice.text.toString())
            intent.putExtra("image",item.image)
            context.startActivity(intent)

        }
    }

    override fun getItemCount() = dataset.size

    // TODO [2] Implement ViewHolder Class
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        // views in layout file
        val itemName : TextView = view.findViewById(R.id.tvName)
        val itemPrice : TextView = view.findViewById(R.id.tvPrice)
        val itemImage : ImageView = view.findViewById(R.id.itemImageView)
        // card view in file
        val card : CardView =view.findViewById(R.id.cardView)

    } // End ViewHolder

    //OnCard Click
    /*fun onCardClick(){
        val toast = Toast.makeText(context,"Added To Cart",Toast.LENGTH_SHORT)
        toast.show()
    }*/

} // End BookAdapter