package com.usek.tetris

import org.scalajs.dom
import dom.document
import dom.{CanvasRenderingContext2D => Context}
import dom.html.Canvas
import scala.scalajs.js.JSApp
import scala.scalajs.js.timers.setTimeout

class Render(id: String) {
  val canvas = document
    .getElementById(id)
    .asInstanceOf[Canvas]
  val context = canvas
    .getContext("2d")
    .asInstanceOf[Context]
  val board = Board(h=20, w=10)
  val blockH = 400 / board.h
  val blockW = 200 / board.w

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
    println(blockX, blockY)
    context.strokeRect(blockX, blockY, blockW, blockH)
  }

  def drawBlock(x: Int, y: Int): Unit = {
    val blockX = x * blockW
    val blockY = y * blockH
    println(blockX, blockY)
    context.fillRect(blockX, blockY, blockW, blockH)
  }
}

object Render {
  def apply(id: String): Render = new Render(id)
}

