
internal class RawContent(val content: String) {

    constructor() : this(String())

    fun add(string: String): RawContent {
        RawContent(this.content.plus(string))
    }
}
