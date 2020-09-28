package com.example.myapplication

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
import com.example.myapplication.database.appDatabase
import com.example.myapplication.database.userDAO

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long =1500 //3 seg


    private var db: appDatabase? = null
    private var userDao: userDAO? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        db = appDatabase.getAppDataBase(this)
        userDao = db?.userDao()

        //verifico si la tabla esta inicializada. sino la cargo
        var usuarios: MutableList<User>
        usuarios = userDao?.loadAllPersons() as MutableList<User>
        if (usuarios.isEmpty()){
            userDao?.insertPerson(User( 0, "pchiaram", "1234","Pablo Chiara"))
            userDao?.insertPerson(User(1, "cjordan", "12345", "Carina Jordan")            )
            userDao?.insertPerson(User(2, "clubrano", "123456", "Cecilia Lubrano"))
            userDao?.insertPerson(User(3, "esisca", "1234", "Ezequiel Sisca"))

        }

        Handler().postDelayed(
            {
                startActivity(Intent(this,LoginActivity2::class.java))
                finish()
            }
            , SPLASH_TIME_OUT)
    }
}