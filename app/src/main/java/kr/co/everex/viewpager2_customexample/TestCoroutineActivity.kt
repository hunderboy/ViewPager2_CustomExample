package kr.co.everex.viewpager2_customexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_test_coroutine.*
import kotlinx.coroutines.*
import kr.co.everex.viewpager2_customexample.databinding.ActivityTestCoroutineBinding
import org.mindrot.jbcrypt.BCrypt

class TestCoroutineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestCoroutineBinding


    private var password: String? = null
    private var passwordHashed: String? = null

    private var confirmPassword: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestCoroutineBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료


        binding.buttonCrypt.setOnClickListener{
            password = binding.editTextTextPassword.text.toString()
            passwordHashed = BCrypt.hashpw(password, BCrypt.gensalt(10))
            Toast.makeText( baseContext, "암호화됨 : $passwordHashed", Toast.LENGTH_SHORT).show()
        }

        binding.buttonLogin.setOnClickListener{
            confirmPassword = binding.editTextTextPasswordForLogin.text.toString()

            val isValidPassword = BCrypt.checkpw(confirmPassword, passwordHashed)

            if (isValidPassword){
                Toast.makeText( baseContext, "비밀번호 일치함", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText( baseContext, "PW not correct", Toast.LENGTH_SHORT).show()
            }

        }
    }

}