case class Aiee(x: Int) {
  def aiee: String = "called aiee"
}

object Main {
  def main(args: Array[String]): Unit = {
    val aiee = Aiee(100)
    println(aiee.aiee)
  }
}