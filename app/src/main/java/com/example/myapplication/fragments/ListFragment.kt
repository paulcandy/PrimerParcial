package com.example.myapplication.fragments


import Entities.Product
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.BottomBarActivity
import com.example.myapplication.R
import com.example.myapplication.adapters.ProductListAdapter
import com.google.android.material.snackbar.Snackbar


class ListFragment : Fragment() {

    lateinit var v: View

    lateinit var recProducts : RecyclerView

    var productos : MutableList<Product> = ArrayList<Product>()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var productListAdapter: ProductListAdapter

    companion object {
        fun newInstance() = ListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
      //  val toolbar = v.findViewById<android.widget.Toolbar>(R.id.toolbar)
     //   setSupportActionBar(toolbar)
      //  setSupportActionBar(toolbar)

        productos.add(
            Product(
                "Tornillos Ocultos",
                250,
                "Para realizar agujeros con inclinacion y hacer uniones ocultas",
                "",
                "agarrar a la madera y pasar la mecha",
                "plastico y bujes"
            )
        )
        productos.add(
            Product(
                "Afilador Cinceles",
                150,
                "Para afilar cinceles",
                "",
                "presionar el cincel y desplazar sobre lija o piedra",
                "plastico, rulemanes y bulones"
            )
        )
        productos.add(
            Product(
                "Kit Tope de Mecha",
                60,
                "Para dar profundidad exacta a las perforaciones",
                "",
                "colocar al largo deseado y presionar el tornillo",
                "plastico y bulones"
            )
        )
        productos.add(
            Product(
                "Gramil",
                120,
                "Trazado de lineas paralelas en madera",
                "",
                "Ajustar la parte movil a la distancia deseada y desplazar con suavidad",
                "plastico y bulones"
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_list, container, false)
        // Inflate the layout for this fragment
        recProducts = v.findViewById(R.id.recProducts)

        setHasOptionsMenu(true)


        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    //override fun on

    override fun onStart() {
        super.onStart()




        recProducts.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recProducts.layoutManager = linearLayoutManager

        productListAdapter= ProductListAdapter(productos){ position -> onItemClick(position)}
        //productListAdapter = ProductListAdapter(productos)

        recProducts.adapter = productListAdapter
    }


        fun onItemClick(position: Int) {
            val intent = Intent(
                requireActivity().baseContext,
                BottomBarActivity::class.java
            )
            intent.putExtra("message", position.toString())
            intent.putExtra("position", position)
            requireActivity().startActivity(intent)


         }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = when(item.itemId) {

            R.id.action_add ->Snackbar.make(v, "add", Snackbar.LENGTH_SHORT).show()

            R.id.action_edit ->Snackbar.make(v, "edit", Snackbar.LENGTH_SHORT).show()

            else -> ""
        }
        return super.onOptionsItemSelected(item)
    }
}