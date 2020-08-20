package com.example.deliverytesttask.adapders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.domain.Order
import com.example.deliverytesttask.R
import com.example.deliverytesttask.ui.create_order_fragment.CreateOrderFragment
import kotlinx.android.synthetic.main.card_package_weight.view.*
import kotlinx.android.synthetic.main.item_my_order.view.*


class MyOrdersAdapter(
    var ordersList: List<Order>) :
    RecyclerView.Adapter<MyOrdersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_my_order, null)
        )
    }

    override fun getItemCount() = ordersList.size

    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int) {
        val myOrder = ordersList[id]
        viewHolder.view.my_delivery_from_address.text = myOrder.locationFrom
        viewHolder.view.my_delivery_from_date.text = myOrder.dateFrom
        viewHolder.view.my_delivery_to_address.text = myOrder.locationTo
        viewHolder.view.my_delivery_to_date.text = myOrder.dateTo
        viewHolder.view.my_delivery_cost.text = myOrder.cost

    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}