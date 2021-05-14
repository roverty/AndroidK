package com.example.clase2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.registro.*

class Registro : AppCompatActivity() {

    val PREFS_NAME = "HelloApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        //Si presiona el botón registrarse, tenemos que validar el formulario
        bt_registrarse.setOnClickListener {
            if(revisarFormulario())//Si ya escribió todos sus datos entonces procedemos a registrarlo en el teléfono
            {
                val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                //Se supone que no tendría que salir null porque se verifica en el main o cuando se logea
                val correo = prefs.getString("email:"+et_email.text.toString(), null);
                if(correo == null)//Si ese usuario no está registrado lo registramos
                {
                    bt_registrarse.isEnabled = false
                    //Guardamos los datos del usuario dentro del teléfono
                    val editor = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
                    editor.putString("nombre:" + et_email.text.toString(), et_nombre.text.toString())
                    editor.putString("apellidos:" + et_email.text.toString(), et_apellidos.text.toString())
                    editor.putString("email:" + et_email.text.toString(), et_email.text.toString())
                    editor.putString("contrasena:" + et_email.text.toString(), et_registro_contrasena.text.toString())
                    editor.putString("telefono:" + et_email.text.toString(), et_telefono.text.toString())
                    if (rb_masculino.isChecked)
                        editor.putString("genero:" + et_email.text.toString(), "masculino")
                    else
                        editor.putString("genero:" + et_email.text.toString(), "femenino")
                    editor.putString(
                        "user",
                        null
                    ) //Cerramos la sesión que haya abierta para que pueda iniciar el nuevo usuario
                    editor.apply() //Guardamos los cambios y cerramos

                    //Volvemos a la pantalla principal
                    mostrarMensaje("Usuario: " + et_email.text.toString() + " registrado exitosamente!")

                    val intento = Intent(applicationContext, MainActivity::class.java)
                    finish()
                    startActivity(intento)
                }
                else
                    mostrarMensaje("Ese correo ya está registrado.")
            }
        }

    }

    fun revisarFormulario(): Boolean {
        if(et_nombre.text.isEmpty())
        {
            mostrarMensaje("Escribe tu nombre.")
            return false
        }
        if(et_apellidos.text.isEmpty())
        {
            mostrarMensaje("Escribe tus apellidos.")
            return false
        }
        if(et_email.text.isEmpty())
        {
            mostrarMensaje("Escribe tu email.")
            return false
        }
        if(et_registro_contrasena.text.isEmpty())
        {
            mostrarMensaje("Escribe una contraseña para tu cuenta.")
            return false
        }
        if(et_telefono.text.isEmpty())
        {
            mostrarMensaje("Escribe tu teléfono.")
            return false
        }
        if(!rb_masculino.isChecked && !rb_femenino.isChecked)
        {
            mostrarMensaje("Selecciona tu género.")
            return false
        }
        return true
    }

    fun mostrarMensaje(mensaje:String) = Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
}