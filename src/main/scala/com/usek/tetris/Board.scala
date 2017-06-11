package com.usek.tetris
import org.scalajs.dom.{ CanvasRenderingContext2D => Context }

class Board(val nHeight: Int, val nWidth: Int) extends Renderable{

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
      m.eachPositions((x, y) =>
        grid(y)(x) = true
      )
      return Mino()
    }
    downed
  }


  var grid = Array.ofDim[Boolean](nHeight, nWidth)

  override def render(r: Render): Unit = {
    for (x <- 0 until nWidth) {
      for (y <- 0 until nHeight) {
        if (grid(y)(x)) {
          r.drawBlock(x, y, "blue")
        } else {
          r.drawFrame(x, y)
        }
      }
    }
  }
}

object Board {
  def apply(h: Int , w: Int): Board = new Board(h , w)
}
