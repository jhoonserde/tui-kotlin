package tui.kotlin.component

import tui.kotlin.navigation.Cursor
import tui.kotlin.component.TextStyle
import java.awt.Color
import tui.kotlin.Offset
import tui.kotlin.TermManager
import tui.kotlin.RawContent

internal class Text(

    val textString: String,

    val offset: Offset,

    val italic: Boolean,

    val bold: Boolean,

    val underLine: Boolean,

    val fgColor: Color,

    val bgColor: Color,

    val strikeThrough: Boolean
) {


    fun buildText(): RawContent {

        val navCursorToLine: Cursor = Cursor()
        navCursorToLine.apply {
            saveCursor()
            hideCursor()
            moveTo(offset)
        }

        val navCursorBack: Cursor = Cursor()
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

        return RawContent().apply {
            add(navCursorToLine.cursorInstruc)
            add(textStyle.stylish + textString)
            add(navCursorBack.cursorInstruc)
        }
    }
}
