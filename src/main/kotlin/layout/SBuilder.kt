package layout

import TermManager

open class SBuilder(

    open val stringBuilder: StringBuilder = StringBuilder(),

    private val termManager: TermManager = TermManager()
) {

    fun canvas(charCanvas: Char = ' '): SBuilder {

        val (heigth, width) = termManager.getTerminalDimension()
        
        val areaDimension = heigth.times(width)
        
        val charToString = charCanvas.toString()
        
        stringBuilder.append(charToString.repeat(areaDimension))
        return this
    }

    fun layout(type: SBuilder, content: (SBuilder) -> SBuilder): SBuilder {
        val contentStringBuilder = content(type).stringBuilder
        stringBuilder.append(contentStringBuilder)
        return this
    }

    fun text(text: String): SBuilder {
        stringBuilder.append(text)
        return this
    }

    fun spacer(distance: Int): SBuilder {
        stringBuilder.append("\n".repeat(distance))
        return this
    }
}
