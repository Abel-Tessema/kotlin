package aquarium.decorations

fun main() {
  makeDecoration()
}

fun makeDecoration() {
  val decoration1 = Decoration("granite")
  println(decoration1)

  val decoration2 = Decoration("slate")
  val decoration3 = Decoration("slate")
  println(decoration1.equals(decoration2))
  println(decoration2.equals(decoration3))

  val decoration4 = decoration1.copy()
  println(decoration1)
  println(decoration4)

  val decoration5 = Decoration2("crystal", "wood", "diver")
  val (rock, wood, diver)= decoration5
  println(rock)
  println(wood)
  println(diver)
}

data class Decoration (val rocks: String)

data class Decoration2 (val rocks: String, val wood: String, val diver: String)