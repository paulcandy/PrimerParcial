package com.example.myapplication.fragments

import Entities.Product
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.BottomBarActivity
import com.example.myapplication.LoginActivity2
import com.example.myapplication.R
import com.example.myapplication.adapters.ProductListAdapter
import com.example.myapplication.database.ProductDAO
import com.example.myapplication.database.appDatabase
import com.example.myapplication.database.userDAO
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_b_bdesc.*
import kotlinx.android.synthetic.main.fragment_edit_item.*
import kotlin.system.exitProcess


class EditItemFragment : Fragment() {

    lateinit var v: View
    lateinit var btSave: Button

    private var db: appDatabase? = null
    private var productDAO: ProductDAO? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_edit_item, container, false)

        db = appDatabase.getAppDataBase(v.context)
        productDAO = db?.productDao()
        btSave = v.findViewById(R.id.btSave)
        return v
    }


    override fun onStart() {
        super.onStart()

        btSave.setOnClickListener {

           if( edProdName.text.isBlank() || edProdDesc.text.isBlank() || edProdPrice.text.isBlank() ||  edMethodUse.text.isBlank() ||  edSourceMat.text.isBlank() ){
               Snackbar.make(v, "Complete todos los campos para continuar", Snackbar.LENGTH_SHORT).show()
               exitProcess(0)
           }
            Log.d("Esta linea se ejecuto", " cambio y fuera")

            val productos: MutableList<Product> = productDAO?.loadAllProducts() as MutableList<Product>

            var position : Int = productos.size
            var product = Product(position,edProdName.text.toString(), edProdPrice.text.toString().toInt(),edProdDesc.text.toString(), "",edMethodUse.text.toString(),edSourceMat.text.toString() )


            if ((activity as LoginActivity2).flagAdd){

                productDAO?.insertProduct(product)
                (activity as LoginActivity2).flagAdd = false
                Snackbar.make(v, "Se agrego " + edProdName.text, Snackbar.LENGTH_SHORT).show()
               // ProductListAdapter.data
            }
            if ((activity as BottomBarActivity).flagEdit){
                // mantiene el id que trae. Hay que ver cual tenia
                productDAO?.updateProduct(product)
                Snackbar.make(v, "Se edito " + edProdName.text, Snackbar.LENGTH_SHORT).show()
                (activity as BottomBarActivity).flagEdit = false
            }

            edProdName.text.clear()
            edProdDesc.text.clear()
            edProdPrice.text.clear()
            edMethodUse.text.clear()
            edSourceMat.text.clear()





        }
    }


}
