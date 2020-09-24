package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.BottomBarActivityArgs
import com.example.myapplication.R
import com.google.android.material.snackbar.Snackbar


class BBdescFragment : Fragment() {


    lateinit var v: View
    lateinit var txtdescription: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_b_bdesc, container, false)


        //txtdescription = v.findViewById(R.id.txtDescription)
        // Inflate the layout for this fragment
        return v
    }

    override fun onStart(){
        super.onStart()

        // Specify the layout you are using.


        // Load and use views afterwards

       // val tv1 = findViewById(R.id.txtDescription)
      //  tv1.text = "Hello"

        var position  = BottomBarActivityArgs.fromBundle(requireArguments()).position
        // Snackbar.make(v,position.toString(), Snackbar.LENGTH_SHORT).show()


        //txtdescription.text = position.toString()


    }

}