import java.lang.Math.random
import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(args: Array<String>) {
//    var numbers = listOf(null, null)
//    var nombres: List<Int?>? = null
//    var number: Int? = null
//
//    number = number?.inc() ?: 0
//    val array = Array(5) { it * 2}
//    println(array.asList())
//    for ((index, value) in array.withIndex()) {
//        println("$index: $value")
//    }
//
//    for (i in 5 downTo 0) {
//        print("$i ")
//    }
//    println()
//
//    for (i in 1..5 step 2) {
//        print("$i ")
//    }

//    val array: MutableList<Int> = mutableListOf()
//    for (i in 11..15) {
//        array.add(i)
//    }
//    print(array)
//    dayOfWeek()

//    val hour = args[0].toInt()
//    if (hour < 12) println("Good morning, Kotlin.")
//    else println("Good night, Kotlin.")

//    println("Good ${if (args[0].toInt() < 12) "morning" else "night"}, Kotlin.")

//  feedTheFish()
//    for (i in 1..10) {
//        val fortune = getFortuneCookie()
//        println("Your fortune is: $fortune")
//        if (fortune == "Take it easy and enjoy life!") return
//    }
//  feedTheFish()

//  var fortune: String
//  for (i in 1..10) {
//    fortune = getFortuneCookie(getBirthday())
//    println("Your fortune is: $fortune\n")
//    if (fortune.contains("Take it easy")) break
//  }

//  if (shouldChangeWater("Monday"))
//    println("You should change the water.")

//  println(canAddFish(10, listOf(3, 3, 3)))
//  println(canAddFish(8, listOf(2, 2, 2), hasDecorations = false))
//  println(canAddFish(9, listOf(1, 1, 3), 3))
//  println(canAddFish(10, listOf(), 7))

//  feedTheFish()

//  var fortune: String
//  repeat(10) {
//    fortune = getFortuneCookie(getBirthday())
//    println("Your fortune is: $fortune\n")
//    if (fortune.contains("Take it easy")) break
//  }

//  var fortune = ""
//  while (!fortune.contains("Take it easy")) {
//    fortune = getFortuneCookie(getBirthday())
//    println("Your fortune is: $fortune\n")
//  }

//  val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")
//  val sortedSpices = spices.sortedBy { spice -> spice.length }
//  println(sortedSpices)
//
//  val filteredSpices1 = spices.filter { spice -> spice.startsWith('c') and spice.endsWith('e') }
////  val x = spices.filter { it.startsWith('c') && it.endsWith('e') }
//  println(filteredSpices1)
//
//  val filteredSpices2 = spices.filter { spice -> (spice[0] == 'c') && (spice[spice.length - 1] == 'e')}
//  println(filteredSpices2)
//
//  val filteredList3 = spices.subList(0, 3).filter { spice -> spice.startsWith('c') }
//  println(filteredList3)

  gamePlay(rollDice2(3))
  gamePlay(rollDice(2))
}

val rollDice: (Int) -> Int = { sides ->
  if (sides == 0) 0
  else (random() * 12).toInt() + 1
}

fun rollDice2(sides: Int): Int {
  if (sides == 0) return 0
  return (random() * 12).toInt() + 1
}

fun gamePlay(roll: Int) = println(roll)

var dirtiness = 20
val waterFilter: (Int) -> Int = {dirtiness -> dirtiness / 2}
fun feedFish(dirtiness: Int) = dirtiness + 10
fun updateDirty(dirtiness: Int, operation: (Int) -> Int) = operation(dirtiness)
fun dirtyProcessor() {
  dirtiness = updateDirty(dirtiness, waterFilter)
  dirtiness = updateDirty(dirtiness, ::feedFish)
  dirtiness = updateDirty(dirtiness) { dirtiness -> dirtiness + 50 }
}

fun canAddFish(tankSize: Int, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
  val totalFishSize =
    if (currentFish.isNotEmpty()) currentFish.reduce { acc, i -> acc + i } // or currentFish.sum()
    else 0
  if (hasDecorations && (0.8 * tankSize < totalFishSize + fishSize)) {
    return false
  } else if (tankSize < totalFishSize + fishSize) {
    return false
  }
  return true
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirtiness: Int = getDirtySensorReading()): Boolean {
  val isTooHot = isTooHot(temperature)
  val isDirty = isDirty(dirtiness)
  val isSunday = isSunday(day)

  return when {
    isTooHot -> true
    isDirty -> true
    isSunday -> true
    else -> false
  }
}

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirtiness: Int) = dirtiness > 30
fun isSunday(day: String) = day == "Sunday"
fun getDirtySensorReading() = 20

fun getFortuneCookie(birthday: Int): String {
  val fortunes = listOf(
    "You will have a great day!",
    "Things will go well for you today.",
    "Enjoy a wonderful day of success.",
    "Be humble and all will turn out well.",
    "Today is a good day to exercise restraint.",
    "Take it easy and enjoy life!",
    "Treasure your friends because they are your greatest fortune."
  )
  when (birthday) {
    28 or 31 -> return fortunes[0]
    in 1..3 -> return fortunes[1]
    else -> {
      val index = birthday.rem(fortunes.size)
      return fortunes[index]
    }
  }
}

fun getBirthday(): Int {
  print("Enter your birthday: ")
  val birthday = readln().toIntOrNull()
  return birthday ?: 1
}

fun feedTheFish() {
  val day = randomDay()
  val food = fishFood(day)
  println("Today is $day and the fish eat $food.")

  if (shouldChangeWater(day, 35))
    println("Change the water today, boi.")

  dirtyProcessor()
}

fun fishFood(day: String): String {
  return when (day) {
    "Monday" -> "flakes"
    "Tuesday" -> "pellets"
    "Wednesday" -> "redworms"
    "Thursday" -> "granules"
    "Friday" -> "mosquitoes"
    "Saturday" -> "plankton"
    "Sunday" -> "lettuce"
    else -> "fasting"
  }
}

fun randomDay(): String {
  val daysOfTheWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
  return daysOfTheWeek[Random().nextInt(daysOfTheWeek.size)]
}

fun dayOfWeek() {
  println("What day is it today?")
  when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
    Calendar.MONDAY -> println("It's Monday.")
    Calendar.TUESDAY -> println("It's Tuesday.")
    Calendar.WEDNESDAY -> println("It's Wednesday.")
    Calendar.THURSDAY -> println("It's Thursday.")
    Calendar.FRIDAY -> println("It's Friday.")
    Calendar.SATURDAY -> println("It's Saturday.")
    Calendar.SUNDAY -> println("It's Sunday.")
  }
}
