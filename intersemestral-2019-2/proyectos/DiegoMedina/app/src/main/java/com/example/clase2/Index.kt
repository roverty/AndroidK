package com.example.clase2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.index.*

class Index : AppCompatActivity() {

    val PREFS_NAME = "HelloApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.index)

        val quizzes = ArrayList<Quizz>()
        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        //Se supone que no tendría que salir null porque se verifica en el main o cuando se logea
        val correo = prefs.getString("user", null);

        //Cargamos el nombre de usuario y sus puntajes en las actividades en el recycler view.
        tv_bienvenido.text = "¡Bienvenido!\n" + prefs.getString("nombre:"+correo, null) + "\n" + prefs.getString("apellidos:"+correo, null)

        //Si el jugador ya obtuvo más de 2 estrellas puede desbloquear la actividad
        quizzes.add(Quizz(R.drawable.parrot,"Animals",R.drawable.unlock, prefs.getFloat("actividad:Animals:"+correo, 0F)))
        if(prefs.getFloat("actividad:Animals:"+correo, 0F) >= 2F)
            quizzes.add(Quizz(R.drawable.hamburger,"Food",R.drawable.unlock, prefs.getFloat("actividad:Food:"+correo, 0F)))
        else
            quizzes.add(Quizz(R.drawable.hamburger,"Food",R.drawable.padlock, prefs.getFloat("actividad:Food:"+correo, 0F)))
        if(prefs.getFloat("actividad:Food:"+correo, 0F) >= 2F)
            quizzes.add(Quizz(R.drawable.fruit,"Fruits",R.drawable.unlock, prefs.getFloat("actividad:Fruits:"+correo, 0F)))
        else
            quizzes.add(Quizz(R.drawable.fruit,"Fruits",R.drawable.padlock, prefs.getFloat("actividad:Fruits:"+correo, 0F)))

        val questions = ArrayList<Question>()
        var sendQuestions = ArrayList<Question>()

		//Aqui se van agregando las preguntas que uno quiera
        questions.add(Question("Animals","¿Cómo se dice 'aguila' en inglés?", "Bear", "Eagle", "Pig", 1))
        questions.add(Question("Animals","¿Cómo se dice 'conejo' en inglés?", "Rabbit", "Fish", "Bird", 0))
        questions.add(Question("Animals","¿Cómo se dice 'shark' en español?", "Conejo", "Ballena", "Tiburón", 2))

        questions.add(Question("Food","¿Cómo se dice 'hamburguesa' en inglés?", "Rice", "Stew", "Hamburger", 2))
        questions.add(Question("Food","¿Cómo se dice 'calabaza' en inglés?", "Pumpking", "Carrot", "Pear", 0))
        questions.add(Question("Food","¿Cómo se dice 'palomitas' en español?", "Soda", "Pop Corn", "Grain", 1))
        questions.add(Question("Food","¿Cómo se dice 'sopa' en inglés?", "Soup", "Pizza", "Mashed Potatoes", 0))

        questions.add(Question("Fruits","¿Cómo se dice 'naranja' en inglés?", "Pear", "Orange", "Watermelon", 1))
		questions.add(Question("Fruits","¿Cómo se dice 'pera' en inglés?", "Carrot", "Orange", "Pear", 2))
		questions.add(Question("Fruits","¿Cómo se dice 'sandia' en inglés?", "Pear", "Orange", "Watermelon", 2))

        rv_quizz.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?

        rv_quizz.adapter = QuizAdapter(quizzes,object : ClickListener{
            override fun onClick(view: View, position: Int) {
                if(quizzes[position].lock == R.drawable.padlock)
                    Toast.makeText(applicationContext, "Aún no has desbloqueado este nivel.",Toast.LENGTH_SHORT).show()
                else
                {
                    //Toast.makeText(applicationContext, "Cargando...", Toast.LENGTH_SHORT).show()

                    //Buscamos las preguntas que son del tema que eligió
                    for (question in questions) {
                        //Si encuentra que son de ese tema entonces las pasamos a un nuevo arreglo
                        if(question.type == quizzes[position].nombreQuizz)
                            sendQuestions.add(question) //Añadimos la pregunta
                    }

                    val intento = Intent(applicationContext, Content::class.java)
                    intento.putExtra("quizName", quizzes[position].nombreQuizz)
                    intento.putExtra("questions", sendQuestions) //Le pasamos las preguntas
                    intento.putExtra("correo", correo) //Le pasamos las preguntas
                    finish()
                    startActivity(intento)
                }
            }
        })
    }
}