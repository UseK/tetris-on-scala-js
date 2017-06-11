package com.usek.tetris

/**
  * Created by yf on 2017/05/30.
  */
case class Position(val x: Int, val y:Int)

class Mino(val position: Position=Position(0, 0)) extends Renderable {
  val shape = List(
    List(true, false, false),
    List(true, true,  true)
  )

  def eachPositions(op: (Int, Int) => Unit) {
    for (y <- 0 until shape.length) {
      for (x <- 0 until shape(y).length) {
        if (shape(y)(x)) {
          op(x + position.x, y + position.y)
        }
      }
    }
  }

  def moved(x: Int, y:Int): Mino = {
    Mino(Position(position.x + x, position.y + y))
  }

  override def render(r: Render): Unit = {
    eachPositions(r.drawBlock(_, _))
  }
}

object Mino {
  def apply(position: Position=Position(0, 0)): Mino = {
    new Mino(position)
  }
}
