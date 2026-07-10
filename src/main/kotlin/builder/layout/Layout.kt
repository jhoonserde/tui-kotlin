package layout

interface Layout {

    val stringBuilder: StringBuilder

    fun canvas(charCanvas: Char)
}
