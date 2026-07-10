import TermManager
import layout.Layout
import layout.SBuilder

class TuiManager() {

    fun write(
        layout: Layout,
        clearScreen: Boolean = true,
        buildCanvas: Boolean = true,
    ) {

        if (clearScreen) TermManager().clearScreen()
        if (buildCanvas) layout.canvas(' ')

        println(layout.stringBuilder)
    }
}
