package spice

fun main() {
  val curry = Curry("spicy af")
  println(curry.color)
}

enum class Color(val rgb: Int) {
  RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);
}

sealed class Spice (val name: String, val spiciness: String = "mild") {
  val heat: Int
    get() = 5
  init {
    println("Constructed spice with name $name and spiciness $spiciness.")
  }

  abstract fun prepareSpice()
}

class Curry (spiciness: String, color: SpiceColor = YellowSpiceColor) :
  Spice("curry", spiciness),
  Grinder,
  SpiceColor by YellowSpiceColor {
  override fun prepareSpice() {
    println("Preparing curry.")
  }

  override fun grind() {
    println("Grinding curry.")
  }
}

interface Grinder {
  fun grind()
}

interface SpiceColor {
  val color: Color
}

object YellowSpiceColor : SpiceColor {
  override val color = Color.YELLOW
}