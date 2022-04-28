package bnrand.part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
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
}