package com.ithub.todoapp.activities.logAndReg

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ithub.todoapp.DataBase.DBHelper
import com.ithub.todoapp.activities.main_page.ItemsActivity
import com.ithub.todoapp.databinding.ActivityAuthBinding
import com.ithub.todoapp.models.User

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvToRegistration.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        binding.btnAuth.setOnClickListener {
            login()
        }
    }

    private fun login() = with(binding) {
        val login = edLoginAuth.text.toString().trim()
        val password = edPasswordAuth.text.toString().trim()

        if (login.isEmpty() || password.isEmpty()) {
            Toast.makeText(this@AuthActivity, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
        } else {
            val db = DBHelper(this@AuthActivity, null)
            val isAuth = db.getUser(login, password)

            if (isAuth) {
                Toast.makeText(this@AuthActivity, "Пользователь $login авторизован", Toast.LENGTH_SHORT).show()
                edLoginAuth.text.clear()
                edPasswordAuth.text.clear()

                val intent = Intent(this@AuthActivity, ItemsActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this@AuthActivity, "Пользователь $login НЕ авторизован", Toast.LENGTH_SHORT).show()
            }
        }

    }
}