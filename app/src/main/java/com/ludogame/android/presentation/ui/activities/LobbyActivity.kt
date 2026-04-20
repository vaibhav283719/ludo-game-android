package com.ludogame.android.presentation.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ludogame.android.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LobbyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby)
    }
}
