import com.usek.tetris.{Mino, Position, Render}

import scala.scalajs.js.JSApp

object Tetris extends JSApp{
  def main(): Unit = {
    val c = Render("stage", width = 250, height = 500)
    c.draw()
    tick(c)
    println("I'm Tetris class aiee")
  }
  def tick(c: Render): Unit = {
    c.board.currentMino.position.y += 1
    c.draw()
  }
}
