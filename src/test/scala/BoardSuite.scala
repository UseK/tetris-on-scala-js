import com.usek.tetris.{Board, Mino, Position}
import org.scalatest.FunSuite
class BoardSuite extends FunSuite {
  test("Mino on border should be over") {
    val board = new Board(20, 10)
    val minoOnBorder = Mino(Position(10, 20))
    assert(board.over(minoOnBorder))
  }

  test("Board.downMino") {
    val board = new Board(20, 10)
    var mino = Mino()
    for (i <- 0 to 30) {
      mino = board.downMino(mino)
    }
  }
}
