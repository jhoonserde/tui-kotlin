package layout

import tui.kotlin.TermManager
import tui.kotlin.Offset
import tui.kotlin.navigation.Cursor

class Border(

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

    fun buildHorizontalLine(): String {
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

        return cursorNavToUp.cursorInstruc + 
        horizontalLine + cursorNavToDown.cursorInstruc +
        horizontalLine + cursorNavBack.cursorInstruc

    }

    fun buildVerticalLine() {

    }

}
