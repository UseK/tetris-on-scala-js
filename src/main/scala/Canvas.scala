package com.usek
import org.scalajs.dom
import dom.document
import dom.{CanvasRenderingContext2D => Context}
import dom.html.Canvas
import scala.scalajs.js.JSApp
import scala.scalajs.js.timers.setTimeout

class MyCanvas(id: String) {
  val canvas = document
    .getElementById(id)
    .asInstanceOf[Canvas]
  val context = canvas
    .getContext("2d")
  .asInstanceOf[Context]

  val car = new Car(10, 10)

  def drawRect(): Unit = {
    context.fillRect(10, 10, 100, 100)
  }

  def animation(counter: Int): Unit = {
    if (counter > 0) {
      car.animation(context)
      setTimeout(10) {
        animation(counter-1)
      }
    }
  }
}

class Car(var x: Double, val y: Double) {
  def animation(context: Context): Unit = {
    context.fillRect(x, y, 100, 60)
    x += 1
    if (x > 480) {
      x = 0
    }
  }
}

object MyCanvas {
  def apply(id: String): MyCanvas = new MyCanvas(id)
}

