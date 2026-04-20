package com.ludogame.android.presentation.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ludogame.android.R
import com.ludogame.android.presentation.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnGuest = findViewById<Button>(R.id.btnGuest)
        btnGuest.setOnClickListener {
            loginViewModel.signInGuest()
        }

        lifecycleScope.launch {
            loginViewModel.isLoading.collect { loading ->
                btnGuest.isEnabled = !loading
            }
        }

        lifecycleScope.launch {
            loginViewModel.loginSuccess.collect { success ->
                if (success) {
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}
