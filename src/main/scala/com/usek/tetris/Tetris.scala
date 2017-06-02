import com.usek.tetris._

import scala.scalajs.js.JSApp
import scala.scalajs.js.timers.setTimeout
import scala.scalajs.js.timers.setInterval

object Tetris extends JSApp{
  def main(): Unit = {
    val r = Render("stage", width = 250, height = 500)
    val board = new Board(20, 10)
    var currentMino = Mino()
    r.render(List(board, currentMino))
    setInterval(1000) {
      currentMino = tick(r, currentMino, board)
    }
  }
  def tick(r: Render, m: Mino, board: Board): Mino = {
    val afterMino = board.downMino(m)
    r.render(List(board, afterMino))
    afterMino
  }
}
