package com.usek.tetris

class Board(val h: Int, val w: Int) {
  var grid = Array.ofDim[String](h, w)
  grid.map(Array.fill("blue"))
  println(grid.deep)
}

object Board {
  def apply(h: Int , w: Int): Board = new Board(h , w)
}
