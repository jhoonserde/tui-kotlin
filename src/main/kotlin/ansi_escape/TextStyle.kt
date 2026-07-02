package ansi_escape

import java.awt.Color

object TextStyle {

    private const val ESC = "\u001B["

    val RESET_STYLE = "${ESC}0m"

    val BOLD = "${ESC}1m"
        
    val ITALIC = "${ESC}3m"
        
    val UNDERLINE = "${ESC}4m"
        
    val STRIKETHROUGH = "${ESC}9m"

    fun fgColor(color: Color) =
        "${ESC}38;2;${color.red};${color.green};${color.blue}m"
        
    fun bgColor(color: Color) =
        "${ESC}48;2;${color.red};${color.green};${color.blue}m"
}
