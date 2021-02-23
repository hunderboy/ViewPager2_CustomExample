package kr.co.everex.viewpager2_customexample.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thcompany.smartkneewalk.R
import com.thcompany.smartkneewalk.`interface`.MyRecyclerviewInterface
import com.thcompany.smartkneewalk.model.HorizontalExerciseListModel
import com.thcompany.smartkneewalk.viewholder.HorizontalExerciseListViewHolder

/**
 * 생성일 : 2021-02-20
 * HomeFragment 에서
 * 가로형 RecyclerView 커리큘럼 운동들을 나타내는
 * 데이터 클래스
 */
class HorizontalExerciseListAdapter(
    myRecyclerviewInterface: MyRecyclerviewInterface
):
    RecyclerView.Adapter<HorizontalExerciseListViewHolder>()
{
    val TAG: String = "로그"
    // onItemClicked 인터페이스
    private var myRecyclerviewInterface :MyRecyclerviewInterface? = null

    // 생성자
    init {
        this.myRecyclerviewInterface = myRecyclerviewInterface
    }

    companion object {
        var modelList = ArrayList<HorizontalExerciseListModel>()
    }

    // 외부의 ArrayList 와 매칭
    fun submitList(listToMatch: ArrayList<HorizontalExerciseListModel>){
        modelList = listToMatch
    }





    // 뷰홀더가 생성 되었을때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalExerciseListViewHolder {
        // 연결할 레이아웃 설정
        return HorizontalExerciseListViewHolder(LayoutInflater.from(parent.context).
        inflate(R.layout.item_horizontal_exercise, parent, false), this.myRecyclerviewInterface!!)
    }

    // 목록의 아이템수
    override fun getItemCount(): Int {
        return modelList.size
    }

    // 뷰와 뷰홀더가 묶였을때
    override fun onBindViewHolder(holder: HorizontalExerciseListViewHolder, position: Int) {
        Log.d(TAG, "MyRecyclerAdapter - onBindViewHolder() called / position: $position")
        holder.bind(modelList[position])
    }



}
