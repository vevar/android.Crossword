package com.alxminyaev.crossword.features.crossword.presentation.part

import android.content.Context
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet

class CellEditText: AppCompatEditText{

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context,attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context,attrs,defStyleAttr)


    private var rightChar: Char? = null
    private var isRightChar: Boolean = false

    fun isRightChar(): Boolean {
        return isRightChar
    }

    fun setRightChar(char: Char) {
        rightChar = char
    }

    override fun onTextChanged(text: CharSequence?, start: Int, lengthBefore: Int, lengthAfter: Int) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        isRightChar = !text.isNullOrEmpty() && text!![0] == rightChar
        if (isRightChar){
            this.isEnabled = false
        }
    }

}