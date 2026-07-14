import TuiManager
import layout.*
import types.Offset
import java.awt.Color

fun main() {

    val homeScreen = SBuilder()
    homeScreen.apply {
        border()
        text(
            textString = "Hello Im Jhoon",
            offset = Offset(2,4),
            bgColor = Color(255, 64, 0) 
        )
    }

    val tuiManager = TuiManager()
    tuiManager.write(homeScreen)
}
