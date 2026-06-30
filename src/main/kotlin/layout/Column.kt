package layout

import TermManager

class Column(

    override val border: Border = Border(),

    override val stringBuilder: StringBuilder = StringBuilder(),

    private val termManager: TermManager = TermManager(),

) : SBuilder(stringBuilder), Layout {

}
