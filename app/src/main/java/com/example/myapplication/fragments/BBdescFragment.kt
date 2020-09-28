package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.BottomBarActivity
import com.example.myapplication.R
import com.google.android.material.snackbar.Snackbar


class BBdescFragment : Fragment() {


  //  lateinit var msjFromLogin : String


    lateinit var v: View
    lateinit var txtdescription: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   position1  = BottomBarActivityArgs.fromBundle(requireArguments()).position
     //   Snackbar.make(v,position1.toString(), Snackbar.LENGTH_SHORT).show()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_b_bdesc, container, false)
        return v
    }

    override fun onStart(){
        super.onStart()
        val texto = (activity as BottomBarActivity).text1
        val position : Int = (activity as BottomBarActivity).number1
        Log.d( "test", position.toString() +  " " + texto)
     //   Snackbar.make(v, position.toString() + " " + texto.toString() , Snackbar.LENGTH_SHORT).show()
    }



}