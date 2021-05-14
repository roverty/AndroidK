package com.example.clase2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_content.*
import kotlin.collections.ArrayList


class Content : AppCompatActivity() {

    val PREFS_NAME = "HelloApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        //Preguntas para el usuario
        var questions = ArrayList<Question>()
        var currentQuestion = 0
        var currentAnswer = -1
        var currentScore = 0F
        val quizName = intent.getStringExtra("quizName")
        val correo = intent.getStringExtra("correo")

        questions = intent.getSerializableExtra("questions") as ArrayList<Question>
        Toast.makeText(applicationContext, quizName, Toast.LENGTH_SHORT).show()
        updateQuestion(questions, currentQuestion)
        pb_quizz.max = questions.size

        //Si presiona la respuesta 1 entonces
        bt_respuesta1.setOnClickListener {
            currentAnswer = 0 //Ha presionado la primera respuesta
            updateButtonColor(currentAnswer, R.drawable.bt_answer_selected)
            updateButtonColor(1, R.drawable.bt_answer)
            updateButtonColor(2, R.drawable.bt_answer)
        }

        //Si presiona la respuesta 2 entonces
        bt_respuesta2.setOnClickListener {
            currentAnswer = 1 //Ha presionado la primera respuesta
            updateButtonColor(currentAnswer, R.drawable.bt_answer_selected)
            updateButtonColor(0, R.drawable.bt_answer)
            updateButtonColor(2, R.drawable.bt_answer)
        }

        //Si presiona la respuesta 3 entonces
        bt_respuesta3.setOnClickListener {
            currentAnswer = 2 //Ha presionado la primera respuesta
            updateButtonColor(currentAnswer, R.drawable.bt_answer_selected)
            updateButtonColor(0, R.drawable.bt_answer)
            updateButtonColor(1, R.drawable.bt_answer)
        }

        //Si presiona el tache para salir de la actividad
        iv_tache.setOnClickListener {
            mostrarMensaje("Has abandonado el juego.")
            val intento = Intent(applicationContext, Index::class.java)
            finish()
            startActivity(intento)
        }

        //Si presiona el botón para verificar la respuesta
        bt_check.setOnClickListener {
            //Si ya seleccionó una respuestas entonces
            if(currentAnswer != -1)
            {
                bt_check.isEnabled = false
                bt_respuesta1.isEnabled = false
                bt_respuesta2.isEnabled = false
                bt_respuesta3.isEnabled = false
                //Validamos la respuesta
                if (questions.get(currentQuestion).validAnswer == currentAnswer)
                {
                    //Marcamos en verde la respouesta del usuario
                    updateButtonColor(currentAnswer, R.drawable.bt_answer_green)
                    //Le sumamos 1 punto al score
                    currentScore += 1
                    pb_quizz.progress = currentScore.toInt()
                }
                else
                {
                    //Marcamos en rojo la respuesta del usuario
                    updateButtonColor(currentAnswer, R.drawable.bt_answer_red)
                    //Marcamos en verde la respuesta correcta
                    updateButtonColor(questions.get(currentQuestion).validAnswer, R.drawable.bt_answer_green)
                }

                //Despues de 2000ms pasamos a la siguiente pregunta
                runOnUiThread {
                    val handler = Handler()
                    handler.postDelayed(Runnable {
                        if (currentQuestion >= questions.size - 1) //Si ya era la última pregunta entonces pasamos a la otra actividad y mostramos puntaje
                        {
                            val intento = Intent(applicationContext, Index::class.java)
                            val editor = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
                            editor.putFloat("actividad:"+quizName+":"+correo, (currentScore/questions.size)*3)//Guardamos el puntaje de la actividad
                            editor.apply() //Guardamos los cambios en el teléfono
                            if((currentScore/questions.size)*3 >= 2F)
                                mostrarMensaje("Has desbloqueado el siguiente nivel.")
                            else
                                mostrarMensaje("Debes conseguir 2 estrellas o más para desbloquear el siguiente nivel.")
                            finish()
                            startActivity(intento)
                        } else {
                            currentAnswer = -1 //Deseleccionamos la respuesta
                            currentQuestion += 1 //Pasamos a la siguiente pregunta
                            updateQuestion(questions, currentQuestion) //Actualizamos los valores en pantalla
                            bt_check.isEnabled = true //Activamos el botón de check
                            bt_respuesta1.isEnabled = true //Activamos los botones de las respuestas
                            bt_respuesta2.isEnabled = true
                            bt_respuesta3.isEnabled = true
                        }
                    }, 2000)
                }
            }
        }
    }

    //Función que actualiza el color de un botón deacuerdo a su posición
    fun updateButtonColor(buttonPos: Int, resource: Int)
    {
        if(buttonPos == 0)
            bt_respuesta1.setBackgroundResource(resource)
        else if(buttonPos == 1)
            bt_respuesta2.setBackgroundResource(resource)
        else if(buttonPos == 2)
            bt_respuesta3.setBackgroundResource(resource)
    }

    //Función que actualiza las preguntas de la pantalla
    fun updateQuestion(questions: ArrayList<Question>, currentQuestion: Int)
    {
        //Establecemos la pregunta y sus respectivas respuestas
        tv_pregunta.text = questions.get(currentQuestion).question
        bt_respuesta1.text = questions.get(currentQuestion).answer1
        bt_respuesta2.text = questions.get(currentQuestion).answer2
        bt_respuesta3.text = questions.get(currentQuestion).answer3
        //Actualizamos los colores de los botones
        updateButtonColor(0, R.drawable.bt_answer)
        updateButtonColor(1, R.drawable.bt_answer)
        updateButtonColor(2, R.drawable.bt_answer)
    }

    //Función que muestra un toast en pantalla
    fun mostrarMensaje(mensaje:String) = Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
}
//Intents explícitos

//Mayalo
//Deepl

//SharedPrefereces
//google.com.gsun
//Start Activity For Result