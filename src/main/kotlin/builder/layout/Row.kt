package layout

import TermManager 

class Row(

    override val stringBuilder: StringBuilder = StringBuilder(),

    private val termManager: TermManager = TermManager(),

) : Layout {

    override fun canvas(charCanvas: Char) {

        val (heigth, width) = termManager.getTerminalDimension()

        val canvas = charCanvas.toString().repeat(heigth.times(width))
        stringBuilder.insert(0, canvas)
    }

}
