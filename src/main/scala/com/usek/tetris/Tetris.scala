import com.usek.tetris.Render

import scala.scalajs.js.JSApp

object Tetris extends JSApp{
  def main(): Unit = {
    val c = Render("stage", width = 250, height = 500)
    c.drawBoard
    println("I'm Tetris class aiee")
  }
}
