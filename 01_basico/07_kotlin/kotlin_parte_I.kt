/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */

fun main() {

	// una cadena que puede ser nula
    var cadena : String? 
    
    //inferencia de tipos y cadena larga
    var cadena2 =""" 
    	hola soy rodrigo
        que 
    """
    cadena = null
    
    val str ="Hola"
    
    println("la longitud es ${longituCadena(cadena)}")
    
    longitudCadena3(str)
    
    println("Suma de 3+5 = ${sumar(3,5)}")
    
    println("Resta de 3-5 = ${resta(num2=5,num1=3)}")

}    

//funcion que recibe una cadena que puede ser nulla y regresa un entero que no puede ser nullo
fun longituCadena(cadena: String?) : Int{
    return cadena?.length ?: -1 // uso del operador elvis (?:)
}
fun longituCadena2(cadena: String?) : Int?{
    return cadena?.length
}

fun longitudCadena3(cadena: String?) : Unit{
    println("la longitud es ${cadena?.length} usando la f3")
}

fun longitudCadena4(cadena: String?) : Int? = cadena?.length

//funcion en linea
fun sumar(num1 : Int, num2:Int): Int = num1+num2


fun resta(num1 : Int, num2:Int): Int = num1-num2