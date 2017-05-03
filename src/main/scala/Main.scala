class User(_name: String) {
  val name = _name
  def sayHi: Unit = {
    println(s"Hai! $name")
  }
}

class AdminUser(name: String, age: Int) extends User(name) {
  override def sayHi: Unit = {
    super.sayHi
    println("I'm admin")
  }

}

object User {
  def apply(_name: String): User = new User(_name)
}

object AdminUser {
  def apply(name: String, age: Int): AdminUser = new AdminUser(name, age)
}

object Main {
  def main(args: Array[String]): Unit = {
    val tom = AdminUser("tom", 23)
    println(tom.name)
    tom.sayHi
  }
}