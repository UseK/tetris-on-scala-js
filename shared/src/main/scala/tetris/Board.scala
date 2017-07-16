package tetris

class Board(val nHeight: Int, val nWidth: Int) {

  protected val grid = Array.ofDim[Boolean](nHeight, nWidth)
  protected val filledBlocks = Set()

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
    grid.foreach((line) =>
      if (isLineComplete(line)) {
        for (i <- 0 until line.length) {
          line(i) = false
        }
      }
    )
  }

  def isLineComplete(line: Array[Boolean]): Boolean = {
    line.forall((b) => b == true)
  }
}

object Board {
  def apply(h: Int , w: Int): Board = new Board(h , w)
}
