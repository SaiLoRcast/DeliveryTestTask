package com.example.deliverytesttask.ui.my_orders

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.ViewSkeletonScreen
import com.example.core.domain.Order
import com.example.core.domain.User
import com.example.core.domain.UsersData
import com.example.core.interactors.GetMyOrders
import com.example.core.interactors.GetUserInfo
import com.example.core.interactors.GetUserLocation
import com.example.deliverytesttask.R
import com.example.deliverytesttask.adapders.MyOrdersAdapter
import com.example.deliverytesttask.framework.ViewModelFactory
import com.example.deliverytesttask.adapders.PackageWeightsAdapter
import com.example.deliverytesttask.framework.datasource.db.Interactors
import com.example.deliverytesttask.ui.main_fragment.MainFragmentViewModel
import kotlinx.android.synthetic.main.fragment_confirm_order.*
import kotlinx.android.synthetic.main.fragment_create_order.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_my_orders.*

class MyOrdersFragment : Fragment() {

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: MyOrdersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_my_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back_to_main_view.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_myOrdersFragment_to_mainFragment)
        }

        initializeViews()

    }

    private fun initializeViews() {
        val model: MyOrdersFragmentViewModel =
            ViewModelProvider(this, ViewModelFactory).get(MyOrdersFragmentViewModel::class.java)

        model.loadMyOrders()

        model.ordersList.observe(viewLifecycleOwner,
            Observer<List<Order>> {

                if (it.isNotEmpty()) {
                    adapter = MyOrdersAdapter(
                        it
                    )

                    Log.d("OLOLO", it.size.toString())

                    layoutManager = LinearLayoutManager(context)
                    my_orders_list.layoutManager = layoutManager
                    my_orders_list.adapter = adapter

                } else {
                    test.text = "У Вас нет заказов"
                }

            })

    }

}