package brnand.brnand_chapter04

import androidx.lifecycle.ViewModel
import bnrand.brnandchapter04.Question

private const val TAG = "QuizViewModel"

class QuizViewModel:ViewModel() {
    //초기화 블록 이 코드는 클래스 인스턴스 생성시에 자동으로 실행된다.
//    init {
//        Log.d(TAG,"ViewModel instance created")
//    }
//    override fun onCleared(){
//        super.onCleared()
//        Log.d(TAG, "ViewModel instace about to be destroyed")
//    }
    //리스트
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true),
    )
    private var currentIndex = 0

}