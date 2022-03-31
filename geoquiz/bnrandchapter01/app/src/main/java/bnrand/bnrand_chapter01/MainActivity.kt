package bnrand.bnrand_chapter01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private val falseButton: Button by lazy{
        findViewById(R.id.false_button)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toastCorret = Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT)
        val toastinCorret = Toast.makeText(this, R.string.incorrect_tost, Toast.LENGTH_SHORT)

        trueButton = findViewById(R.id.true_button)
        trueButton.setOnClickListener {
            // 버튼클릭의 응답을 여기서 처리한다.
                toastCorret.setGravity(Gravity.TOP,Gravity.CENTER,Gravity.CENTER)
                toastCorret.show()
        }
        falseButton.setOnClickListener {
            // 버튼클릭의 응답을 여기서 처리한다.
                toastinCorret.show()
        }
    }
}