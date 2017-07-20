package tetris

/**
  * Created by yf on 2017/05/30.
  */
case class Position(val x: Int, val y:Int)


class Mino(val position: Position,
           val shape: List[(Int, Int)]) {
  def rotated(): Mino = {
    val rotatedShape = this.shape.map((item) =>
      (-item._2, item._1)
    )
    new Mino(position=this.position, shape=rotatedShape)
  }


  def moved(x: Int, y:Int): Mino = {
    Mino(Position(position.x + x, position.y + y), shape)
  }

  def eachPositions(op: (Int, Int) => Unit) {
    shape.foreach((item) =>
      op(item._1 + position.x, item._2 + position.y)
    )
  }

}

object Mino {
  def apply(position: Position=Position(0, 0),
            shape: List[(Int, Int)]=List((0, 0), (0, 1), (1, 1), (2, 1))
           ): Mino = {
    new Mino(position, shape)
  }
}
