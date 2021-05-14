package com.example.clase2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.quizitem.view.*

//Inflar es similar a crear una instancia de un objeto
//Una interfaz está hecha para implementar métodos en otra clase ya predefinidos

class QuizAdapter(val quizList: ArrayList<Quizz>, var listener:ClickListener): RecyclerView.Adapter<QuizAdapter.ViewHolder>() {

    var viewHolder: ViewHolder? = null

    //Cambio de contexto es el cambio de layouts entre pantalla
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.quizitem, parent, false)
        viewHolder = ViewHolder(vista, listener)

        return viewHolder as ViewHolder
    }

    override fun getItemCount(): Int {
        return quizList.size
    }

    //Enlazar con la class ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = quizList[position]
        holder.quizImage?.setImageResource(item.imgQuiz)
        holder.quizTitle?.text = item.nombreQuizz
        holder.lockImage?.setImageResource(item.lock)
        holder.ratingBar?.rating = item.puntuacion
    }

    class ViewHolder(itemView: View, listener: ClickListener): RecyclerView.ViewHolder(itemView),View.OnClickListener {
        override fun onClick(p0: View?)
        {
            if (p0 != null) {
                mylistener.onClick(p0, adapterPosition)
            }
        }

        val vista = itemView
        val mylistener = listener

        var quizImage : ImageView? = null
        var quizTitle : TextView? = null
        var lockImage : ImageView? = null
        var ratingBar : RatingBar? = null

        //Cuando se instancie vamos a hacer cosas
        init {
            quizImage = itemView.iv_animal
            quizTitle = itemView.tv_titulo
            lockImage = itemView.iv_lock
            ratingBar = itemView.ratingBar

            vista.setOnClickListener(this)
        }
    }

}

interface ClickListener {
    fun onClick(view:View,position: Int)
}
