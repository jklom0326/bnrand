package bnrand.part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), CrimeListFragment.CallBacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            val fragment = CrimeListFragment.newInstance()
            // 프래그먼트 트랜잭션을 생성하고 커밋한다.
            supportFragmentManager
                .beginTransaction()  // 새로운 프래그먼트 트랜잭션 인스턴스를 생성하고
                .add(R.id.fragment_container, fragment) // 이 인스턴스에 add()오퍼레이션을 포함시킨후
                .commit() // 커밋해라
        }
    }

    override fun onCrimeSelected(crimeId: UUID) {
        val fragment = CrimeFragment.newInstance(crimeId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // 트랜잭션에 백스택을 추가해 백버튼을 누를때마다 트랜잭션이 취소된다.
            .commit()
    }
}