package aquarium

import kotlin.math.PI

open class Aquarium (var length: Int = 10, var width: Int = 20, var height: Int = 30) {
  open var volume: Int
    get() = length * width * height / 1_000
    set(value) {height = value * 1000 / width * length}

  open var water = volume * 0.9

  constructor(numberOfFish: Int) : this() {
    val water = numberOfFish * 2_000 // cm3
    val tank = water * water * 0.1
    height = (tank / (length * width)).toInt()
  }
}

class TowerTank() : Aquarium() {
  override var water = volume * 0.8
  override var volume: Int
    get() = (length * width * height / 1_000 * PI).toInt()
    set(value) {height = value * 1000 / width * length}

}