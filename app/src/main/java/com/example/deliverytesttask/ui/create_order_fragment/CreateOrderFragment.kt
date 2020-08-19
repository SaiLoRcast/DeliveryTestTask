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
import com.example.core.domain.UsersData
import com.example.deliverytesttask.R
import com.example.deliverytesttask.framework.ViewModelFactory
import com.example.deliverytesttask.presentation.mainscreen.PackageWeightsAdapter
import kotlinx.android.synthetic.main.fragment_create_order.*

class CreateOrderFragment : Fragment() {
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: PackageWeightsAdapter
    lateinit var skeletonScreen: ViewSkeletonScreen

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        skeletonScreen = Skeleton.bind(container)
            .load(R.layout.fragment_create_order)
            .show()

        return inflater.inflate(R.layout.fragment_create_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        close.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_createOrder_to_mainFragment)
        }

        adapter = PackageWeightsAdapter(getWeightsList())
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
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

        skeletonScreen.hide()

        val model: CreateNewOrderFragmentViewModel =
            ViewModelProvider(this, ViewModelFactory).get(CreateNewOrderFragmentViewModel::class.java)

        model.loadUsersList()

        model.usersList.observe(viewLifecycleOwner,
            Observer<UsersData> {

            })

    }

}