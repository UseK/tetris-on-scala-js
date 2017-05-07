package com.usek.tetris

class Board(val h: Int, val w: Int) {
  val grid = Array.ofDim[Int](h, w)
}

object Board {
  def apply(h: Int , w: Int): Board = new Board(h , w)
}
