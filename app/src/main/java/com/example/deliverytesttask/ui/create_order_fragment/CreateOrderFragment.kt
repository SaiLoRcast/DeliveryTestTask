package com.example.deliverytesttask.ui.create_order_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.ViewSkeletonScreen
import com.example.core.domain.User
import com.example.deliverytesttask.R
import com.example.deliverytesttask.adapders.PackageWeightsAdapter
import com.example.deliverytesttask.framework.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_confirm_order.*
import kotlinx.android.synthetic.main.fragment_create_order.*
import kotlinx.android.synthetic.main.fragment_create_order.next
import java.text.SimpleDateFormat
import java.util.*


class CreateOrderFragment : Fragment() {
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: PackageWeightsAdapter
    private var baseCost = 100

    var dateFormat: SimpleDateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    var timeFormat: SimpleDateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    var calendar: Calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_create_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        close.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_createOrder_to_mainFragment)
        }

        next.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("from_address", delivery_from_address.text.toString())
            bundle.putString("from_date", delivery_from_day.text.toString())
            bundle.putString("to_address", delivery_to_address.text.toString())
            bundle.putString("to_date", delivery_to_day.text.toString())
            bundle.putString("delivery_cost", delivery_cost.text.toString())

            Navigation.findNavController(view)
                .navigate(R.id.action_createOrder_to_confirmOrderFragment, bundle)
        }

        adapter = PackageWeightsAdapter(
            this,
            getWeightsList()
        )

        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        package_weights_list.layoutManager = layoutManager
        package_weights_list.adapter = adapter

        initializeViews()

    }

    private fun getWeightsList(): List<String> {
        val weights: MutableList<String> = mutableListOf()
        weights.add("До 1 кг")
        weights.add("До 5 кг")
        weights.add("До 10 кг")
        weights.add("До 15 кг")
        return weights
    }

    private fun initializeViews() {
        val locationFrom = requireArguments().getSerializable("location_from") as User?
        val locationTo = requireArguments().getSerializable("location_to") as User?

        initAddressFrom(
            locationFrom!!.location.country,
            locationFrom.location.state,
            locationFrom.location.city,
            locationFrom.location.street
        )

        initAddressTo(
            locationTo!!.location.country,
            locationTo.location.state,
            locationTo.location.city,
            locationTo.location.street
        )


        initDateFrom()

        initDateTo()
        updateCost()

        express_delivery_switch.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked) {
                updateCost()
            } else {
                updateCost()
            }
        }

    }

    private fun initAddressTo(country: String, state: String, city: String, street: String) {
        delivery_to_address.text = String.format(
            "%1s, %2s, %3s, %4s",
            country,
            state,
            city,
            street
        )
    }

    private fun initAddressFrom(
        country: String,
        state: String,
        city: String,
        street: String
    ) {
        delivery_from_address.text = String.format(
            "%1s, %2s, %3s, %4s",
            country,
            state,
            city,
            street
        )
    }

    private fun initDateFrom() {
        delivery_from_day.text = String.format(" %1s", dateFormat.format(calendar.time))
    }

    private fun initDateTo() {
        val calendarTo: Calendar = calendar
        calendarTo.add(Calendar.DAY_OF_YEAR, 1)
        delivery_to_day.text = String.format(" %1s", dateFormat.format(calendarTo.time))
    }

    fun setBaseCost(additionalCost: Int) {
        baseCost = additionalCost
    }

    fun updateCost() {
        var express = 0
        if (express_delivery_switch.isChecked) {
            express = 50
        }
        delivery_cost.text = String.format("%1s ₽", baseCost + express)

    }

}