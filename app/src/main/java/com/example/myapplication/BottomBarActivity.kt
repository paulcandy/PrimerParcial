package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.fragments.BBdescFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar


class BottomBarActivity : AppCompatActivity() {
    private lateinit var bottomNavView : BottomNavigationView
    private lateinit var navHostFragment : NavHostFragment

    var position : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_bar)

        val intent = intent
        number1 = intent.getIntExtra("position", -1)
        text1 = intent.getStringExtra("message").toString()
        Log.d( "Position frag", text1.toString())


        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment

        bottomNavView = findViewById(R.id.bottomNavigationView)

        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)
    }

    public var text1 :String = ""
    public var number1 :Int = 0

    override fun onStart() {
        super.onStart()


    }




}