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
import com.example.ecommercejeff.Adapters.ConfirmPurchaseAdapter
import kotlinx.android.synthetic.main.confirmation_page.*
import kotlinx.android.synthetic.main.confirmation_page.view.*
import kotlinx.android.synthetic.main.user_cart.*
import kotlinx.android.synthetic.main.user_cart.view.*


class ConfirmPurchase : Fragment() {
    private lateinit var confirmPurchaseAdapter: ConfirmPurchaseAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.confirmation_page, container, false)

        view.btn_confirm.setOnClickListener{
            Log.d("btn_confirm", "Purchase Confirmed")


        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        confirmPurchaseAdapter = ConfirmPurchaseAdapter(mutableListOf())
        rv_confirmed_items?.adapter = confirmPurchaseAdapter
        rv_confirmed_items?.layoutManager = LinearLayoutManager(view.context)
    }

}