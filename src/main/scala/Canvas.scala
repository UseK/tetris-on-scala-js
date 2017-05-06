package com.usek
import org.scalajs.dom
import dom.document
import dom.{CanvasRenderingContext2D => Context}
import dom.html.Canvas
import scala.scalajs.js.JSApp

class MyCanvas(id: String) {
  val canvas = document
    .getElementById(id)
    .asInstanceOf[Canvas]
  val context = canvas
    .getContext("2d")
  .asInstanceOf[Context]

  def drawRect(): Unit = {
    context.fillRect(10, 10, 100, 100)
  }
}

object MyCanvas {
  def apply(id: String): MyCanvas = new MyCanvas(id)
}

object Canvas extends JSApp {
  def main(): Unit = {
    val c = MyCanvas("stage")
    c.drawRect()
    println("I'm Canvas class")
  }
}
