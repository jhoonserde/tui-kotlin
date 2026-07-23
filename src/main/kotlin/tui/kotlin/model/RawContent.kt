package tui.kotlin

internal class RawContent(val content: StringBuilder) {

    constructor() : this(StringBuilder())

    fun add(string: String): RawContent {
        return RawContent(this.content.append(string))
    }
}
