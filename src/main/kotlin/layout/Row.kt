package layout

import TermManager 

class Row(

    override val border: Border = Border(),

    override val stringBuilder: StringBuilder = StringBuilder(),

    private val termManager: TermManager = TermManager(),

) : SBuilder(stringBuilder), Layout {

}
