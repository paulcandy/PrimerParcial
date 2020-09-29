package com.example.myapplication

import Entities.Product
import Entities.User
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.database.ProductDAO
import com.example.myapplication.database.appDatabase
import com.example.myapplication.database.userDAO

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long =1500 //3 seg


    private var db: appDatabase? = null
    private var userDao: userDAO? = null
    private var productDAO: ProductDAO? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        db = appDatabase.getAppDataBase(this)
        userDao = db?.userDao()
        productDAO = db?.productDao()

        //verifico si la tabla esta inicializada. sino la cargo
        var usuarios: MutableList<User>
        usuarios = userDao?.loadAllPersons() as MutableList<User>
        if (usuarios.isEmpty()){
            //creo la tabla de Users
            userDao?.insertPerson(User( 0, "pchiaram", "1234","Pablo Chiara"))
            userDao?.insertPerson(User(1, "cjordan", "12345", "Carina Jordan")            )
            userDao?.insertPerson(User(2, "clubrano", "123456", "Cecilia Lubrano"))
            userDao?.insertPerson(User(3, "esisca", "1234", "Ezequiel Sisca"))


            //creo la tabla de products

            productDAO?.insertProduct(Product( 0,"Tornillos Ocultos",250,"Para realizar agujeros con inclinacion y hacer uniones ocultas", "", "agarrar a la madera y pasar la mecha", "plastico y bujes"))
            productDAO?.insertProduct(Product(    1,                "Afilador Cinceles",                    150, "Para afilar cinceles", "", "presionar el cincel y desplazar sobre lija o piedra", "plastico, rulemanes y bulones")            )
            productDAO?.insertProduct(
                Product(
                    2,
                    "Kit Tope de Mecha",
                    60,
                    "Para dar profundidad exacta a las perforaciones",
                    "",
                    "colocar al largo deseado y presionar el tornillo",
                    "plastico y bulones"
                )
            )
            productDAO?.insertProduct(
                Product(
                    3,
                    "Gramil",
                    120,
                    "Trazado de lineas paralelas en madera",
                    "",
                    "Ajustar la parte movil a la distancia deseada y desplazar con suavidad",
                    "plastico y bulones"
                )
            )



        }

        Handler().postDelayed(
            {
                startActivity(Intent(this,LoginActivity2::class.java))
                finish()
            }
            , SPLASH_TIME_OUT)
    }
}