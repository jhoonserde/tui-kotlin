
import Offset

class CursorNav(private var _cursorInstruc: String = String()) {

    val cursorInstruc: String by lazy { _cursorInstruc }
    
    fun saveCursor() {
        _cursorInstruc += AnsiEscape.CursorNav.SAVE_CURSOR
    }

    fun restoreCursor() {
        _cursorInstruc += AnsiEscape.CursorNav.RESTORE_CURSOR
    }

    fun requestCursor() {
        _cursorInstruc += AnsiEscape.CursorNav.REQUEST_CURSOR
    }

    fun hideCursor() {
        _cursorInstruc += AnsiEscape.CursorNav.HIDE_CURSOR
    }

    fun showCursor() {
        _cursorInstruc += AnsiEscape.CursorNav.SHOW_CURSOR
    }

    fun clear() {
        _cursorInstruc += AnsiEscape.CursorNav.CLEAR
    }

    fun moveTo(offset: Offset) {
        _cursorInstruc += AnsiEscape.CursorNav.moveTo(offset)
    }
}
