package kr.co.everex.viewpager2_customexample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.everex.viewpager2_customexample.R
import kr.co.everex.viewpager2_customexample.databinding.FragmentMonthBinding


class MonthFragment : Fragment() {
    private var _binding: FragmentMonthBinding? = null
    private val binding get() = _binding!! // 해당 속성은 onCreateView 와 onDestroyView 에서만 유효함

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMonthBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }

}