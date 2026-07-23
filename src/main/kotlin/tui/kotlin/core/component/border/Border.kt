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

    constructor(charLine: Char = '#') : this(

        charHorizontal = charLine,

        charVertical = charLine,

        charTopLeft = charLine,

        charTopRight = charLine,

        charBottomLeft = charLine,

        charBottomRight = charLine,
    )

    constructor() : this(

        charHorizontal = '#',

        charVertical = '#',

        charTopLeft = '#',

        charTopRight = '#',

        charBottomLeft = '#',

        charBottomRight = '#',
    )

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

        val horizontalLine = charTopLeft + charHorizontal.toString().repeat(cols - 2) + charTopLeft

        return RawContent()
            .add(cursorNavToUp.cursorInstruc)
            .add(horizontalLine)
            .add(cursorNavToDown.cursorInstruc)
            .add(horizontalLine)
            .add(cursorNavBack.cursorInstruc)
    }

    fun buildVerticalLine() {

    }

}
