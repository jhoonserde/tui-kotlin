package ansi_escape

import java.awt.Color

class TextStyle(
    var _stylish: String = "",
    val stylish: String = _stylish
) {

    fun resetStyle() {
        _stylish += AnsiEscape.TextStyle.RESET_STYLE
    }

    fun bold() {
        _stylish += AnsiEscape.TextStyle.BOLD
    }

    fun italic() {
        _stylish += AnsiEscape.TextStyle.ITALIC
    }

    fun underLine() {
        _stylish += AnsiEscape.TextStyle.UNDERLINE
    }

    fun strikeThrough() {
        _stylish += AnsiEscape.TextStyle.STRIKETHROUGH
    }

    fun fgColor(color: Color) {
        _stylish += AnsiEscape.TextStyle.fgColor(color)
    }

    fun bgColor(color: Color) {
        _stylish += AnsiEscape.TextStyle.bgColor(color)
    }
}
