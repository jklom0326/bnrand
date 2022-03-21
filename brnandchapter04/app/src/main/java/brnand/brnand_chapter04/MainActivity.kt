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

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider: ViewModelProvider = ViewModelProvider(this)
        val quizViewModel = provider.get(QuizViewModel::class.java)
        Log.d(TAG," Got a Quiz ViewModel")

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
            currentIndex =(currentIndex + 1) % questionBank.size
            updateQuestion()
        }

        updateQuestion()
    }


    private fun updateQuestion(){
        val questionTextResId = questionBank[currentIndex].tesxtResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else{
            R.string.incorrect_tost
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}