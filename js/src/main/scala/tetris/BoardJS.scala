package tetris

/**
  * Created by yf on 2017/07/16.
  */
class BoardJS(override val nHeight: Int,
              override val nWidth: Int)
  extends Board(nHeight, nWidth) with Renderable {

  override def render(r: Render): Unit = {
    for (x <- 0 until nWidth) {
      for (y <- 0 until nHeight) {
        if (grid(y)(x)) {
          r.drawBlock(x, y, "blue")
        } else {
          r.drawFrame(x, y)
        }
      }
    }
  }

}

