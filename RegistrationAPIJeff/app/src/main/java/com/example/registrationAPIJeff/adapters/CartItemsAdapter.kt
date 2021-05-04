package com.example.registrationAPIJeff.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.registrationAPIJeff.CartItem
import com.example.registrationAPIJeff.R
import kotlinx.android.synthetic.main.cart_item.view.*

class CartItemsAdapter(
    private val cartItems: MutableList<CartItem>
) : RecyclerView.Adapter<CartItemsAdapter.CartItemViewHolder>() {
    class CartItemViewHolder(cartView: View) : RecyclerView.ViewHolder(cartView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        return CartItemViewHolder(
            //to get a reference to an existing view
            LayoutInflater.from(parent.context).inflate(
                R.layout.cart_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val currentCartItem = cartItems[position]
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
        return cartItems.size
    }

    fun addCartItem(cartItem : CartItem){
        cartItems.add(cartItem)
        notifyItemInserted(cartItems.size - 1)
    }

    fun removedCheckedOutItems() {
        cartItems.removeAll { cartItem ->
            cartItem.isChecked
        }
        notifyDataSetChanged()
    }

}