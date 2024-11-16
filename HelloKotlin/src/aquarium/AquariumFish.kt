package aquarium

fun main() {
  delegate()
}

fun delegate() {
  val plecostomus = Plecostomus()
  println("Fish has color: ${plecostomus.color}")
}

//abstract class AquariumFish : FishAction {
//  abstract val color: String
//  override fun eat() = println("Yum.")
//}

//class Shark : AquariumFish(), FishAction {
//  override val color = "gray"
//  override fun eat() {
//    println("Hunt and eat fish.")
//  }
//}

//class Plecostomus : AquariumFish(), FishAction {
//  override val color = "gold"
//  override fun eat() {
//    println("Munch on algae.")
//  }
//}

class Plecostomus (fishColor: FishColor = GoldColor) :
  FishAction by PrintingFishAction("a lot of algae"),
  FishColor by GoldColor

interface FishColor {
  val color: String
}

object GoldColor : FishColor {
  override val color: String = "gold"
}

object RedColor : FishColor {
  override val color: String = "red"
}

class PrintingFishAction (private val food: String): FishAction {
  override fun eat() {
    println("Eat $food.")
  }

}

interface FishAction {
  fun eat()
}

interface AquariumAction {
  fun eat()
  fun jump()
  fun clean()
  fun catchFish()
  fun swim() {
    println("swim")
  }
}