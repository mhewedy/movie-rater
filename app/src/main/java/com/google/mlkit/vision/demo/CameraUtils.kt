package com.google.mlkit.vision.demo

import android.hardware.Camera

fun changeZoom(camera: Camera, value: Int) {
    val p = camera.parameters

    var zoom: Int = p?.zoom?.or(0)!!
    if (p.isZoomSupported && zoom + value > 0 && zoom + value < p.maxZoom) {
        zoom += value
        p.zoom = zoom
    }
    camera.parameters = p
}