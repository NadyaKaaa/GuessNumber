package com.nadyaka.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var gameFinished = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var guess = (Math.random() * 100).toInt()

        btn.setOnClickListener {
            if (!gameFinished){
                val userGuess = userInput.text.toString().toInt()
                when  {
                    userGuess < guess -> {
                        tvInfo.text = getString(R.string.behind)
                    }
                    userGuess > guess -> {
                        tvInfo.text = getString(R.string.ahead)
                    }
                    userGuess == guess -> {
                        tvInfo.text = getString(R.string.hit)
                        gameFinished = true
                        btn.text = getString(R.string.play_more)
                    }
                }
            } else {
                tvInfo.text = getString(R.string.guess_number)
                userInput.text.clear()
                guess = (Math.random() * 100).toInt()
                btn.text = getString(R.string.input_number)
                gameFinished = false
            }
        }

    }
}