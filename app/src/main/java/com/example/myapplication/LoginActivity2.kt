package com.example.myapplication


import android.content.Intent
import Entities.User
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.adapters.ProductListAdapter
import kotlinx.android.synthetic.main.fragment_login.*

class LoginActivity2 : AppCompatActivity() {

    public var flagAdd : Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

      //  val toolbar = findViewById<Toolbar>(R.id.toolbar)
      //  setSupportActionBar(toolbar)

    }
}