package com.example.deliverytesttask.ui

import android.content.Context
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.deliverytesttask.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!isInternetAvailable()) {
            showNoInternetDialog()
        }

    }

    override fun onSupportNavigateUp() = findNavController(R.id.main_nav_fragment).navigateUp()


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
//        layoutManager.spanCount = resources.getInteger(R.integer.number_of_columns)
    }




    fun isInternetAvailable(): Boolean {
        val cm = (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }

    fun showNoInternetDialog() {
        AlertDialog.Builder(this)
            .setTitle("нет")
            .setMessage("интернет")
            .setPositiveButton(
                android.R.string.ok
            ) { _, _ -> }.show()
    }
}
