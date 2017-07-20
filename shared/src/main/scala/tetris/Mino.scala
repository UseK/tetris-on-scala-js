package tetris

/**
  * Created by yf on 2017/05/30.
  */
case class Position(val x: Int, val y:Int)


class Mino(val position: Position,
           val shape: List[(Int, Int)])
  extends Blockable {
  def rotated(): Mino = {
    val rotatedShape = this.shape.map((item) =>
      (-item._2, item._1)
    )
    new Mino(position=this.position, shape=rotatedShape)
  }


  def moved(x: Int, y:Int): Mino = {
    Mino(Position(position.x + x, position.y + y), shape)
  }

  override def eachBlocks(op: Block => Unit) {
    shape.foreach { (item) =>
      val x = item._1 + position.x
      val y = item._2 + position.y
      op(Block(x, y, Some("black")))
    }
  }

  def eachPositions(op: (Int, Int) => Unit): Unit = {
    shape.foreach { (item) =>
      val x = item._1 + position.x
      val y = item._2 + position.y
      op(x, y)
    }
  }
}

object Mino {
  def apply(position: Position=Position(0, 0),
            shape: List[(Int, Int)]=List((0, 0), (0, 1), (1, 1), (2, 1))
           ): Mino = {
    new Mino(position, shape)
  }
}
