package kr.co.everex.viewpager2_customexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.everex.viewpager2_customexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료

        binding.button1.setOnClickListener{
            val intent = Intent(this, ViewPager2TestActivity::class.java)
            startActivity(intent)
            finish()// 화면 종료
        }
        binding.button2.setOnClickListener{
            val intent = Intent(this, ViewPager2AndTabActivity::class.java)
            startActivity(intent)
            finish()// 화면 종료
        }


    }
}