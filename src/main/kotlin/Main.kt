import TuiManager
import layout.*
import types.Offset

fun main() {

    val homeScreen = SBuilder()
    homeScreen.apply {
        text(
            textString = "Hello Im Jhoon",
            offset = Offset(2,4)
        )
    }

    val tuiManager = TuiManager()
    tuiManager.write(homeScreen)
}
