package com.usek.tetris

/**
  * Created by yf on 2017/05/30.
  */
case class Position(val x: Int, val y:Int)


class Mino(val position: Position=Position(0, 0),
           val shape: List[(Int, Int)]=List((0, 0), (0, 1), (1, 1), (2, 1))
          ) extends Renderable {

//class Mino(val position: Position=Position(0, 0)) extends Renderable {
  def rotated(): Mino = {
    val rotatedShape = this.shape.map((item) =>
      (-item._2, item._1)
    )
    new Mino(position=this.position, shape=rotatedShape)
  }


  def eachPositions(op: (Int, Int) => Unit) {
    shape.foreach((item) =>
      op(item._1 + position.x, item._2 + position.y)
    )
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
