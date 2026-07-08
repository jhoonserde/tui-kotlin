package layout

import ansi_escape.CursorNav
import ansi_escape.TextStyle
import java.awt.Color
import Position
import TermManager
import builder.Builder
import builder.components.Text

open class SBuilder(

    open val stringBuilder: StringBuilder = StringBuilder(),

    private val builder: Builder = Builder(),

    private val termManager: TermManager = TermManager(),

    private val cursorNav: CursorNav = CursorNav()

) {


    fun canvas(char: Char = ' ') {
        stringBuilder.insert(0, builder.buildCanvas(char))
    }


    fun layout(type: SBuilder, content: (SBuilder) -> SBuilder) {
        
        val contentStringBuilder = content(type).stringBuilder
        stringBuilder.append(contentStringBuilder)
    }


    fun text(
        textString: String,
        position: Position,
        italic: Boolean = false,
        bold: Boolean = false,
        underLine: Boolean = false,
        fgColor: Color = Color.WHITE,
        bgColor: Color = Color(0, 0, 0, 0),
        strikeThrough: Boolean = false
    ) {
        val text = builder.buildText(
            Text(
                textString = textString,
                position = position,
                italic = italic,
                bold = bold,
                underLine = underLine,
                fgColor = fgColor,
                bgColor = bgColor,
                strikeThrough = strikeThrough
            )
        )
        stringBuilder.append(text)
    }
}
