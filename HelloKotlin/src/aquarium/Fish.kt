package aquarium

class Fish (val isFriendly: Boolean = true, volumeNeeded: Int) {
  init {
    println("First init block.")
  }

  constructor() : this(true, 9) {
    println("Running secondary constructor.")
  }

  val size: Int
    init {
      size = if (isFriendly) volumeNeeded else volumeNeeded * 2
    }

  init {
    println("Constructed fish of size $volumeNeeded, final size $size.")
  }

  init {
    println("Last init block.")
  }
}

fun makeDefaultFish() = Fish(true, 10) // Prefer this instead of adding constructors.