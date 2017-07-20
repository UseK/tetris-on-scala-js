package tetris

import org.scalajs.dom.html.Canvas
import org.scalajs.dom.{document, CanvasRenderingContext2D => Context}

trait Renderable {
  def render(r: Render): Unit
}

class Render(id: String, width: Int, height: Int) {

  val canvas = document
    .getElementById(id)
    .asInstanceOf[Canvas]
  canvas.width = width
  canvas.height = height
  val context = canvas
    .getContext("2d")
    .asInstanceOf[Context]
  val blockH = height / 20
  val blockW = width / 10

  def render(renderables: List[Renderable]): Unit = {
    context.clearRect(0, 0, width, height)
    renderables.foreach(_.render(this))
  }

  def render(mino: Mino): Unit = {
    mino.eachPositions(drawBlock(_, _))
  }

  def drawFrame(x: Int, y: Int, color:String="black"): Unit = {
    context.strokeStyle = color
    val blockX = x * blockW
    val blockY = y * blockH
    context.strokeRect(blockX, blockY, blockW, blockH)
  }

  def drawBlock(x: Int, y: Int, color:String="black"): Unit = {
    context.fillStyle = color
    val blockX = x * blockW
    val blockY = y * blockH
    context.fillRect(blockX, blockY, blockW, blockH)
  }
}

object Render {
  def apply(id: String, width: Int, height: Int): Render = {
    new Render(id, width, height)
  }
}

