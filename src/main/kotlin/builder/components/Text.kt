package builder.components

import ansi_escape.CursorNav
import ansi_escape.TextStyle
import java.awt.Color
import Position
import TermManager

class Text(

    val textString: String,
    
    val position: Position,
    
    val italic: Boolean = false,
    
    val bold: Boolean = false,
    
    val underLine: Boolean = false,
    
    val fgColor: Color = Color.WHITE,
    
    val bgColor: Color = Color(0, 0, 0, 0),
    
    val strikeThrough: Boolean = false
)
