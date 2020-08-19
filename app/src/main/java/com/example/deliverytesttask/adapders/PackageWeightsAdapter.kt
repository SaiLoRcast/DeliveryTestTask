package com.example.deliverytesttask.adapders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deliverytesttask.R
import com.example.deliverytesttask.ui.create_order_fragment.CreateOrderFragment
import kotlinx.android.synthetic.main.card_package_weight.view.*


class PackageWeightsAdapter(
    var context: CreateOrderFragment,
    var packageWeights: List<String>) :
    RecyclerView.Adapter<PackageWeightsAdapter.ViewHolder>() {

    private var row_index = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_package_weight, null)
        )
    }

    override fun getItemCount() = packageWeights.size

    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int) {
        val packageWeights = packageWeights[id]
        viewHolder.view.package_weight.text = packageWeights
        viewHolder.view.setOnClickListener {
            row_index = id
            notifyDataSetChanged()
            when (id) {
                0 -> context.updateCost(0)
                1 -> context.updateCost(100)
                2 -> context.updateCost(200)
                3 -> context.updateCost(300)
            }

        }

        if (row_index == id) {
            viewHolder.itemView.setBackgroundResource(
                (R.drawable.weight_item_selected)
            )
            viewHolder.view.package_weight.setTextColor(
                viewHolder.itemView.context.resources.getColor(
                    R.color.white
                )
            )

        } else {
            viewHolder.itemView.setBackgroundResource(
                (R.drawable.weight_item)
            )
            viewHolder.view.package_weight.setTextColor(
                viewHolder.itemView.context.resources.getColor(
                    R.color.textColor
                )
            )
        }
    }


    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)


}