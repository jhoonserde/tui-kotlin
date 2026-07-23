package tui.kotlin.component

import tui.kotlin.TermManager
import tui.kotlin.Offset
import tui.kotlin.RawContent
import tui.kotlin.navigation.Cursor

internal class Border(

    val charHorizontal: Char,

    val charVertical: Char,

    val charTopLeft: Char,

    val charTopRight: Char,

    val charBottomLeft: Char,

    val charBottomRight: Char,
) {

    fun buildHorizontalLine(): RawContent {
        val (rows, cols) = TermManager().getTerminalDimension()

        val cursorNavToUp = Cursor()
        cursorNavToUp.apply {
            saveCursor()
            hideCursor()
            moveTo(Offset(1, 1))
        }

        val cursorNavToDown = Cursor()
        cursorNavToDown.apply {
            moveTo(Offset(rows, 1))
        }

        val cursorNavBack = Cursor()
        cursorNavBack.apply {
            restoreCursor()
            showCursor()
        }

        val horizontalLine = charHorizontal.toString().repeat(cols)

        return RawContent()
            .add(cursorNavToUp.cursorInstruc)
            .add(horizontalLine)
            .add(cursorNavToDown.cursorInstruc)
            .add(horizontalLine)
            .add(cursorNavBack.cursorInstruc)
    }

    fun buildVerticalLine() {

        val (rows, cols) = TermManager().getTerminalDimension()

        val rawContent = RawContent()

        /*for (line in rows) {
            move 
        }*/

    }

}
