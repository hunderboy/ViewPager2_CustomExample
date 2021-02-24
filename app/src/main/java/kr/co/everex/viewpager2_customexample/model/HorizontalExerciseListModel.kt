package kr.co.everex.viewpager2_customexample.model



/**
 * 생성일 : 2021-02-20
 * HomeFragment 에서
 * 가로형 RecyclerView 커리큘럼 운동들을 나타내는
 * 데이터 클래스
 */
data class HorizontalExerciseListModel (
    var type: Int = SINGLE_TYPE, // 기본은 SINGLE_TYPE
    // 몇주?
    var week: String,
    // Todo 운동 달성률 평균 수치 0 ~ 100
    var average: Int = 0, // 기본은 0 이고 설정해야 함
){
    companion object {
        const val SINGLE_TYPE = 1
        const val MULTI_TYPE = 2
    }
}

