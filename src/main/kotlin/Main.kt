import TuiManager
import Column
import Offset
import java.awt.Color

fun main() {

    val homeScreen = Column()
    homeScreen.apply {
        text(
            textString = "Hello Im Jhoon",
            offset = Offset(2,4),
            bgColor = Color(255, 64, 0)
        )
    }

    val tuiManager = TuiManager()
    tuiManager.write(homeScreen)
}
