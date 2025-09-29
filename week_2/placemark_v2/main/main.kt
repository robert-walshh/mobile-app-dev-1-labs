import mu.KotlinLogging
import org.setu.placemark.console.models.PlacemarkModel

private val logger = KotlinLogging.logger {}

var placemark = PlacemarkModel()
val placemarks = ArrayList<PlacemarkModel>()


fun main() {
    logger.info { "Launching the Placemark Console App!" }
    println("Placemark Kotlin App Version 2.0")

    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> addPlacemark()
            2 -> updatePlacemark()
            3 -> listAllPlacemarks()
            4 -> searchPlacemark()
            -99 -> dummyData()
            -1 -> println("Exiting App!")
            else -> println("That's an Invalid Option!")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down the Placemark Console App!" }
}

// MENU FUNCTION
fun menu(): Int {
    var option: Int
    var input: String? = null

    println("Main Menu")
    println("1, Add Placemark")
    println("2. Update Placemark")
    println("3. List All Placemarks")
    println("4. Search Placemarks")
    println("-99. Add Dummy Data for Testing Purposes")
    println("-1. Exit")
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
fun addPlacemark() {
    println("Add Placemark")
    println()
    println("Enter a Title : ")
    placemark.title = readLine()!!
    println("Enter a Description : ")
    placemark.description = readLine()!!

    if (placemark.title.isNotEmpty() && placemark.description.isNotEmpty()) {
        placemarks.add(placemark.copy())
        placemark.id++
        logger.info("Placemark Added : [ " + placemark.title + " ]")
        println("You entered [ " + placemark.title + " ] for title and [ " + placemark.description + " ] for description!")
    }
    else
        logger.info("ERROR: Placemark Not Added")
        println("You cannot have a blank Placemark!!")
}

// UPDATE PLACEMARK FUNCTION
fun updatePlacemark() {
    println("Update Placemark")
    println()
    listAllPlacemarks()
    var searchID = getID()
    val aPlacemark = search(searchID)
    val tempTitle : String?
    val tempDescription : String?

    if (aPlacemark != null){
        println("Enter a new Title for [ " + aPlacemark.title + " ] : ")
        tempTitle = readLine()!!
        println("Enter a new Description for [ " + aPlacemark.description + " ] : ")
        tempDescription = readLine()!!

        if (tempTitle.isNotEmpty() && tempDescription.isNotEmpty()){
            aPlacemark.title = tempTitle
            aPlacemark.description = tempDescription
            println("You updated [ " + aPlacemark.title + " ] for title and [ " + aPlacemark.description + "] for description")
        }
        else
            println("\nPlacemark Name and Description Cannot Be Blank!")
    }
    else
        println("\nPlacemark Not Updated... :(")
}

// LIST ALL PLACEMARKS
fun listAllPlacemarks() {
    println("List All Placemarks")
    println()
    placemarks.forEach { println("$it") }
}

// GET ARRAY IDS
fun getID() : Long {
    var strId : String? // This is to hold user input
    var searchId : Long // This is to hold converted ID
    print("Enter an ID to Search or Update : ")
    strId = readLine()!!
    searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
        strId.toLong()
    else
        -9
    return searchId
}

// SEARCH ARRAY IDS
fun search(id: Long) : PlacemarkModel? {
    var foundPlacemark : PlacemarkModel? = placemarks.find { p -> p.id == id }
    return foundPlacemark
}

// FUNCTION TO USE THE ABOVE
fun searchPlacemark(){
    var searchId = getID()
    val aPlacemark = search(searchId)

    if (aPlacemark != null)
        println("Placemark Details: [ $aPlacemark ]")
    else
        println("Placemark Not Found... :(")
}

// DUMMY DATA FOR QUICK TESTING PURPOSES
fun dummyData() {
    placemarks.add(PlacemarkModel(1, "Barcelona", "Hola em dic Robert!"))
    placemarks.add(PlacemarkModel(2, "Cupertino", "Good Morning and Welcome to Apple Park!"))
    placemarks.add(PlacemarkModel(3, "Helsinki", "Former home of Vastaamo which perished to a massive Data Breach"))
}
