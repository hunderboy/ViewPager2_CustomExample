package kr.co.everex.viewpager2_customexample.viewholder

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_vertical_bar_for_week.view.*
import kr.co.everex.viewpager2_customexample.`interface`.MyRecyclerviewInterface
import kr.co.everex.viewpager2_customexample.model.HorizontalExerciseListModel

class MultiTypeViewHolder(
        itemView: View,
        recyclerviewInterface: MyRecyclerviewInterface
):
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener
{
    val TAG: String = "로그"
    private val weekTextView: TextView = itemView.week
    private var myRecyclerviewInterface : MyRecyclerviewInterface? = null
    // 기본 생성자
    init {
        Log.d(TAG, "HorizontalExerciseListViewHolder - init() called")
        itemView.setOnClickListener(this)
        this.myRecyclerviewInterface = recyclerviewInterface
    }

    // 데이터와 뷰를 묶는다.
    fun bind(dataModel: HorizontalExerciseListModel){
        Log.d(TAG, "HorizontalExerciseListViewHolder - bind() called")
        // 텍스트뷰 와 실제 텍스트 데이터를 묶는다.
        weekTextView.text = dataModel.week
    }

    override fun onClick(p0: View?) {
        Log.d(TAG, "HorizontalExerciseListViewHolder - onClick() called")
        this.myRecyclerviewInterface?.onItemClicked(adapterPosition)
    }
}