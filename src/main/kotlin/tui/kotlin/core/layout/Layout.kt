package tui.kotlin.layout

import tui.kotlin.Layer

interface Layout {

    val layer: Layer

    fun canvas(charCanvas: Char)
}
