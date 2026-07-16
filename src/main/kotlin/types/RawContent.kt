
internal class RawContent(val content: String) {

    constructor() : this(String())

    fun add(string: String): RawContent {
        return RawContent(this.content.plus(string))
    }
}
