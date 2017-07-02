/**
  * Created by yf on 2017/06/27.
  */
import com.usek.tetris.Mino
import org.scalatest.FunSuite
class MinoSuite extends  FunSuite {
  test("Mino should be default Mio") {
    val mino = Mino()
    val defaultshape = List(
      List(true, false, false),
      List(true, true,  true)
    )
    assert(defaultshape == mino.shape)
  }

  test("Mino sould be roted") {
    val mino = Mino()
    val rotatedshape = List(
      List(true, true, false),
      List(true, false,  false),
      List(true, false,  false)
    )
    //assert(rotatedshape == mino.rotated.shape)
  }
  test("Mino eachPositions") {
    val mino = Mino()
    var positions = List[(Int, Int)]()
    mino.eachPositions((x, y) =>
      positions = positions ::: List((x, y))
    )
    val expected = List((0, 0), (0, 1), (1, 1), (2, 1))
    assert(expected == positions)
  }
}
