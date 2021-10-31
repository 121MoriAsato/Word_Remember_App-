package com.example.word_remember_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_addedword.*
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    val realmQ: Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val WhatButton = intent.getStringExtra("WHAT_BUTTON")

        val remQ:RealmResults<Remember>? = read()
//        val remQ:RealmResults<Remember>? = read(WhatButton) こっちを使う

        //サイズ自体は0.1の2個（場合によるけど）、よって0..2になっていたそのため-1をする
        var remQsize = remQ?.size?:0

        var i = (0..remQsize-1).random()
        //最後の数字がわからない

        var m = 0

        var n = 0

        if(remQ !=null){
            wordTextview.setText(remQ?.get(i)?.english)
        }

        showButton.setOnClickListener {
            wordTextview.setText(remQ?.get(i)?.japanese)
        }

        correctButton.setOnClickListener {
            /*var m = 0*/
            m = m+1

            wordTextview.setText(remQ?.get(i)?.english)


        }

        falseButton.setOnClickListener {
            /*var n = 0*/
            n = n+1

            wordTextview.setText(remQ?.get(i)?.english)
        }

        if(m+n == remQsize){
                val toResultActivity = Intent(this, ResultActivity::class.java)
                intent.putExtra("Q_SCORE",m)
                intent.putExtra("A_SCORE",remQsize)
                startActivity(toResultActivity)
        }


//            fun read(): RealmResults<Remember>? {
//
//                if(WhatButton == "varb") {
//                    return realmQ.where(Remember::class.java).equalTo("group", "動詞").findAll()
//                }
//                else if(WhatButton == "noun") run {
//                    return realmQ.where(Remember::class.java).equalTo("group", "名詞").findAll()
//                }else {
//                    return realmQ.where(Remember::class.java).equalTo("group", "形容詞").findAll()
//                }
//
//            }　こっちを使う

            }


    override fun onDestroy() {
        super.onDestroy()
        realmQ.close()
    }



        fun read(): RealmResults<Remember>? {
            return realmQ.where(Remember::class.java).equalTo("group", "動詞").findAll()
            //return realmQ.where(Remember::class.java).findAll()
        }

}