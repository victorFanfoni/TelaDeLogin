package com.fiap.teladelogin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TelaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        supportActionBar!!.hide()
        window.statusBarColor = Color.parseColor("#00a86b")

    }
}