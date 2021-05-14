package com.example.clase2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class Login : AppCompatActivity() {

    lateinit var correo : EditText
    lateinit var contraseña : EditText
    lateinit var ingresar : Button
    val PREFS_NAME = "HelloApp"

    val map:HashMap<String,String> = hashMapOf("user@gmail.com" to "123", "user2@gmail.com" to "contraseña", "user@hotmail.com" to "123456789")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login);

        //Contiene las referecias a los objetos creados en la vista
        correo = findViewById(R.id.et_correo)
        contraseña = findViewById(R.id.et_contrasena)
        ingresar = findViewById(R.id.bt_ingresar)

        //Cada vez que se presiona el botón ejecuta el código de abajo
        ingresar.setOnClickListener {
            if(map[correo.text.toString()] == contraseña.text.toString())
            {
                Toast.makeText(this,"Inicio de sesión exitoso.", Toast.LENGTH_SHORT).show()
                val editor = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
                editor.putString("user", correo.text.toString())
                editor.apply()
                val intento = Intent(applicationContext,Index::class.java)
                startActivity(intento)
            }
            else
            {
                //Verificamos si está registrado en SharedPreferences
                val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                //Si existe su email en la base de datos entonces si está registrado
                if (prefs.getString("email:"+correo.text.toString(), null) != null)
                {
                    //Si la contraseña es correcta, inicia sesión.
                    if(prefs.getString("contrasena:"+correo.text.toString(), null) == contraseña.text.toString())
                    {
                        mostrarMensaje("Inicio de sesión exitoso.")
                        val editor = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
                        editor.putString("user", correo.text.toString())
                        editor.apply()
                        val intento = Intent(applicationContext,Index::class.java)
                        startActivity(intento)
                    }
                    else
                        mostrarMensaje("Inicio de sesión fallido.")
                }
                else
                    mostrarMensaje("Inicio de sesión fallido.")
            }
        }
    }

    fun mostrarMensaje(mensaje:String) = Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
}