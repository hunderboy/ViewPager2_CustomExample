package kr.co.everex.viewpager2_customexample.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_achievement_rate_vertical_bar.view.*
import kr.co.everex.viewpager2_customexample.R
import kr.co.everex.viewpager2_customexample.`interface`.MyRecyclerviewInterface
import kr.co.everex.viewpager2_customexample.model.HorizontalExerciseListModel
import kr.co.everex.viewpager2_customexample.viewholder.HorizontalExerciseListViewHolder
import kr.co.everex.viewpager2_customexample.viewholder.MultiTypeViewHolder
import kr.co.everex.viewpager2_customexample.viewholder.SingleTypeViewHolder

class MultiViewTypeAdapter (
    myRecyclerviewInterface: MyRecyclerviewInterface,
    val list: List<HorizontalExerciseListModel>
):
    RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    private var myRecyclerviewInterface :MyRecyclerviewInterface? = null
    init {
        this.myRecyclerviewInterface = myRecyclerviewInterface
    }


    // getItemViewType의 리턴값 Int가 viewType으로 넘어온다.
    // viewType으로 넘어오는 값에 따라 viewHolder를 알맞게 처리해주면 된다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when (viewType) {
            HorizontalExerciseListModel.SINGLE_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_achievement_rate_vertical_bar, parent, false)
                SingleTypeViewHolder(view, this.myRecyclerviewInterface!!)
            }
            HorizontalExerciseListModel.MULTI_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_achievement_rate_vertical_bar_ver2, parent, false)
                MultiTypeViewHolder(view, this.myRecyclerviewInterface!!)
            }
            else -> throw RuntimeException("알 수 없는 뷰 타입 에러")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("MultiViewTypeAdapter", "Hi, onBindViewHolder")
        val dataModel = list[position]
        when (dataModel.type) {
            HorizontalExerciseListModel.SINGLE_TYPE -> {
                (holder as SingleTypeViewHolder).bind(list[position])
            }
            HorizontalExerciseListModel.MULTI_TYPE -> {
                (holder as MultiTypeViewHolder).bind(list[position])
            }
        }
    }


    // 여기서 받는 position은 데이터의 index다.
    override fun getItemViewType(position: Int): Int {
        Log.d("MultiViewTypeAdapter", "Hi, getItemViewType")
        return list[position].type
    }

    override fun getItemCount(): Int {
        return list.size
    }
//    inner class MultiTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val weekTextView: TextView = itemView.week
//    }
}
