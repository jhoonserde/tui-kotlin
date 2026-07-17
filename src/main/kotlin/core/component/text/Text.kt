
import Cursor
import TextStyle
import java.awt.Color
import Offset
import TermManager
import RawContent

internal class Text(

    val textString: String,

    val offset: Offset,

    val italic: Boolean = false,

    val bold: Boolean = false,

    val underLine: Boolean = false,

    val fgColor: Color = Color.WHITE,

    val bgColor: Color = Color(0, 0, 0, 0),

    val strikeThrough: Boolean = false
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

        return RawContent()
            .add(navCursorToLine.cursorInstruc)
            .add(textStyle.stylish + textString)
            .add(navCursorBack.cursorInstruc)
    }
}
