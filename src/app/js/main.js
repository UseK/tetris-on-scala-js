"use strict"
class MyCanvas {
  constructor(id) {
    const canvas = document.getElementById(id)
    if (typeof canvas.getContext === 'undefined') {
      return
    }
    this.context = canvas.getContext('2d')
    this.context.width = 480
    this.context.height = 260
    this.x = 10
    this.y = 10
  }
  drawRect() {
    this.context.strokeRect(100, 20, 100, 60)
    console.log(this.context.height)
    this.context.fillRect(110, 30, 100, 60)
  }

  animation() {
    this.context.clearRect(0, 0, this.context.width, this.context.height)
    this.context.fillRect(this.x, this.y, 100, 60)
    this.x += 1
    if (this.x > this.context.width) {
      this.x = 0
    }
    setTimeout(function() {
      this.animation()
    }.bind(this), 10)
  }
}
(function() {
  const my_canvas = new MyCanvas('stage')
  my_canvas.animation()
})()