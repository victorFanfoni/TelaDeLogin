package com.fiap.teladelogin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import com.fiap.teladelogin.MainActivity
import com.fiap.teladelogin.R

class TelaPrincipal : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        var button = findViewById<Button>(R.id.btVoltar)

        button.setOnClickListener{view : View? ->

            var navegarDeVolta = Intent(this, MainActivity::class.java)
            startActivity(navegarDeVolta)
        }

    }
}
