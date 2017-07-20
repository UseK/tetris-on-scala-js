package tetris

/**
  * Created by yf on 2017/07/20.
  */
case class Block(val x: Int, val y: Int, val color: Option[String])

trait Blockable {
  def eachBlocks(op: Block => Unit): Unit
}
