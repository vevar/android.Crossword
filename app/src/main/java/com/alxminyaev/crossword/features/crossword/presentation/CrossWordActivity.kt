package com.alxminyaev.crossword.features.crossword.presentation

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.*
import com.alxminyaev.crossword.R
import com.alxminyaev.crossword.features.crossword.domain.model.CrossWord
import com.alxminyaev.crossword.features.BaseActivity
import com.alxminyaev.crossword.features.MvpPresenter
import com.alxminyaev.crossword.features.crossword.domain.model.Word
import com.alxminyaev.crossword.features.crossword.presentation.part.CellEditText

class CrossWordActivity : BaseActivity<CrossWordView>(), CrossWordView {


    private lateinit var frameLayoutCrossTable: FrameLayout
    private lateinit var frameLayoutQuestion: FrameLayout
    private lateinit var tableLayout: TableLayout

    private lateinit var crossWordPresenter: CrossWordPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crossword)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        initView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.crossword_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val itemId = item?.itemId
        if (itemId != null) {
            when (itemId) {
                R.id.action_question -> showQuestions()
                R.id.action_crossword -> hideQuestions()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initView() {
        tableLayout = findViewById(R.id.crossTable)
        frameLayoutCrossTable = findViewById(R.id.frame_cross_table)
        frameLayoutQuestion = findViewById(R.id.frame_questions)
    }

    override fun getPresenter(): MvpPresenter<CrossWordView> {
        crossWordPresenter = PresenterFactory.createPresenter(this)
        return crossWordPresenter
    }

    override fun getMvpView(): CrossWordView {
        return this
    }

    override fun createAndShowCrossWord(crossWord: CrossWord) {

        for (y in 0 until crossWord.getMaxHeight()) {
            val row = TableRow(this)
            for (x in 0 until crossWord.getMaxWidth()) {
                val cellEditText =
                    this.layoutInflater.inflate(R.layout.cell_edit_text, row, false) as CellEditText
                cellEditText.visibility = EditText.INVISIBLE
                row.addView(cellEditText)
            }
            tableLayout.addView(row)
        }

        crossWord.getListWords().forEach(action = { word ->
            if (word.orientation == Word.VERTICAL) {
                ((tableLayout.getChildAt(word.start_y) as ViewGroup).getChildAt(word.start_x) as CellEditText).hint =
                        word.number.toString()
                for (y in word.start_y until word.answer.length + word.start_y) {
                    val cell = (tableLayout.getChildAt(y) as ViewGroup).getChildAt(word.start_x) as CellEditText
                    cell.visibility = EditText.VISIBLE
                    //TODO set right char
                }
            } else {
                ((tableLayout.getChildAt(word.start_y) as ViewGroup).getChildAt(word.start_x) as CellEditText).hint =
                        word.number.toString()
                for (x in word.start_x until word.answer.length + word.start_x) {
                    (tableLayout.getChildAt(word.start_y) as ViewGroup).getChildAt(x).visibility = EditText.VISIBLE
                }
            }
        })

        frameLayoutQuestion.visibility = FrameLayout.GONE
        frameLayoutCrossTable.visibility = FrameLayout.VISIBLE
    }

    override fun showQuestions() {
        frameLayoutCrossTable.visibility = FrameLayout.GONE
        frameLayoutQuestion.visibility = FrameLayout.VISIBLE
    }

    override fun hideQuestions() {
        frameLayoutCrossTable.visibility = FrameLayout.VISIBLE
        frameLayoutQuestion.visibility = FrameLayout.GONE
    }

}
