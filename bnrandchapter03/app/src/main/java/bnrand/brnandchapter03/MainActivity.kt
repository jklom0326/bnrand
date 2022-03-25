package bnrand.brnandchapter03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var previousButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_australia, true, false),
        Question(R.string.question_oceans, true, false),
        Question(R.string.question_mideast, false, false),
        Question(R.string.question_africa, false, false),
        Question(R.string.question_americas, true, false),
        Question(R.string.question_asia, true, false),
    )
    private var currentIndex = 0
    private var count = 0
    private var correct = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        previousButton = findViewById(R.id.prev_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener {
            // 버튼클릭의 응답을 여기서 처리한다.
            count++
            trueButton.isEnabled = false
            falseButton.isEnabled = false
            questionBank[currentIndex].answered = true
            checkAnswer(true)
        }
        falseButton.setOnClickListener {
            // 버튼클릭의 응답을 여기서 처리한다.
            count++
            trueButton.isEnabled = false
            falseButton.isEnabled = false
            questionBank[currentIndex].answered = true
            checkAnswer(false)
        }
        // 다음버튼을 누르면 리스트에 있는 다음 문제가 나온다
        nextButton.setOnClickListener {
            val score = String.format("%.2f",(correct.toDouble() / questionBank.size) * 100)
            currentIndex = (currentIndex + 1) % questionBank.size
            isAnswered(currentIndex)
            if (count == questionBank.size)
                Toast.makeText(this, "정답률: ${score}%", Toast.LENGTH_SHORT).show()
            updateQuestion()
        }
        previousButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex = currentIndex - 1
                updateQuestion()
            } else  {
                currentIndex = questionBank.size - 1
                updateQuestion()
            }
        }
        questionTextView.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
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
            correct++
            R.string.correct_toast
        } else {
            R.string.incorrect_tost
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }

    private fun isAnswered(index: Int){
        // 정답이 맞으면 버튼 두개다 비활성화 함함
        if (questionBank[index].answered == true) {
            trueButton.isEnabled = false
            falseButton.isEnabled = false
        } else {
            trueButton.isEnabled = true
            falseButton.isEnabled = true
        }
    }
}