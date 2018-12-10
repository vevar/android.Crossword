package com.alxminyaev.crossword.service

import com.alxminyaev.crossword.features.crossword.domain.model.CrossWord
import com.alxminyaev.crossword.features.crossword.domain.model.Word
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream
import java.io.InputStreamReader

class XmlCrossWordParser {

    companion object {
        const val TAG_WORD = "word"

        const val ATTR_NUMBER = "number"
        const val ATTR_ORIENTATION = "orientation"
        const val ATTR_START_X = "start_x"
        const val ATTR_START_Y = "start_y"
        const val ATTR_QUESTION = "question"
        const val ATTR_ANSWER = "answer"

        const val HORIZONTAL = "horizontal"
        const val VERTICAL = "vertical"
    }

    private val pullParser: XmlPullParser = XmlPullParserFactory.newInstance().newPullParser()

    fun getCrossWord(inputStream: InputStream): CrossWord {
        val crossWord = CrossWord()

        pullParser.setInput(InputStreamReader(inputStream))

        var eventType = pullParser.eventType
        while (eventType != XmlPullParser.END_DOCUMENT) {
            when (eventType) {
                XmlPullParser.START_TAG ->
                    when (pullParser.name) {
                        TAG_WORD -> crossWord.addWord(parsWord())
                    }
            }
            eventType = pullParser.next()
        }

        return crossWord
    }

    private fun parsWord(): Word {
        return Word(
            pullParser.getAttributeValue(null, ATTR_NUMBER).toInt(),
            if (pullParser.getAttributeValue(null, ATTR_ORIENTATION) == HORIZONTAL)
                Word.HORIZONTAL
            else
                Word.VERTICAL,
            pullParser.getAttributeValue(null, ATTR_START_X).toInt(),
            pullParser.getAttributeValue(null, ATTR_START_Y).toInt(),
            pullParser.getAttributeValue(null, ATTR_QUESTION),
            pullParser.getAttributeValue(null, ATTR_ANSWER)
        )
    }


}