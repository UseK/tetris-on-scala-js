package tetris

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

  test("Board.disapperLine") {
    val board = new Board(20, 10)

    def dropMino(x: Int, shape: Option[List[(Int, Int)]]) = {
      var mino = shape match {
        case Some(s) => {Mino(Position(x, 0), s)}
        case None => {Mino(Position(x, 0))}
      }
      for (i <- 0 to 19) {
        mino = board.downMino(mino)
      }
    }
    dropMino(0, None)
    dropMino(3, None)
    dropMino(6, None)
    dropMino(9, Some(List((0, 0), (0, 1))))
    val bottomLine = Array(
      true, false, false,
      true, false, false,
      true, false, false,
      true
    )
    val actualBottom = board.grid.reverse.head
    println("---------------")
    println(actualBottom.deep)
    println(board.grid.length)
    println("---------------")
    assert(actualBottom.sameElements(bottomLine))
  }
}
