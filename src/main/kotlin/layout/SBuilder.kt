package layout

import ansi_escape.CursorNavigation
import ansi_escape.TextStyle
import java.awt.Color
import TermManager

open class SBuilder(

    open val stringBuilder: StringBuilder = StringBuilder(),

    private val termManager: TermManager = TermManager(),

    private val cursorNavigation: CursorNavigation = CursorNavigation
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


    fun text(
        text: String,
        italic: Boolean = false,
        bold: Boolean = false,
        underLine: Boolean = false,
        fgColor: Color = Color.WHITE,
        bgColor: Color = Color(0, 0, 0, 0),
        strikeThrough: Boolean = false
    ): SBuilder {

        val textStyle: TextStyle = TextStyle
        var stylist = textStyle.fgColor(fgColor) + textStyle.bgColor(bgColor)

        if (italic) stylist += textStyle.ITALIC
        if (bold) stylist += textStyle.BOLD
        if (underLine) stylist += textStyle.UNDERLINE
        if (strikeThrough) stylist += textStyle.STRIKETHROUGH

        stringBuilder.append(stylist + text + textStyle.RESET_STYLE)
        return this
    }


    fun spacer(distance: Int): SBuilder {
        stringBuilder.append("\n".repeat(distance))
        return this
    }
}
