package kr.co.everex.viewpager2_customexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kr.co.everex.viewpager2_customexample.databinding.ActivityTestCoroutineBinding

class TestCoroutineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestCoroutineBinding


//    private val job =

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestCoroutineBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료


//        val job = launch {
//            repeat(1000){ i ->`
//                Log.e("TestCoroutineActivity :","")
//                delay(500L)
//            }
//        }
//        delay(500L)


    }

}