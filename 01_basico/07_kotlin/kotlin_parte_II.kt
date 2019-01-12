/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */

fun main() {
	nivelEducativo(6)
    
    for (i in 10 until 1) {
    	// i in [1, 10), 10 is excluded
    	println(i)
	}
}

//funcion que recibe un int y no regresa nada

fun nivelEducativo(edad: Int): Unit{

  //when es equivalente a switch case
   when(edad){
       0 -> println("Ni has nacido...")
       
       in 6..12 -> println("Irse al primaria")
       
       4,5,6 -> println("Irse al kinder")
       
       //Default
       else -> println("No se vas a hacer con tu vida")
   } 
}