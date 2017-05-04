/**
  * Created by yf on 2017/05/04.
  */
trait I extends God{
  abstract override def message(m: String): String = {
    super.message(m + " I")
  }
}

trait My extends God{
  abstract override def message(m: String): String = {
    super.message(m + " My")
  }
}

trait Me extends God{
  abstract override def message(m: String): String = {
    super.message(m + " Me")
  }
}

class Yeah extends God{
  def message(m: String): String = m + " Yeah"
}

abstract class God {
  def message(m:String): String
}

trait TalkAble {
  def talk() = println(s"message:$message")
  def message():String
}
