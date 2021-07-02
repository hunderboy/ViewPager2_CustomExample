package kr.co.everex.viewpager2_customexample.layoutmanager


import android.content.Context
import android.graphics.drawable.GradientDrawable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView

class ScaleCenterItemLayoutManager : LinearLayoutManager  {

    constructor(context:Context,orientation:Int,reverseLayout:Boolean):super(context,orientation,reverseLayout)


    override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
        // return super.checkLayoutParams(lp)
        lp!!.width = width/3
        return true
    }

    override fun onLayoutCompleted(state: RecyclerView.State?) {
        super.onLayoutCompleted(state)
        scaleMiddleItem()
    }

    override fun scrollHorizontallyBy(
        dx: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {
        return if (orientation == HORIZONTAL){
            val scolled = super.scrollHorizontallyBy(dx, recycler, state)
            scaleMiddleItem()
            scolled
        }else{
            0
        }
    }

    private fun scaleMiddleItem(){
        val mid = width/2
        val d1 = 0.9f * mid
        for (i in 0 until childCount){
            val child = getChildAt(i)
            val childMid = (getBottomDecorationHeight(child!!)+getBottomDecorationHeight(child!!)) / 2f
            val d= Math.min(d1,Math.abs(mid-childMid))
            val scale = 1-0.15f * d/d1
            child.scaleX = scale
            child.scaleY = scale
        }
    }

}