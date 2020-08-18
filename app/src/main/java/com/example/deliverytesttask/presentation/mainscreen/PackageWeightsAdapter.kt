package com.example.deliverytesttask.presentation.mainscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deliverytesttask.R
import kotlinx.android.synthetic.main.card_package_weight.view.*


class PackageWeightsAdapter(var packageWeights: List<String>) : RecyclerView.Adapter<PackageWeightsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.card_package_weight, null))
    }

    override fun getItemCount() = packageWeights.size

    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int) {
        val packageWeights = packageWeights[id]
        viewHolder.view.package_weight.text = packageWeights
    }



    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)



}