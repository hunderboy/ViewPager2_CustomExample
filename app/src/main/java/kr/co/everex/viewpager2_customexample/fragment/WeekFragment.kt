package kr.co.everex.viewpager2_customexample.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.everex.viewpager2_customexample.`interface`.MyRecyclerviewInterface
import kr.co.everex.viewpager2_customexample.adapter.HorizontalExerciseListAdapter
import kr.co.everex.viewpager2_customexample.databinding.FragmentWeekBinding
import kr.co.everex.viewpager2_customexample.model.HorizontalExerciseListModel


class WeekFragment : Fragment(), MyRecyclerviewInterface {
    private var _binding: FragmentWeekBinding? = null
    private val binding get() = _binding!! // 해당 속성은 onCreateView 와 onDestroyView 에서만 유효함
    private val TAG: String = "로그"


    // 데이터 아이템 리스트
    var curriculumList = ArrayList<HorizontalExerciseListModel>()
    // 리사이클러뷰 어댑터
    private lateinit var horizontalExerciseListAdapter: HorizontalExerciseListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeekBinding.inflate(inflater, container, false)
        val view = binding.root



        // Model 데이터 설정
        for (i in 1..5){
            val week = weekWhen(i)

            val horizontalExerciseListModel = HorizontalExerciseListModel(
                week = week,
            )
            this.curriculumList.add(horizontalExerciseListModel)
        }
        /**
        // 가로 리사이클러뷰
        // 어답터 인스턴스 생성
         */
        horizontalExerciseListAdapter = HorizontalExerciseListAdapter(this)
        horizontalExerciseListAdapter.submitList(curriculumList)
        // 리사이클러뷰 설정
        binding.recyclerViewList.apply {
            // 리사이클러뷰 방향 등 설정
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            // 어답터 장착
            adapter = horizontalExerciseListAdapter
        }



        return view
    }

    private fun weekWhen(a: Any): String {
        return when (a) {
            1 -> "1주"
            2 -> "2주"
            3 -> "3주"
            4 -> "4주"
            5 -> "5주"
            else ->
                "0주"
        }
    }



    override fun onItemClicked(position: Int) {
        Log.d(TAG, "HomeFragment - onItemClicked() called / position: $position")
    }


    // Fragment에서 ViewBinding 사용 시 문제되는 메모리 누수 방지를 위해 꼭 View를 해제 해준다.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}