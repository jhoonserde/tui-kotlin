import TermManager
import layout.SBuilder

class TuiManager() {

    fun write(
        sBuilder: SBuilder,
        clearScreen: Boolean = true,
        buildCanvas: Boolean = true,
    ) {

        if (clearScreen) TermManager().clearScreen()
        if (buildCanvas) sBuilder.canvas()

        println(sBuilder.stringBuilder)
    }
}
