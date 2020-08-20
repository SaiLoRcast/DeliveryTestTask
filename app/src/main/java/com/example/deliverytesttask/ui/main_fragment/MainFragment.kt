package com.example.deliverytesttask.ui.main_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.ViewSkeletonScreen
import com.example.core.domain.User
import com.example.deliverytesttask.R
import com.example.deliverytesttask.framework.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class MainFragment : Fragment() {

    lateinit var skeletonScreen: ViewSkeletonScreen
    lateinit var user: User
    lateinit var userDeliveryTo: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        skeletonScreen = Skeleton.bind(container)
            .load(R.layout.fragment_main)
            .show()

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val operation = async(Dispatchers.IO) {

                while (!isDataLoaded()) {

                }

            }
            operation.await()

            create_order_button.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable("location_from", user)
                bundle.putSerializable("location_to", userDeliveryTo)
                Navigation.findNavController(view)
                    .navigate(R.id.action_mainFragment_to_createOrderFragment,bundle)
            }
        }


        my_orders.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_mainFragment_to_myOrdesrFragment)
        }

        initializeViews()

    }

    private fun isDataLoaded(): Boolean {
        if (this::user.isInitialized && this::userDeliveryTo.isInitialized) {

            requireActivity().runOnUiThread {
                skeletonScreen.hide()

            }
            return true
        }
        return false
    }


    private fun initializeViews() {
        val model: MainFragmentViewModel =
            ViewModelProvider(this, ViewModelFactory).get(MainFragmentViewModel::class.java)

        model.loadUserInfo()
        model.loadUserDeliveryTo()

        model.userDeliveryTo.observe(viewLifecycleOwner, Observer<User>{
            userDeliveryTo = it
        })

        model.userInfo.observe(viewLifecycleOwner,
            Observer<User> {

                user = it
                Glide.with(this) //1
                    .load(it.picture)
                    .skipMemoryCache(true) //2
                    .diskCacheStrategy(DiskCacheStrategy.NONE) //3
                    .transform(CircleCrop()) //4
                    .into(user_photo)

                user_name.text = String.format("%1s. %2s %3s", it.title, it.firstName , it.lastName)
                user_phone.text = String.format("+%1s",it.phone)
                latest_delivery_address.text =  String.format("%1s, %2s, %3s, %4s,",it.location.country, it.location.state,it.location.city,it.location.street )

            })

    }

}