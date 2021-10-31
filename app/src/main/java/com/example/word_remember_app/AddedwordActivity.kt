package com.example.word_remember_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_addedword.*

class AddedwordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addedword)


        verbButton.setOnClickListener{
            val toQuestionActivityIntent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("WHAT_BUTTON","verb")
            startActivity(toQuestionActivityIntent)}

        nounButton.setOnClickListener{
            val toQuestionActivity = Intent(this, QuestionActivity::class.java)
            intent.putExtra("WHAT_BUTTON","noun")
            startActivity(toQuestionActivity)}

        adjectiveButton.setOnClickListener{
            val toQuestionActivity = Intent(this, QuestionActivity::class.java)
            intent.putExtra("WHAT_BUTTON","adjective")
            startActivity(toQuestionActivity)}
    }

}
