import kotlin.math.E

object AnsiEscapeCode {

    private const val ESC = "\u001B["

    object Cursor {
    
        val SAVE_CURSOR = "${ESC}s"
    
        val REQUEST_CURSOR = "${ESC}6n"

        val RESTORE_CURSOR = "${ESC}u"

        val HIDE_CURSOR  = "${ESC}?25l"

        val SHOW_CURSOR  = "${ESC}?25h"
    
        val CLEAR = "${ESC}2J"

        fun moveTo(row: Int, col: Int) = "${ESC}${row}${col}H"

    }

    object TextStyle {

        val RESET_STYLE = "${ESC}0m"

        val BOLD = "${ESC}1m"
        
        val ITALIC = "${ESC}3m"
        
        val UNDERLINE = "${ESC}4m"
        
        val STRIKETHROUGH = "${ESC}9m"

        fun fgColor(R: Short, G: Short, B: Short) = "${ESC}38;2;${R};${G};${B}m"
        
        fun bgColor(R: Short, G: Short, B: Short) = "${ESC}48;2;${R};${G};${B}m"
    }
}
