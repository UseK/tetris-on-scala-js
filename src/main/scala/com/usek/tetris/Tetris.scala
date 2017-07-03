import com.usek.tetris._
import scala.scalajs.js.JSApp
import scala.scalajs.js.timers.setInterval
import org.scalajs.dom.document

object Tetris extends JSApp{
  def main(): Unit = {
    val initResult: (Render, Board, Mino) = init()
    val render: Render = initResult._1
    val board: Board = initResult._2
    var currentMino: Mino = initResult._3
    document.body.onkeydown = { e =>
      currentMino = e.keyCode match {
        case (37) => currentMino.moved(-1, 0)
        case (39) => currentMino.moved(1, 0)
        case (40) => currentMino.moved(0, 1)
        case (80) => currentMino.rotated()
        case (x) => {println(x); currentMino}
      }
      println(currentMino.position)
      render.render(List(board, currentMino))
    }

    setInterval(1000) {
      currentMino = tick(render, currentMino, board)
    }
  }

  private def init() = {
    val render = Render("stage", width = 250, height = 500)
    val board = new Board(20, 10)
    val currentMino = Mino()
    render.render(List(board, currentMino))
    (render, board, currentMino)
  }

  private def tick(r: Render, m: Mino, board: Board): Mino = {
    val afterMino = board.downMino(m)
    r.render(List(board, afterMino))
    afterMino
  }
}
