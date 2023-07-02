package com.example.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var center: ImageView
    private lateinit var centerEnd: ImageView
    private lateinit var centerStart: ImageView
    private lateinit var centerTop: ImageView
    private lateinit var centerBotton: ImageView
    private lateinit var topStart: ImageView
    private lateinit var topEnd: ImageView
    private lateinit var bottonStart: ImageView
    private lateinit var bottonEnd: ImageView

    var isPlayer1 = true
    var gameEnd = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        center = findViewById(R.id.center)
        centerEnd = findViewById(R.id.centerEnd)
        centerStart = findViewById(R.id.centerStart)
        centerTop = findViewById(R.id.centerTop)
        centerBotton = findViewById(R.id.centerBotton)
        topStart = findViewById(R.id.topStart)
        topEnd = findViewById(R.id.topEnd)
        bottonStart = findViewById(R.id.bottonStart)
        bottonEnd = findViewById(R.id.bottonEnd)

        configureBox(center)
        configureBox(centerEnd)
        configureBox(centerStart)
        configureBox(centerTop)
        configureBox(centerBotton)
        configureBox(topStart)
        configureBox(topEnd)
        configureBox(bottonEnd)
        configureBox(bottonStart)

        val reset: Button = findViewById(R.id.buttonReset)
        reset.setOnClickListener {
            reset(center)
            reset(centerEnd)
            reset(centerStart)
            reset(centerTop)
            reset(centerBotton)
            reset(topStart)
            reset(topEnd)
            reset(bottonEnd)
            reset(bottonStart)

        }
    }
    private fun reset(box: ImageView){
        box.setImageDrawable(null)
        box.tag = null
        isPlayer1 = true
        gameEnd = false
    }
    private fun configureBox(box: ImageView){
        box.setOnClickListener {
            if (box.tag == null && !gameEnd){
                if (isPlayer1){
                    box.setImageResource(R.drawable.baseline_close_24)
                    isPlayer1 = false
                    box.tag = 1
                } else{
                    box.setImageResource(R.drawable.baseline_panorama_fish_eye_24)
                    isPlayer1 = true
                    box.tag = 2
                }
                if (playerWin(1)){
                    Toast.makeText(this@MainActivity, "Player 1 WIN!", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                } else if (playerWin(2)){
                    Toast.makeText(this@MainActivity, "Player 2 WIN!", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                }
            }

        }

    }
    private fun playerWin(value: Int): Boolean{
        if ((center.tag == value && centerTop.tag == value && centerBotton.tag == value)||
            (topStart.tag == value && centerStart.tag == value && bottonStart.tag == value)||
            (topEnd.tag == value && centerEnd.tag == value && bottonEnd.tag == value)||
            (center.tag == value && topStart.tag == value && bottonEnd.tag == value)||
            (center.tag == value && topEnd.tag == value && bottonStart.tag == value)||
            (centerStart.tag == value && center.tag == value && centerEnd.tag == value)||
            (topStart.tag == value && centerTop.tag == value && topEnd.tag == value)||
            (bottonStart.tag == value && centerBotton.tag == value && bottonEnd.tag == value)){
            return true
        }
        return false
    }
}