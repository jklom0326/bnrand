package brnand.brnand_chapter04

import android.util.Log
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
    // MainActivity에서 이 속성을 직접 사용하지 않기 때문에 init 블록과 onCleared()함수는 더이상 사용하지 않는다.

//    리스트
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true),
    )
    private var currentIndex = 0

    val currentQuestionAnswer: Boolean
    get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
    get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
}