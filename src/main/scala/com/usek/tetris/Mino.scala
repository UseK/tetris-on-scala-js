package com.usek.tetris

/**
  * Created by yf on 2017/05/30.
  */
case class Position(x: Int, y:Int)

class Mino {
  val shape = List(
    List(true, false, false),
    List(true, true,  true)
  )
  val position = Position(0, 0)

  def eachPositions(op: (Int, Int) => Unit) {
    for (y <- 0 until shape.length) {
      for (x <- 0 until shape(y).length) {
        if (shape(y)(x)) {
          op(x, y)
        }
      }
    }
  }
}
