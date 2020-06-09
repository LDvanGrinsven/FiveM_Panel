package com.example.FiveM_Panel.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.FiveM_Panel.R
import com.example.FiveM_Panel.database.FiveM

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*

const val EXTRA_GAME = "EXTRA_GAME"

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->

                val game = FiveM(
                    tvDBName.text.toString(),
                    tvIP.text.toString(),
                    tvUsername.text.toString(),
                    tvPassword.text.toString()
                )
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_GAME, game)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
