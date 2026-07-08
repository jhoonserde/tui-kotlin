package builder.component

import ansi_escape.CursorNav
import ansi_escape.TextStyle
import java.awt.Color
import types.Offset
import TermManager

class Text(

    val textString: String,

    val offset: Offset,

    val italic: Boolean = false,

    val bold: Boolean = false,

    val underLine: Boolean = false,

    val fgColor: Color = Color.WHITE,

    val bgColor: Color = Color(0, 0, 0, 0),

    val strikeThrough: Boolean = false
) {


    fun buildText(): String {

        val navCursorToLine: CursorNav = CursorNav()
        navCursorToLine.apply {
            saveCursor()
            hideCursor()
            moveTo(offset)
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

        return navCursorToLine.cursorInstruc +
            (textStyle.stylish + textString) +
            navCursorBack.cursorInstruc
    }
}
