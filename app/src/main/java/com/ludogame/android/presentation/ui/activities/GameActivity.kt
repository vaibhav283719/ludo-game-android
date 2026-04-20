package com.ludogame.android.presentation.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ludogame.android.R
import com.ludogame.android.presentation.viewmodels.GameViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GameActivity : AppCompatActivity() {
    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val tvDiceValue = findViewById<TextView>(R.id.tvDiceValue)
        val btnRollDice = findViewById<Button>(R.id.btnRollDice)

        btnRollDice.setOnClickListener {
            gameViewModel.rollDice()
        }

        lifecycleScope.launch {
            gameViewModel.diceValue.collect { value ->
                tvDiceValue.text = getString(R.string.dice_value, value)
            }
        }
    }
}
