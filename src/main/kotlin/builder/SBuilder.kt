package layout

import ansi_escape.CursorNav
import ansi_escape.TextStyle
import java.awt.Color
import types.Offset
import TermManager
import builder.component.Text

class SBuilder(

    override val stringBuilder: StringBuilder = StringBuilder(),

    private val termManager: TermManager = TermManager(),

    private val cursorNav: CursorNav = CursorNav()

) : Layout {


    override fun canvas(charCanvas: Char) {

        val (heigth, width) = termManager.getTerminalDimension()

        val canvas = charCanvas.toString().repeat(heigth.times(width))
        stringBuilder.insert(0, canvas)
    }


    fun layout(type: SBuilder, content: (SBuilder) -> SBuilder) {
        
        val contentStringBuilder = content(type).stringBuilder
        stringBuilder.append(contentStringBuilder)
    }


    fun text(
        textString: String,
        offset: Offset,
        italic: Boolean = false,
        bold: Boolean = false,
        underLine: Boolean = false,
        fgColor: Color = Color.WHITE,
        bgColor: Color = Color(0, 0, 0, 0),
        strikeThrough: Boolean = false
    ) {
        val text = Text(
            textString = textString,
            offset = offset,
            italic = italic,
            bold = bold,
            underLine = underLine,
            fgColor = fgColor,
            bgColor = bgColor,
            strikeThrough = strikeThrough
        )
        stringBuilder.append(text.buildText())
    }
}
