package tui.kotlin.component

import tui.kotlin.TermManager

class Border(

    val charHorizontal: String,

    val charVertical: String,

    val charTopLeft: String,

    val charTopRight: String,

    val charBottomLeft: String,

    val charBottomRight: String,
) {

    constructor() : this("#", "#", "#", "#", "#", "#")

    val termDimension = TermManager().getTerminalDimension()

    val heigth = termDimension.first

    val width = termDimension.second

    val areaDimension = heigth.times(width)

    /*fun verticalBorderLine(singleLine: Boolean?): StringBuilder {

        val sbLine: StringBuilder = StringBuilder()

        return sbLine
    } */

    fun horizontalBorderLine(singleLine: Boolean?): StringBuilder {

        val sbLine: StringBuilder = StringBuilder()

        var tempWidth: Int = width - 1

        while (!tempWidth.equals(1) && tempWidth <= width) {
            sbLine.append(charHorizontal)
            tempWidth--
        }

        return sbLine
    }

    fun borderLine(): StringBuilder {

        var tempDimension = areaDimension

        val horizontalBorder = horizontalBorderLine(null).toString()

        val sbBuff = StringBuilder()
        
        while (!tempDimension.equals(0)) {
            sbBuff.append("▒")
            tempDimension--
        }

        sbBuff.setRange(
            1,
            (width - 1),
            horizontalBorder
        )
        sbBuff.setRange(
            (areaDimension - width + 1),
            (areaDimension - 1),
            horizontalBorder
        )
        
        return sbBuff
    }
}
