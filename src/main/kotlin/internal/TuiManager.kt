import TermManager
import Layout

class TuiManager() {

    fun write(
        layout: Layout,
        clearScreen: Boolean = true,
        buildCanvas: Boolean = true,
    ) {

        if (clearScreen) TermManager().clearScreen()
        if (buildCanvas) layout.canvas(' ')

        println(layout.layer.stringLayer)
    }
}
