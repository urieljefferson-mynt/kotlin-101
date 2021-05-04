package com.example.registrationAPIJeff

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.registrationAPIJeff.adapters.ShopItemsAdapter
import kotlinx.android.synthetic.main.list_items.*
import kotlinx.android.synthetic.main.list_items.view.*


class ListItems : Fragment(R.layout.list_items) {
    private lateinit var shopItemsAdapter: ShopItemsAdapter

    val userCart = UserCart()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.list_items, container, false)


        view.btn_user_cart.setOnClickListener{
            Log.d("btn_user_cart", "Go To Cart")
            var mFragmentTransaction: FragmentManager = parentFragmentManager
            mFragmentTransaction.beginTransaction().replace(R.id.fl_fragment,userCart).addToBackStack(null).commit()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shopItemsAdapter = ShopItemsAdapter(mutableListOf())
        rv_shop_item.adapter = shopItemsAdapter
        rv_shop_item.layoutManager = LinearLayoutManager(view.context)
    }
}