package com.fiap.teladelogin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.fiap.teladelogin.databinding.ActivityMainBinding
import com.fiap.teladelogin.databinding.ActivityTelaPrincipalBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide() // Verifica se a ActionBar não é nula antes de ocultá-la
        window.statusBarColor = Color.parseColor("#FFFFFF")

        binding.btEntrar.setOnClickListener{

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            when {
                email.isEmpty() -> binding.editEmail.error = "Preencha o E-mail!"
                senha.isEmpty() -> binding.editSenha.error = "Preencha a senha!!"
                !email.contains("@") -> mostrarSnackbar("E-mail inválido!")
                senha.length <= 5 -> mostrarSnackbar("A senha deve ter pelo menos 6 caracteres!")
                else -> login(it)
            }
        }
    }

    private fun login(view: View) {
        val progressBar = binding.progressBar
        progressBar.visibility = View.VISIBLE

        binding.btEntrar.isEnabled = false
        binding.btEntrar.setTextColor(Color.parseColor("#FFFFFF"))

        Handler(Looper.getMainLooper()).postDelayed({
            navegarTelaPrincipal()
            mostrarSnackbar("Login efetuado com sucesso!")
        }, 3000)
    }

    private fun navegarTelaPrincipal() {
        val intent = Intent(this, TelaPrincipal::class.java)
        startActivity(intent)
    }

    private fun mostrarSnackbar(mensagem: String) {
        val snackbar = Snackbar.make(binding.root, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }
}
