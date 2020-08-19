package com.example.deliverytesttask.ui.confirm_order_fragment

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
import com.example.deliverytesttask.adapders.PackageWeightsAdapter
import kotlinx.android.synthetic.main.fragment_confirm_order.*
import kotlinx.android.synthetic.main.fragment_create_order.*

class ConfirmOrderFragment : Fragment() {

    lateinit var skeletonScreen: ViewSkeletonScreen


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        skeletonScreen = Skeleton.bind(container)
            .load(R.layout.fragment_confirm_order)
            .show()

        return inflater.inflate(R.layout.fragment_confirm_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_confirmOrder_to_createOrderFragment)
        }

        initializeViews()

    }

    private fun initializeViews() {

        skeletonScreen.hide()

    }

}