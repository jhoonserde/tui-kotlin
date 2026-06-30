import TuiManager
import layout.*

fun main() {

    val homeScreen = SBuilder()
    homeScreen
        .text("Hello Im Jhoon")
        .spacer(2)

    val tuiManager = TuiManager()
    tuiManager.sysWrite(homeScreen)
}
