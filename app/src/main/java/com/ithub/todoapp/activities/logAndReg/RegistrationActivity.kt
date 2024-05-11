package com.ithub.todoapp.activities.logAndReg

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ithub.todoapp.DataBase.DBHelper
import com.ithub.todoapp.databinding.ActivityRegistrationBinding
import com.ithub.todoapp.models.User

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReg.setOnClickListener {
            registration()
        }

        binding.tvToLogin.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registration() = with(binding) {
        val login = edLoginReg.text.toString().trim()
        val email = edEmailReg.text.toString().trim()
        val password = edPasswordReg.text.toString().trim()

        if (login.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this@RegistrationActivity, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
        } else {
            val user = User(login, email, password)

            val db = DBHelper(this@RegistrationActivity, null)
            db.addUser(user)
            Toast.makeText(this@RegistrationActivity, "Пользователь $login добавлен", Toast.LENGTH_SHORT).show()

            edLoginReg.text.clear()
            edEmailReg.text.clear()
            edPasswordReg.text.clear()
        }

    }
}