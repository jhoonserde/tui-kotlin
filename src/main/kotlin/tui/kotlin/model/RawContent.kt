package tui.kotlin

internal class RawContent(val content: StringBuilder) {

    constructor() : this(StringBuilder())

    fun add(string: String) {
        this.content.append(string)
    }
}
