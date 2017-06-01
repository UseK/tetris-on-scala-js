package com.usek.tetris

class Board(val nHeight: Int, val nWidth: Int) {

  var grid = Array.ofDim[Boolean](nHeight, nWidth)
  var currentMino: Mino = new Mino

  def initMino(): Unit = {
    currentMino = new Mino
  }
}

object Board {
  def apply(h: Int , w: Int): Board = new Board(h , w)
}
