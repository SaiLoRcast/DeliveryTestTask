package com.example.deliverytesttask.ui.confirm_order_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.ViewSkeletonScreen
import com.example.core.data.LocalDataSource
import com.example.core.domain.Order
import com.example.core.domain.UsersData
import com.example.deliverytesttask.R
import com.example.deliverytesttask.framework.ViewModelFactory
import com.example.deliverytesttask.adapders.PackageWeightsAdapter
import kotlinx.android.synthetic.main.fragment_confirm_order.*
import kotlinx.android.synthetic.main.fragment_create_order.*
import kotlinx.coroutines.launch

class ConfirmOrderFragment() : Fragment(), LocalDataSource {

    lateinit var confirmDeliveryFromDate: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_confirm_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        confirmDeliveryFromDate = requireArguments().getString("from_date")!!
//        confirm_delivery_from_address.text = requireArguments().getString("from_address")
//        confirm_delivery_to_date.text = requireArguments().getString("to_date")
//        confirm_delivery_to_address.text = requireArguments().getString("to_address")
//        delivery_final_cost.text = requireArguments().getString("delivery_cost")

        create_order.setOnClickListener {
            lifecycleScope.launch {
                var orderList: MutableList<Order> = mutableListOf()
                orderList.add(Order(12, "", "", "", "", "100тыщ"))
                saveMyOrder(orderList)
            }
        }

        initializeViews()

    }


    private fun initializeViews() {

        confirm_delivery_from_date.text = confirmDeliveryFromDate
        confirm_delivery_from_address.text = requireArguments().getString("from_address")
        confirm_delivery_to_date.text = requireArguments().getString("to_date")
        confirm_delivery_to_address.text = requireArguments().getString("to_address")
        delivery_final_cost.text = requireArguments().getString("delivery_cost")
    }

    override suspend fun getMyOrders(): List<Order> {
        TODO("Not yet implemented")
    }

    override suspend fun saveMyOrder(orders: List<Order>) {
        TODO("Not yet implemented")
    }

}