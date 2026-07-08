package builder

import layout.SBuilder
import ansi_escape.CursorNav
import ansi_escape.TextStyle
import java.awt.Color
import Position
import TermManager
import builder.components.Text

class Builder(

    private val termManager: TermManager = TermManager(),

    private val cursorNav: CursorNav = CursorNav()

) {


    fun buildCanvas(charCanvas: Char = ' '): String {

        val (heigth, width) = termManager.getTerminalDimension()

        val charToString = charCanvas.toString()

        return charToString.repeat(heigth.times(width))
    }


    fun buildText(text: Text): String {

        val navCursorToLine: CursorNav = CursorNav()
        navCursorToLine.apply {
            saveCursor()
            hideCursor()
            moveTo(text.position)
        }

        val navCursorBack: CursorNav = CursorNav()
        navCursorBack.apply {
            restoreCursor()
            showCursor()
        }

        val textStyle: TextStyle = TextStyle()
        textStyle.apply {
            fgColor(text.fgColor)
            bgColor(text.bgColor)
            if (text.italic) italic()
            if (text.bold) bold()
            if (text.underLine) underLine()
            if (text.strikeThrough) strikeThrough()
        }

        return navCursorToLine.cursorInstruc +
            (textStyle.stylish + text.textString) +
            navCursorBack.cursorInstruc
    }
}
