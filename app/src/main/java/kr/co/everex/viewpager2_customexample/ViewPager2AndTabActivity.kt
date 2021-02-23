package kr.co.everex.viewpager2_customexample

import android.R
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kr.co.everex.viewpager2_customexample.databinding.ActivityViewPager2AndTabBinding
import kr.co.everex.viewpager2_customexample.fragment.DayFragment
import kr.co.everex.viewpager2_customexample.fragment.MonthFragment
import kr.co.everex.viewpager2_customexample.fragment.WeekFragment


class ViewPager2AndTabActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewPager2AndTabBinding


    // ViewPager에 포함될 Fragments
    private val dayFragment = DayFragment()
    private val weekFragment = WeekFragment()
    private val monthFragment = MonthFragment()

    // 프래그먼트 리스트
    val fragList = arrayOf(
        dayFragment,
        weekFragment,
        monthFragment
    )

    private val tabLayoutTextArray = arrayOf("Today","Week","Month")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPager2AndTabBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료

        // ViewPager2 설정
        val pagerAdapter = PagerAdapter(this)
        binding.viewPager2Container.isUserInputEnabled = true // 스크롤 허용
        binding.viewPager2Container.adapter = pagerAdapter

        // TabLayout과 ViewPager 매칭
        TabLayoutMediator(binding.tabLayout,binding.viewPager2Container){ tab,position-> // tab 포지션에 따라
            tab.text = tabLayoutTextArray[position] // position에 따른 tab.text 설정
        }.attach()

    }// onCreate 끝


    // ViewPager2 어댑터 설정
    inner class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int { // 페이지수
            return fragList.size
        }
        override fun createFragment(position: Int): Fragment { // 페이지 Fragment 생성
            return when(position){ // 포지션에 따른 다른 페이지 Fragment 전달
                0 -> DayFragment()
                1 -> WeekFragment()
                2 -> MonthFragment()
                else -> DayFragment()
            }
        }
    }

}