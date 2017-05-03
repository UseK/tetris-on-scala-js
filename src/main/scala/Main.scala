case class Aiee(x: Int, z: String) {
  val y: Int = x + 114514
  def aiee: String = "called aiee"
}
implicit def String2Aiee(x: String): Aiee = Aiee(100, x)

object Main {
  def main(args: Array[String]): Unit = {
    val aiee = Aiee(10, "foo")
    println(aiee.aiee)
    println(aiee.x)
    println(aiee.y)
    println("Iam String".aiee)

    aiee match {
      case Aiee(100, z) => println("hundred", z)
      case Aiee(10, z)  => println("ten", z)
    }
  }
}