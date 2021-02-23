package kr.co.everex.viewpager2_customexample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import kr.co.everex.viewpager2_customexample.databinding.ActivityViewPager2TestBinding

class ViewPager2TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewPager2TestBinding



    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPager2TestBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료



    }
}