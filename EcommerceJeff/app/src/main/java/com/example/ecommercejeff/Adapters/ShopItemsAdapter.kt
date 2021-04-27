package com.example.ecommercejeff.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercejeff.R
import com.example.ecommercejeff.ShopItem
import kotlinx.android.synthetic.main.shop_item.view.*

class ShopItemsAdapter (
    private val listItems: MutableList<ShopItem>

) : RecyclerView.Adapter<ShopItemsAdapter.ShopItemViewHolder>() {
    class ShopItemViewHolder(listView: View) : RecyclerView.ViewHolder(listView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        return ShopItemViewHolder(
            //to get a reference to an existing view
            LayoutInflater.from(parent.context).inflate(
                R.layout.shop_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val currentListItem = listItems[position]
        holder.itemView.apply {
            tv_item_name.text = currentListItem.itemName.toString()
            tv_item_price.text = currentListItem.price.toString()
            tv_item_stock.text = currentListItem.stockBalance.toString()
//                cb_checkout.setOnCheckedChangeListener { _, _ ->
//                    currentListItem.isChecked = !currentListItem.isChecked
//                }
        }
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    fun addListItem(listItem : ShopItem){
        listItems.add(listItem)
        notifyItemInserted(listItems.size - 1)
    }
}