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
  }
  drawRect() {
    this.context.strokeRect(100, 20, 100, 60)
    console.log(this.context.height)
    this.context.fillRect(110, 30, 100, 60)
  }
}
(function() {
  const my_canvas = new MyCanvas('stage')
  my_canvas.drawRect()
})()