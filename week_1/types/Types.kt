// WEEK 01 - TYPES PROJECT

fun main(){
    typeInterference()
    usingUnderscores()
    booleansAndCharacters()
    explicitConversions(25)
    mutableVariables(10, 20)
}

// BASIC TYPES

fun typeInterference(){
    println("\n===============================================")
    println("======= Using Type Inference in Kotlin: =======")
    println("===============================================")

    val doubleNumber = 1200.45
    val floatNumber = 700.78f
    val longNumber = 98765432L
    val intNumber = 123456
    val shortNumber = 345
    val byteNumber = 127

    println("doubleNumber value is: " + doubleNumber + ", and the type is " + doubleNumber.javaClass)
    println("floatNumber value is: " + floatNumber + ", and the type is " + floatNumber.javaClass)
    println("longNumber value is: " + longNumber + ", and the type is " + longNumber.javaClass)
    println("intNumber value is: " + intNumber + ", and the type is " + intNumber.javaClass)
    println("shortNumber value is: " + shortNumber + ", and the type is " + shortNumber.javaClass)
    println("byteNumber value is: " + byteNumber + ", and the type is " + byteNumber.javaClass)
}

// VALUES WITH UNDERSCORES

fun usingUnderscores(){
    println("\n====================================================")
    println("======= Using Underscores in Numeric Values: =======")
    println("====================================================")

    val oneMillion = 1_000_000
    val threeThousand = 3_000
    val creditCardNumber = 1234_4321_5678_8765

    println("\t" + oneMillion + " - the type is: " + oneMillion.javaClass)
    println("\t" + threeThousand + " - the type is: " + threeThousand.javaClass)
    println("\t" + creditCardNumber + " - the type is: " + creditCardNumber.javaClass)
}

// BOOLEAN AND CHARACTER TYPES

fun booleansAndCharacters(){
    println("\n========================================")
    println("======= Booleans and Characters: =======")
    println("========================================")

    // BOOLEAN TYPES

    val aFlag = true
    val bFlag = false

    println("Boolean Types:")
    println("aFlag " + aFlag + " - the type is: " + aFlag.javaClass)
    println("bFlag " + bFlag + " - the type is: " + bFlag.javaClass)

    // CHARACTERS TYPES

    val aChar = 'a' // Type Inference
    val bChar: Char = 'b' // Explicit Definition

    println("\nCharacter Types:")
    println("aChar " + aChar + " - the type is: " + aChar.javaClass)
    println("bChar " + bChar + " - the type is: " + bChar.javaClass)
}

// CONVERTING NUMBERS + FUNCTION WITH PARAMETER

fun explicitConversions(inputByte: Byte){
    println("\n=====================================")
    println("======= Explicit Conversions: =======")
    println("=====================================")

    val byteNum: Byte =  inputByte
    // val intNum: Int = byteNum < - Syntax Error
    val intNum: Int = byteNum.toInt() // Explicit Conversion is Okay
    val floatNum: Float = byteNum.toFloat()
    val doubleNum: Double = intNum.toDouble()

    println("byteNum value is: " + byteNum + ", and the type is " + byteNum.javaClass)
    println("byteNum converted to intNum value is: " + intNum + ", and the type is " + intNum.javaClass)
    println("byteNum converted to floatNum value is: " + floatNum + ", and the type is " + floatNum.javaClass)
    println("intNum converted to doubleNum value is: " + doubleNum + ", and the type is " + doubleNum.javaClass)
}

fun mutableVariables(input: Int, updatedNumber: Int){
    println("\n===============================================")
    println("======= Working with Mutable Variables: =======")
    println("===============================================")

    var number = input

    number ++ // Mathematical Operations are allowed
    println("number: " + number)

    number = updatedNumber // Reassignment is allowed
    println("number: " + number)
}

