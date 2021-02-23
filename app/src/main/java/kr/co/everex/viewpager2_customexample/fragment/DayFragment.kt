package kr.co.everex.viewpager2_customexample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.everex.viewpager2_customexample.R
import kr.co.everex.viewpager2_customexample.databinding.FragmentDayBinding


class DayFragment : Fragment() {
    private var _binding: FragmentDayBinding? = null
    private val binding get() = _binding!! // 해당 속성은 onCreateView 와 onDestroyView 에서만 유효함

    private var progr = 75


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDayBinding.inflate(inflater, container, false)
        val view = binding.root

        updateProgressBar()

        return view
    }


    private fun updateProgressBar() {
        binding.progressBar.progress = progr
    }

    // Fragment에서 ViewBinding 사용 시 문제되는 메모리 누수 방지를 위해 꼭 View를 해제 해준다.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}