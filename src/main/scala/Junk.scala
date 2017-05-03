case class Aiee(x: Int, z: String) {
  val y: Int = x + 114514
  def aiee: String = "called aiee"
}

class Practice {
  def cannotExpandLater: String = {
    var s = "before"
    val expanded = s"($s)"
    s = "after"
    expanded //=> "(before)"
  }
  def doubleLoop: IndexedSeq[String] = {
    for (i <- 0 to 3; j <- 0 to 3; if i != j) yield s"$i-$j"
  }

  def declareAiee(x: Int): Unit = {
    //noinspection LanguageFeature
    implicit def String2Aiee(x: String): Aiee = Aiee(100, x)
    val aiee = Aiee(x, "foo")
    println(aiee.aiee)
    println(aiee.x)
    println(aiee.y)
    println("Iam String".aiee)
  }

  def expandString(aiee: Aiee = Aiee(-1, "orz")): Unit = {
    val result = aiee match {
      case Aiee(100, z) => s"hundred: $z}"
      case Aiee(10, z) => f"ten: ${10}%010d $z%-10s"
      case _ => "case default..orz"
    }
    println(result)
  }
}
/**
  * Created by yf on 2017/05/03.
  */
class Junk {

}
