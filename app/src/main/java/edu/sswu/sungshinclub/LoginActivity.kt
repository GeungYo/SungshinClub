package edu.sswu.sungshinclub

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: android.content.SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val studentIdInput = findViewById<EditText>(R.id.editStudentId)
        val passwordInput = findViewById<EditText>(R.id.editPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val signUpButton = findViewById<Button>(R.id.btnSignUp)

        loginButton.setOnClickListener {
            val studentId = studentIdInput.text.toString()
            val password = passwordInput.text.toString()

            if (studentId.isNotEmpty() && password.isNotEmpty()) {
                val savedPassword = sharedPreferences.getString("$studentId:password", null)
                if (savedPassword != null && savedPassword == password) {
                    Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "학번 또는 비밀번호가 잘못되었습니다.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "학번과 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
