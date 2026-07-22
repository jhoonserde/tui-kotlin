package tui.kotlin

import tui.kotlin.Offset

class Layer {

    internal val stringLayer: StringBuilder = StringBuilder()

    fun getRawLayer() = stringLayer.toString()

}
