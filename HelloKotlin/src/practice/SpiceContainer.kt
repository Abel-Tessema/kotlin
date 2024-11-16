package practice

fun main() {
  val spice1 = SpiceContainer(Spice("curry"))
  val spice2 = SpiceContainer(Spice("pony"))
  val spice3 = SpiceContainer(Spice("pony"))

  println(spice1)
  println(spice2)
  println(spice2 == spice3)
}

data class SpiceContainer (val spice: Spice, val label: String = spice.name)