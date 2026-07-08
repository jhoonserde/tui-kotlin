import TuiManager
import layout.*

fun main() {

    val homeScreen = SBuilder()
    homeScreen.apply {
        text(
            textString = "Hello Im Jhoon",
            position = Position(2,4) 
        )
    }

    val tuiManager = TuiManager()
    tuiManager.write(homeScreen)
}
