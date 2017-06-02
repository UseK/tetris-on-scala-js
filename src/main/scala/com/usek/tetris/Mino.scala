package com.usek.tetris

/**
  * Created by yf on 2017/05/30.
  */
case class Position(var x: Int, var y:Int)

class Mino extends Renderable {
  val shape = List(
    List(true, false, false),
    List(true, true,  true)
  )
  val position = Position(0, 0)

  def eachPositions(op: (Int, Int) => Unit) {
    for (y <- 0 until shape.length) {
      for (x <- 0 until shape(y).length) {
        if (shape(y)(x)) {
          op(x + position.x, y + position.y)
        }
      }
    }
  }

  override def render(r: Render): Unit = {
    eachPositions(r.drawBlock(_, _))
  }
}
