import com.junk.usek.Practice

class User(val name: String) {
  def sayHi: Unit = {
    println(s"Hai! $name")
  }
}
object User {
  def apply(name: String): User = new User(name)
}

class AdminUser(name: String, val age: Int) extends User(name) {
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
    val tom = AdminUser("tom", 23)
    println(s"${tom.name}(${tom.age})")
    tom.sayHi
    val pr = new Practice
    println(pr.cannotExpandLater)
  }
}