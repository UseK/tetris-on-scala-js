import com.junk.usek.Practice
trait TalkAble {
  def talk() = println(s"message:$message")
  def message():String
}

/* 10章 合成と継承 10.6節 パラメーターフィールド
 name is 'parametric fields' */
class User(final val name: String) extends TalkAble {
  protected val role = "normal"
  def message() = s"I am $name"

  def sayHi: Unit = {
    /* 5章 基本型と演算子 5.3節 文字列補間(string interpolation)
    s"Hai! $name" is 加工文字列リテラル(processed string literal)
    s             is 文字列補間子(string interpolator)
    文字列補間子は他にもraw, fがある */
    println(s"Hai! $name")
  }
}
object User {
  def apply(name: String): User = new User(name)
}

final class AdminUser(name: String, val age: Int) extends User(name) {
  override val role = "admin"
  override def sayHi: Unit = {
    super.sayHi
    println("I'm admin")
  }
}
object AdminUser {
  def apply(name: String, age: Int): AdminUser = new AdminUser(name, age)
}

object Main {
  def main(args: Array[String]): Unit = {
    val bob = User("bob")
    bob.talk
  }

  private def junk = {
    val bob = User("bob")
    //bob.role //inaccessible
    val tom = AdminUser("tom", 23)
    println(s"${tom.name}(${tom.age})")
    tom.sayHi
    println(tom.role) // accessibility override
    val pr = new Practice
    println(pr.cannotExpandLater)
  }
}