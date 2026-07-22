package tui.kotlin.layout

import tui.kotlin.TermManager
import tui.kotlin.Layer 

class Row(

    override val layer: Layer,

    private val termManager: TermManager = TermManager(),

) : Layout {

    override fun canvas(charCanvas: Char) {

        val (heigth, width) = termManager.getTerminalDimension()

        val canvas = charCanvas.toString().repeat(heigth.times(width))
        layer.stringLayer.insert(0, canvas)
    }

}
