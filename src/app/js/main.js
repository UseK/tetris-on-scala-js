/**
 * Created by yf on 2017/05/05.
 */
(function() {
    'use strict'
    let stage = document.getElementById('stage')
    if (typeof stage.getContext === 'undefined') {
        return
    }
    let context = stage.getContext('2d')
    context.width = 480
    context.height = 260
    context.strokeRect(100, 20, 100, 60)
    console.log(context.height)
    context.fillRect(110, 30, 100, 60)
})()