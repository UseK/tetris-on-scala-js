package com.usek.tetris
import org.scalajs.dom.{ CanvasRenderingContext2D => Context }

class Board(val nHeight: Int, val nWidth: Int) extends Renderable{
  def downMino(m: Mino) = {
    val downed = Mino(Position(m.position.x, m.position.y + 1))
    downed
  }


  var grid = Array.ofDim[Boolean](nHeight, nWidth)

  override def render(r: Render): Unit = {
    for (x <- 0 to nWidth) {
      for (y <- 0 to nHeight) {
        r.drawFrame(x, y)
      }
    }
  }
}

object Board {
  def apply(h: Int , w: Int): Board = new Board(h , w)
}
