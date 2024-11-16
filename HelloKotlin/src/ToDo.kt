fun main() {
  print("Enter your mood: ")
  val mood = readln()
  println(whatShouldIDoToday(mood))
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
  return when {
    isHappy(mood) && isSunny(weather) -> "Go for a walk."
    isSad(mood) && isRainy(weather) && isWayTooCold(temperature) -> "Stay in bed."
    isSad(mood) -> "Stay home and read."
    isWayTooHot(temperature) -> "Go swimming."
    else -> "Do whatever you like."
  }
}

fun isHappy(mood: String) = mood == "happy"
fun isSad(mood: String) = mood == "sad"
fun isSunny(weather: String) = weather == "sunny"
fun isRainy(weather: String) = weather == "rainy"
fun isWayTooHot(temperature: Int) = temperature > 30
fun isWayTooCold(temperature: Int) = temperature < 15