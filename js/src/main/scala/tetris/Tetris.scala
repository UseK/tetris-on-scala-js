package tetris

import org.scalajs.dom.document

import scala.scalajs.js.JSApp
import scala.scalajs.js.timers.setInterval

object Tetris extends JSApp{
  def main(): Unit = {
    val initResult: (Render, BoardJS, Mino) = init()
    val render: Render = initResult._1
    val board: BoardJS = initResult._2
    var currentMino: Mino = initResult._3
    document.body.onkeydown = { e =>
      currentMino = e.keyCode match {
        case (37) => currentMino.moved(-1, 0)
        case (39) => currentMino.moved(1, 0)
        case (40) => currentMino.moved(0, 1)
        case (80) => currentMino.rotated()
        case (x) => {println(x); currentMino}
      }
      render.render(List(board, currentMino))
    }

    setInterval(1000) {
      currentMino = tick(render, currentMino, board)
    }
  }

  private def init() = {
    val render = Render("stage", width = 250, height = 500)
    val board = new BoardJS(20, 10)
    val currentMino = Mino()
    render.render(List(board, currentMino))
    (render, board, currentMino)
  }

  private def tick(r: Render, m: Mino,
                   board: BoardJS): Mino = {
    val afterMino = board.downMino(m)
    r.render(List(board, afterMino))
    afterMino
  }
}
