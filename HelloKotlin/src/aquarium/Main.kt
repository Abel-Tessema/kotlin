package aquarium

fun main() {
//  buildAquarium()
//  fishExample()
//  val fish = makeDefaultFish()
  makeFish()
}

fun feedFish(fish: FishAction) {
  fish.eat()
}

fun makeFish() {
//  val shark = Shark()
  val plecostomus = Plecostomus()

//  println("Shark: ${shark.color}")
  println("Plecostomus: ${plecostomus.color}")

//  shark.eat()
  plecostomus.eat()
}

fun fishExample() {
  val fish = Fish(true, 20)
  println("Is the fish friendly? ${fish.isFriendly}.")
  println("It needs a volume of ${fish.size} cm3.")
}

fun buildAquarium() {
  val myAquarium = Aquarium()
  println("Length: ${myAquarium.length}")
  println("Width: ${myAquarium.width}")
  println("Height: ${myAquarium.height}")

  val aquarium2 = Aquarium(20, 15, 30)

  val aquarium3 = Aquarium(numberOfFish = 3)
}
