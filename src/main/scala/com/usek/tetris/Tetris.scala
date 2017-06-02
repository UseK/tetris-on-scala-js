import com.usek.tetris._

import scala.scalajs.js.JSApp
import scala.scalajs.js.timers.setTimeout
import scala.scalajs.js.timers.setInterval

object Tetris extends JSApp{
  def main(): Unit = {
    val r = Render("stage", width = 250, height = 500)
    val board = new Board(20, 10)
    val currentMino = new Mino
    val rendaerables = List(board, currentMino)
    r.render(rendaerables)
    setInterval(1000) {
      tick(r, currentMino, rendaerables)
    }
  }
  def tick(r: Render, m: Mino, rendderables: List[Renderable]): Unit = {
    m.position.y += 1
    r.render(rendderables)
  }
}
