// Grade Dependancies:
// implementation("org.slf4j:slf4j-simple:1.7.36")
// implementation ("io.github.microutils:kotlin-logging:2.1.23")

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}


fun main(){
    logger.info { "Launching the Placemark Console App!" }
    println("Placemark Kotlin App Version 1.0")

    var input: Int

    do{
        input = menu()
        when(input) {
            1 -> addPlacemark()
            2 -> updatePlacemark()
            3 -> listAllPlacemarks()
            -1 -> println("Exiting App!")
            else -> println("That's an Invalid Option!")
        }
        println()
    } while (input != -1)
    logger.info {"Shutting Down the Placemark Console App!"}
}

// MENU FUNCTION
fun menu(): Int {
    var option : Int
    var input : String? = null

    println("Main Menu")
    println("1, Add Placemark")
    println("2. Update Placemark")
    println("3. List All Placemarks")
    println("-1, Exit")
    println()
    print("Enter an integer : ")
    input = readLine()!!

    // VALIDATE INPUT
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9

    return option
}

// ADD PLACEMARK FUNCTION
fun addPlacemark(){
    println("You Chose to Add a Placemark!")
}

// UPDATE PLACEMARK FUNCTION
fun updatePlacemark(){
    println("You Chose to Update a Placemark!")
}

// LIST ALL PLACEMARKS
fun listAllPlacemarks(){
    println("You Chose to List all Placemarks!")
}
