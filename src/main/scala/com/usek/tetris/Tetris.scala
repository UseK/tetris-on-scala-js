import com.usek.tetris._
import scala.scalajs.js.JSApp
import scala.scalajs.js.timers.setInterval

object Tetris extends JSApp{
  def main(): Unit = {
    val initResult: (Render, Board, Mino) = init()
    val render: Render = initResult._1
    val board: Board = initResult._2
    var currentMino: Mino = initResult._3

    setInterval(1000) {
      currentMino = tick(render, currentMino, board)
    }
  }

  def init() = {
    val render = Render("stage", width = 250, height = 500)
    val board = new Board(20, 10)
    val currentMino = Mino()
    render.render(List(board, currentMino))
    (render, board, currentMino)
  }

  def tick(r: Render, m: Mino, board: Board): Mino = {
    val afterMino = board.downMino(m)
    r.render(List(board, afterMino))
    afterMino
  }
}
