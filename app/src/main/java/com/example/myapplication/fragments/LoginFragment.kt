package com.example.myapplication.fragments

import Entities.User
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R
import androidx.navigation.findNavController
import com.example.myapplication.database.userDAO

import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*

import com.example.myapplication.database.appDatabase


class LoginFragment : Fragment() {

    lateinit var v: View
    lateinit var btAccess: Button

    private var db: appDatabase? = null
    private var userDao: userDAO? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_login, container, false)
        db = appDatabase.getAppDataBase(v.context)
        userDao = db?.userDao()
        btAccess = v.findViewById(R.id.btAccess)
        // Inflate the layout for this fragment
        return v
    }



    override fun onStart() {
        super.onStart()

       // val btAccess = findViewById(R.id.btAccess)

        var usuarios: MutableList<User>
        usuarios = userDao?.loadAllPersons() as MutableList<User>

        btAccess.setOnClickListener {
            val username: String = txtUsername.text.toString()
            val password: String = txtPassword.text.toString()
            var flagUserFound = false
            var flagPassOk = false

            lateinit var msjSnackb: String

            if (username == "" || password == "") {
                msjSnackb = "Complete all fields before continue"
            } else {


                    for (item: User in usuarios) {
                    if (username == item.username) {
                        flagUserFound = true
                        if (password == item.password) {
                            flagPassOk = true
                        }
                        break
                    }
                }
                if (flagUserFound) {
                    if (flagPassOk) {//todo ok
                        msjSnackb = "Login succesfull"
                        val action = LoginFragmentDirections.actionLoginFragmentToListFragment()
                        v.findNavController().navigate(action)
                    } else {
                        //wrong Pass
                        msjSnackb = "Wrong Password"
                    }
                } else {
                    //user not found
                    msjSnackb = "User not Found"
                }
            }



            val snackBar =Snackbar.make(it, msjSnackb, Snackbar.LENGTH_LONG).setAction("action", null)
            snackBar.setActionTextColor(Color.WHITE)
            val snackBarView = snackBar.view
            snackBarView.setBackgroundColor(Color.BLACK)
            val textView =
                snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
            textView.setTextColor(Color.BLUE)
            snackBar.show()

        }
    }




    /*
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }*/


}