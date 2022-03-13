package brnand.brnand_chapter04

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel:ViewModel() {
    //초기화 블록 이 코드는 클랫 ㅡ인스턴스 생성시에 자동으로 실행된다.
    init {
        Log.d(TAG,"ViewModel instance created")
    }
    override fun onCleared(){
        super.onCleared()
        Log.d(TAG, "ViewModel instace about to be destroyed")
    }
}