​/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */

fun main() {

    //val es para variables que son constantes (read-only: solo de lectura)
    val nombre = "ROdrigo" // aqui se hace inferencia de tipos
    println("hola "+nombre)
    println("hola $nombre")
    
    var edad: Int = 24
    
    println("$nombre tiene ${edad+9}")
    
    println("$nombre tiene ${edad.toChar()}")
    
    var estoEsDouble: Double = 12.0 // es necesario poner el punto y el cero
    
    // null safety
    // no admite nulos
    // 
    val str0 :String = "no puede tener nulos"
    
    val str :String? = null
    
    println(str?.length)
    
    //println(str!!.length) //Estas regresando a Java, porque admirtes el NPE
    
    println("La longitud de peach es "+calcularLong(null))
    
    println("3.14 to Int : " + 3.14.toInt())
    
    val numbersArray = Array(5, { i -> i * 2 })
    //cantidad, pares
	numbersArray.forEach { println(it) }
    //arreglo, recorrer
    //
    var item = 12
    for (item in numbersArray){
    	print(item) //print("item\n")
	}
    println(item)
    
    println("Apartir de aqui son ciclos")
    
    
    when(edad){
        12 -> println("Estas apunto de entrar a la secu")
        
        4,5,6 -> println("Ve a kinder")
        
        in 12..30 -> println("Ve a la universidad")
        
        else -> println("No se reconocio tu edad")
    }
    
    println("funciones :) ")
    println()
    
    println("5+7 = ${sumar(5,7)}")
    println("5+7 = ${resta(num2=5,num1=7)}")
    println()
    
    saludar("Rodrigo")
}

fun calcularLong(cadenita : String?) : Int?{
 	//En caso de que sea null-Presley
    return cadenita?.length ?: -1
}

//No retorne nada

fun imprimirColor() : Unit{
    println("SOy negro")
}

fun imprimirColor2(){
    println("SOy negro")
}

// funciones en linea
fun sumar(num1: Int, num2:Int) = num1+num2
fun resta(num1: Int, num2:Int) = num1-num2

fun saludar(nombre:String, apellido:String = "Franciso"):Unit = println("hola $nombre $apellido")

////internal=modificador de acceso

class Animal(val nombre: String){
    var private peso:Int
    
}