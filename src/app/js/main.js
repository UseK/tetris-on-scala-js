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
    this.car = new Car(10, 10)
  }

  animation() {
    this.context.clearRect(0, 0, this.context.width, this.context.height)
    this.car.animation(this.context)
    setTimeout(function() {
      this.animation()
    }.bind(this), 10)
  }
}

class Car {
  constructor(x, y) {
    this.x = x
    this.y = y
  }

  animation(context) {
    context.fillRect(this.x, this.y, 100, 60)
    this.x += 1
    if (this.x > context.width) {
      this.x = 0
    }
  }
}
(function() {
  const my_canvas = new MyCanvas('stage')
  my_canvas.animation()
})()