package com.usek.tetris

import org.scalajs.dom
import dom.document
import dom.{CanvasRenderingContext2D => Context}
import dom.html.Canvas
import scala.scalajs.js.JSApp
import scala.scalajs.js.timers.setTimeout

class Render(id: String, width: Int, height: Int) {
  val canvas = document
    .getElementById(id)
    .asInstanceOf[Canvas]
  val context = canvas
    .getContext("2d")
    .asInstanceOf[Context]
  canvas.width = width
  canvas.height = height
  val board = Board(h=20, w=10)
  val blockH = height / board.h
  val blockW = width / board.w

  def drawBoard(): Unit = {
    for (x <- 0 to board.w) {
      for (y <- 0 to board.h) {
        drawFrame(x, y)
      }
    }
  }

  def drawFrame(x: Int, y: Int): Unit = {
    val blockX = x * blockW
    val blockY = y * blockH
    context.strokeRect(blockX, blockY, blockW, blockH)
  }

  def drawBlock(x: Int, y: Int): Unit = {
    val blockX = x * blockW
    val blockY = y * blockH
    context.fillRect(blockX, blockY, blockW, blockH)
  }
}

object Render {
  def apply(id: String, width: Int, height: Int): Render = new Render(id, width, height)
}

