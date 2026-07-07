package layout

import ansi_escape.CursorNav
import ansi_escape.TextStyle
import java.awt.Color
import Position
import TermManager

open class SBuilder(

    open val stringBuilder: StringBuilder = StringBuilder(),

    private val termManager: TermManager = TermManager(),

    private val cursorNav: CursorNav = CursorNav()
) {


    fun canvas(charCanvas: Char = ' ') {

        val (heigth, width) = termManager.getTerminalDimension()

        val areaDimension = heigth.times(width)

        val charToString = charCanvas.toString()

        stringBuilder.insert(0, charToString.repeat(areaDimension))
    }


    fun layout(type: SBuilder, content: (SBuilder) -> SBuilder) {
        
        val contentStringBuilder = content(type).stringBuilder
        stringBuilder.append(contentStringBuilder)
    }


    fun text(
        text: String,
        position: Position,
        italic: Boolean = false,
        bold: Boolean = false,
        underLine: Boolean = false,
        fgColor: Color = Color.WHITE,
        bgColor: Color = Color(0, 0, 0, 0),
        strikeThrough: Boolean = false
    ) {

        val navCursorToLine: CursorNav = CursorNav()
        navCursorToLine.apply {
            saveCursor()
            hideCursor()
            moveTo(position)
        }

        val navCursorBack: CursorNav = CursorNav()
        navCursorBack.apply {
            restoreCursor()
            showCursor()
        }

        val textStyle: TextStyle = TextStyle()
        textStyle.apply {
            fgColor(fgColor)
            bgColor(bgColor)
            if (italic) italic()
            if (bold) bold()
            if (underLine) underLine()
            if (strikeThrough) strikeThrough()
        }

        stringBuilder.append(
            navCursorToLine.cursorInstruc +
            (textStyle.stylish + text) +
            navCursorBack.cursorInstruc
        )
    }
}
