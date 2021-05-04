package com.example.registrationAPIJeff.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.registrationAPIJeff.CartItem
import com.example.registrationAPIJeff.R
import kotlinx.android.synthetic.main.cart_item.view.*

class ConfirmPurchaseAdapter (
    private val confirmedItems: MutableList<CartItem>
) : RecyclerView.Adapter<ConfirmPurchaseAdapter.ConfirmItemViewHolder>() {
    class ConfirmItemViewHolder(cartView: View) : RecyclerView.ViewHolder(cartView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConfirmItemViewHolder {
        return ConfirmItemViewHolder(
            //to get a reference to an existing view
            LayoutInflater.from(parent.context).inflate(
                R.layout.cart_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ConfirmItemViewHolder, position: Int) {
        val currentCartItem = confirmedItems[position]
        holder.itemView.apply {
            tv_cart_item_name.text = currentCartItem.itemName
            tv_cart_item_price.text = currentCartItem.price.toString()
            cb_checkout.isChecked = currentCartItem.isChecked
            cb_checkout.setOnCheckedChangeListener { _, _ ->
                currentCartItem.isChecked = !currentCartItem.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return confirmedItems.size
    }

    fun addPurchaseItem(cartItem : CartItem){
        confirmedItems.add(cartItem)
        notifyItemInserted(confirmedItems.size - 1)
    }

    fun removedCheckedOutItems() {
        confirmedItems.removeAll { confirmedItem ->
            !confirmedItem.isChecked
        }
        notifyDataSetChanged()
    }

}