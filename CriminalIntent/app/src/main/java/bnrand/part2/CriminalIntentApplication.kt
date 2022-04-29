package bnrand.part2

import android.app.Application

class CriminalIntentApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initalize(this)
    }
}