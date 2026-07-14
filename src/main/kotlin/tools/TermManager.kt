import ansi_escape.*
import types.Offset
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream

class TermManager(

    val tty: File = File("/dev/tty"),

) {

//    Method to get size terminal dimensions
    fun getTerminalDimension(): Pair<Int, Int> {

        val outputStream = FileOutputStream(tty)

        val inputStream = FileInputStream(tty)

        val navCursor = CursorNav()
        navCursor.apply {
            clear()
            hideCursor()
            saveCursor()
            moveTo(Offset(9999, 9999))
            requestCursor()
        }

        try {

            stty("raw", "-echo")
            
            outputStream.write(navCursor.cursorInstruc.toByteArray())

        } finally {
            stty("sane")
            outputStream.close()
            inputStream.close()
        }

        return Pair(20, 30)
    }

    fun stty(vararg args: String): InputStream {
        val process = ProcessBuilder("stty", *args)
            .redirectInput(tty)
            .inheritIO()
            .start()

        return process.inputStream
    }

    fun clearScreen() {
        val cursorNav = CursorNav()
        cursorNav.apply {
            backToHome()
            clear()
        }

        System.out.write(
            cursorNav.cursorInstruc.toByteArray()
        )

        System.out.flush()
    }
}
