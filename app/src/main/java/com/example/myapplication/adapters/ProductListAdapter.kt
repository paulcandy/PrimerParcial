package com.example.myapplication.adapters

import Entities.Product
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.product_item.view.*
class ProductListAdapter(private var productList : MutableList<Product>, val onItemClick : (Int) -> Unit) : RecyclerView.Adapter<ProductListAdapter.ProductHolder>(){

    companion object {

        private val TAG = "ProductListAdapter"
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        //aca se arma el elemento de la lista. To-do lo que sea configurar el item va aca
        holder.setName(productList[position].productName)
        holder.getCardLayout().setOnClickListener {
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return productList.size

    }

    class ProductHolder (v : View) : RecyclerView.ViewHolder(v) {
        private var view : View

        init {
            this.view = v
        }

        fun setName ( name : String){
            //escribe el texto del item card
            val txt: TextView = view.findViewById(R.id.txtCard)
            txt.text = name
        }
        fun getCardLayout (): CardView {
            return view.findViewById(R.id.card_item)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)
        return (ProductHolder(view))
    }

}