package com.example.clase2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var ingresar : Button
    lateinit var registrarse : Button
    val PREFS_NAME = "HelloApp"

    val map:HashMap<String,String> = hashMapOf("user@gmail.com" to "123", "user2@gmail.com" to "contraseña", "com1pac56@hotmail.com" to "123456789")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firstview);

        //Contiene las referecias a los objetos creados en la vista
        ingresar = findViewById(R.id.first_bt_ingresar)
        registrarse = findViewById(R.id.first_bt_registrarse)

        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        //Si ya hay alguien logeado en la aplicación iniciamos su sesión directamente.
        if (prefs.getString("user", null) != null)
        {
            mostrarMensaje("Bienvenido de vuelta!")
            val intento = Intent(applicationContext,Index::class.java)
            startActivity(intento)
        }

        //Cada vez que se presiona el botón ejecuta el código de abajo
        ingresar.setOnClickListener {
            val intento = Intent(applicationContext,Login::class.java) //Lo llevamos a la pantalla de Login
            startActivity(intento)
        }

        registrarse.setOnClickListener {
            val intento = Intent(applicationContext,Registro::class.java) //Lo llevamos a la pantalla de Registro
            startActivity(intento)
        }

    }

    fun mostrarMensaje(mensaje:String) = Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
}