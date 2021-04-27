package com.example.ecommercejeff

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommercejeff.Adapters.CartItemsAdapter
import kotlinx.android.synthetic.main.list_items.view.*
import kotlinx.android.synthetic.main.user_cart.*
import kotlinx.android.synthetic.main.user_cart.view.*

class UserCart : Fragment(R.layout.user_cart) {
    private lateinit var cartItemAdapter: CartItemsAdapter
    val confirmationPurchase = ConfirmPurchase()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.user_cart, container, false)

        view.btn_checkout.setOnClickListener{
            Log.d("btn_checkout", "Checkout")
            var mFragmentTransaction: FragmentManager = parentFragmentManager
            mFragmentTransaction.beginTransaction().replace(R.id.fl_fragment, confirmationPurchase).addToBackStack(null).commit()

        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartItemAdapter = CartItemsAdapter(mutableListOf())
        rv_cart_items?.adapter = cartItemAdapter
        rv_cart_items?.layoutManager = LinearLayoutManager(view.context)
    }
}