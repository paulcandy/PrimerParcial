package com.example.myapplication.fragments


import Entities.Product
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.BottomBarActivity
import com.example.myapplication.LoginActivity2
import com.example.myapplication.R
import com.example.myapplication.adapters.ProductListAdapter
import com.example.myapplication.database.ProductDAO
import com.example.myapplication.database.appDatabase


class ListFragment : Fragment() {

    lateinit var v: View

    lateinit var recProducts : RecyclerView

   // lateinit var productos : MutableList<Product>
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var productListAdapter: ProductListAdapter


    //for database use :

    private var db: appDatabase? = null
    private var productDAO: ProductDAO? = null


    companion object {
        fun newInstance() = ListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        //menu.getItem(1).setEnabled(false);
    }


    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.getItem(1).setVisible(false)
        menu.getItem(2).setVisible(false)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_list, container, false)
        // Inflate the layout for this fragment
        recProducts = v.findViewById(R.id.recProducts)


        // operaciones de la base de datos
        db = appDatabase.getAppDataBase(v.context)
        productDAO = db?.productDao()

        setHasOptionsMenu(true)


        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()

        // operaciones del Recycler
        val productos: MutableList<Product> = productDAO?.loadAllProducts() as MutableList<Product>
        recProducts.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recProducts.layoutManager = linearLayoutManager
        productListAdapter= ProductListAdapter(productos,{ position -> onItemClick(position) }) { position ->onLongItemClick(position)}
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

    fun onLongItemClick(position: Int): Boolean {

        val productos: MutableList<Product> = productDAO?.loadAllProducts() as MutableList<Product>
        val alertDialog: AlertDialog = AlertDialog.Builder(this.context).create()
        alertDialog.setTitle("ALERTA")
        alertDialog.setMessage("Desea Eliminar " + productos[position].name)
        alertDialog.setButton("ACEPTAR", DialogInterface.OnClickListener { dialog, which ->
            // here you can add functions
            productDAO!!.delete(productos[position])
            Log.d("funciona", "el alert dialog")
        })
        alertDialog.setIcon(R.drawable.components)
        alertDialog.show()

        return false
    }




    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = when(item.itemId) {

            R.id.action_add -> onAddToolbar()//Snackbar.make(v, "add", Snackbar.LENGTH_SHORT).show()

            R.id.action_config -> onConfigToolbar()
        //    R.id.action_edit ->Snackbar.make(v, "edit", Snackbar.LENGTH_SHORT).show()

            else -> ""
        }
        return super.onOptionsItemSelected(item)
    }

     fun onAddToolbar(){
         (activity as LoginActivity2).flagAdd = true
        val action = ListFragmentDirections.actionListFragmentToEditItemFragment()
        v.findNavController().navigate(action)
    }

    fun onConfigToolbar(){
     //   (activity as LoginActivity2).flagAdd = true
        val action = ListFragmentDirections.actionListFragmentToSettingsActivity()
        v.findNavController().navigate(action)
    }
}