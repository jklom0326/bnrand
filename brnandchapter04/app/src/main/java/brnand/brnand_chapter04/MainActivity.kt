package brnand.brnand_chapter04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import bnrand.brnandchapter04.Question

private const val TAG = "MainActivity"
private const val KET_INDEX = "index"

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val quizViewModel: QuizViewModel by lazy {
        ViewModelProvider(this).get(QuizViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)
        //ViewModelProvider(this)를 호출하면 현재 액티비티와 연관된 ViewModelProvider 인스턴스를 생성하고 반환한다.
//        val provider: ViewModelProvider = ViewModelProvider(this)
        //그리고 provider.get(QuizViewModel::class.java)를 호출하면 QuizViewModel인스턴스를 반환한다.
//        val quizViewModel = provider.get(QuizViewModel::class.java)
        // 이 두줄을 한줄로 작성할 수 있다.
//        viewModelProvider(this).get(QuizViewModel::class.java)
//        Log.d(TAG," Got a Quiz ViewModel")

        val currentIndex = savedInstanceState?.getInt(KET_INDEX, 0 ) ?: 0
        quizViewModel.currentIndex = currentIndex

        //버튼
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener {
            // 버튼클릭의 응답을 여기서 처리한다.
            checkAnswer(true)
        }
        falseButton.setOnClickListener {
            // 버튼클릭의 응답을 여기서 처리한다.
            checkAnswer(false)
        }
        // 다음버튼을 누르면 리스트에 있는 다음 문제가 나온다
        nextButton.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
        }

        updateQuestion()
    }


    private fun updateQuestion(){
        val questionTextResId = quizViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else{
            R.string.incorrect_tost
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }

    //디버깅용 액티비티

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart() Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume() Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause() Called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState")
        outState.putInt(KET_INDEX, quizViewModel.currentIndex)
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop() Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy() Called")
    }
}