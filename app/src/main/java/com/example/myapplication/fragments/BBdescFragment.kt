package com.example.myapplication.fragments

import Entities.Product
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.BottomBarActivity
import com.example.myapplication.LoginActivity2
import com.example.myapplication.R
import com.example.myapplication.database.ProductDAO
import com.example.myapplication.database.appDatabase
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_b_bdesc.*


class BBdescFragment : Fragment() {


  //  lateinit var msjFromLogin : String


    lateinit var v: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_b_bdesc, container, false)
        setHasOptionsMenu(true)
        return v
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.getItem(0).setVisible(false)
        menu.getItem(3).setVisible(false)
    }
    private var db: appDatabase? = null
    private var productDAO: ProductDAO? = null

    override fun onStart(){
        super.onStart()
        val texto = (activity as BottomBarActivity).text1
        val position : Int = (activity as BottomBarActivity).number1
        Log.d( "test", position.toString() +  " " + texto)

        db = appDatabase.getAppDataBase(v.context)
        productDAO = db?.productDao()
        var product : Product
        product = productDAO?.loadProductById(position)!!
        txtDescription.text = product.description

        txtProducto.text = product.name
        txtPrice.text = "Precio: " + product.price


     //   Snackbar.make(v, position.toString() + " " + texto.toString() , Snackbar.LENGTH_SHORT).show()
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = when(item.itemId) {

            R.id.action_edit -> onEditToolbar()//Snackbar.make(v, "add", Snackbar.LENGTH_SHORT).show()

            //    R.id.action_edit ->Snackbar.make(v, "edit", Snackbar.LENGTH_SHORT).show()

            else -> ""
        }
        return super.onOptionsItemSelected(item)
    }

    fun onEditToolbar(){
        (activity as BottomBarActivity).flagEdit = true
        //tendria que levantar la posicion
        val action = BBdescFragmentDirections.actionBBdescFragmentToEditItemFragment2()//BBListFragmentDirections.actionListFragmentToEditItemFragment()
        v.findNavController().navigate(action)
    }

}