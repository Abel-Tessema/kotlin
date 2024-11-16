package aquarium

@OptIn(ExperimentalStdlibApi::class)
fun main() {
  println(Color.RED.rgb.toHexString())
}

object MobyDickWhale {
  val author = "Herman Malville"
  fun jump() {}
}

enum class Color(val rgb: Int) {
  RED(0xFF0000),
  GREEN(0x00FF00),
  BLUE(0x0000FF)
}

enum class Direction {
  NORTH, SOUTH, EAST, WEST
}

sealed class Seal // Can be subclassed, but only in this file

class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
  return when (seal) {
    is SeaLion -> "Lion"
    is Walrus -> "Walrus"
  }
}
