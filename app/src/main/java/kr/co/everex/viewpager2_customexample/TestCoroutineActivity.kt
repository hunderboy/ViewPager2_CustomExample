package kr.co.everex.viewpager2_customexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_test_coroutine.*
import kotlinx.coroutines.*
import kr.co.everex.viewpager2_customexample.`interface`.RetrofitNetwork
import kr.co.everex.viewpager2_customexample.databinding.ActivityTestCoroutineBinding
import org.mindrot.jbcrypt.BCrypt
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

/**
 * 비밀번호 암호화 Bcrypt
 * 코루틴 + retrofit2
 */
class TestCoroutineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestCoroutineBinding

    // 암호화
    private var password: String? = null
    private var passwordHashed: String? = null
    private var confirmPassword: String? = null


    val retrofit = Retrofit.Builder().baseUrl("http://localhost:3000")
        .addConverterFactory(GsonConverterFactory.create()).build();
    val service = retrofit.create(RetrofitNetwork::class.java);




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


//        // 요청 url 예시
//        // http://192.168.35.238:3000/process/listuser
//        binding.buttonCoroutineTest.setOnClickListener{
//            service.listUser()?.enqueue(object : Callback<Array> {
//                override fun onFailure(call: Call<Array>?, t: Throwable?) {}
//                override fun onResponse(call: Call<Array>, response: Response<Array>) {
//                    Log.d("Response :: ", response?.body().toString())
//
//                    var data : Array? = response?.body()
//                    for ( i in data!!){
//                        Log.i("data" , i.toString())
//                    }
//                }
//            })
//        }

    }

}