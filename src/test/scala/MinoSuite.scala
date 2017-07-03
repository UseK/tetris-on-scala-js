/**
  * Created by yf on 2017/06/27.
  */
import com.usek.tetris.Mino
import org.scalatest.FunSuite
class MinoSuite extends  FunSuite {
  test("Mino eachPositions") {
    val mino = Mino()
    var positions = List[(Int, Int)]()
    mino.eachPositions((x, y) =>
      positions = positions ::: List((x, y))
    )
    val expected = List((0, 0), (0, 1), (1, 1), (2, 1))
    assert(expected == positions)
  }

  test("Mino rotated") {
    val mino = Mino()
    val rotatedMino = mino.rotated()
    val expected = List((0,0), (-1,0), (-1,1), (-1,2))

    assert(expected == rotatedMino.shape)
  }
}
