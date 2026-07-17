import CursorControl

class Cursor {

    private val cursorControl: CursorControl = CursorControl()


    val cursorInstruc: String
        get() = cursorControl.cursorInstruc


    fun saveCursor() = cursorControl.saveCursor()


    fun restoreCursor() = cursorControl.restoreCursor()


    fun requestCursor() = cursorControl.requestCursor()


    fun hideCursor() = cursorControl.hideCursor()


    fun showCursor() = cursorControl.showCursor()


    fun clear() = cursorControl.clear()


    fun moveTo(offset: Offset) = cursorControl.moveTo(offset)

}
