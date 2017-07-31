package tetris

class Board(val nHeight: Int, val nWidth: Int) extends Blockable {

  var grid = Array.ofDim[Boolean](nHeight, nWidth)
  protected val filledBlocks = Set()

  def showState(): Unit = {
    def boolean2Int(b: Boolean): Int = if (b) 1 else 0
    grid.foreach { (line) =>
      line.map(boolean2Int(_)).foreach(print)
      println
    }
  }

  def over(downed: Mino): Boolean = {
    downed.eachPositions((x, y) =>
      if (y >= nHeight || grid(y)(x)) {
        return true
      }
    )
    false
  }

  def downMino(m: Mino): Mino = {
    val downed = m.moved(0, 1)
    if (over(downed)) {
      m.eachPositions((x, y) => grid(y)(x) = true)
      disappearLine()
      Mino()
    } else {
      downed
    }
  }

  def disappearLine(): Unit = {
    val disappered = grid.filterNot(isLineComplete(_))
    val forFill = Array.ofDim[Boolean](nHeight - disappered.length, nWidth)
    grid = Array.concat(forFill, disappered)
  }

  def isLineComplete(line: Array[Boolean]): Boolean = {
    line.forall((b) => b == true)
  }

  override def eachBlocks(op: (Block) => Unit) {
    for (y <- 0 until nHeight) {
      for (x <- 0 until nWidth) {
        if (grid(y)(x)) {
          op(Block(x, y, Some("blue")))
        } else {
          op(Block(x, y, None))
        }
      }
    }
  }
}

object Board {
  def apply(h: Int , w: Int): Board = new Board(h , w)
}
