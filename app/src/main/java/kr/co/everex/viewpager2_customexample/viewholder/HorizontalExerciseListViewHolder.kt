package kr.co.everex.viewpager2_customexample.viewholder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thcompany.smartkneewalk.R
import com.thcompany.smartkneewalk.`interface`.MyRecyclerviewInterface
import com.thcompany.smartkneewalk.info.App.Companion.getApplicationContext
import com.thcompany.smartkneewalk.model.HorizontalExerciseListModel
import kotlinx.android.synthetic.main.item_horizontal_exercise.view.*
import kr.co.everex.viewpager2_customexample.`interface`.MyRecyclerviewInterface
import kr.co.everex.viewpager2_customexample.model.HorizontalExerciseListModel


/**
 * 생성일 : 2021-02-20
 * HomeFragment 에서
 * 가로형 RecyclerView 커리큘럼 운동들을 나타내는 뷰홀더
 */
class HorizontalExerciseListViewHolder(itemView: View,
                                       recyclerviewInterface: MyRecyclerviewInterface
):
                    RecyclerView.ViewHolder(itemView),
                    View.OnClickListener
{
    val TAG: String = "로그"

    private val exercisePreviewImageView = itemView.exercise_img
    private val exerciseNameTextView = itemView.exercise_name
    private val exerciseTimeTextView = itemView.exercise_time

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
        exerciseNameTextView.text = dataModel.exerciseName
        exerciseTimeTextView.text = dataModel.exerciseTime


        // 이미지뷰와 실제 이미지 데이터를 묶는다 .
        Glide
            .with(getApplicationContext())
            .load(dataModel.exerciseImage)
//            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(exercisePreviewImageView)
    }

    override fun onClick(p0: View?) {
        Log.d(TAG, "HorizontalExerciseListViewHolder - onClick() called")

        this.myRecyclerviewInterface?.onItemClicked(adapterPosition)
    }

}
