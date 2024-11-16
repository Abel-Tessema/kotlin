package practice

open class Book (val name: String, val author: String) {
  private var currentPage: Int = 0
  open fun readPage() {currentPage++}
}

class eBook (name: String, author: String, val format: String = "text"): Book(name, author) {
  private var wordCount: Int = 0
  override fun readPage() {wordCount += 250}
}