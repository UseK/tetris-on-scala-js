/**
  * Created by yf on 2017/06/27.
  */
import com.usek.tetris.Mino
import org.scalatest.FunSuite
class MinoSuite extends  FunSuite {
  test("Mino should be rotated") {
    val mino = Mino()

    val defaultshape = List(
      List(true, false, false),
      List(true, true,  false)
    )
    assert(defaultshape == mino.shape)
    assert(1 == 2)
  }

}
