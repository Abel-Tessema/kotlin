package practice

class Spice (val name: String, val spiciness: String = "mild") {
  val heat: Int
    get() = 5
  init {
    println("Constructed spice with name $name and spiciness $spiciness.")
  }
}

fun makeSalt() = Spice(name = "salt", spiciness = "not spicy")