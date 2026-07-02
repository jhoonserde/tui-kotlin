package ansi_escape

object CursorNavigation {
    
    private const val ESC = "\u001B["

    val SAVE_CURSOR = "${ESC}s"
        
    val REQUEST_CURSOR = "${ESC}6n"

    val RESTORE_CURSOR = "${ESC}u"

    val HIDE_CURSOR  = "${ESC}?25l"

    val SHOW_CURSOR  = "${ESC}?25h"
    
    val CLEAR = "${ESC}2J"

    fun moveTo(row: Int, col: Int) = "${ESC}${row}${col}H"
}
