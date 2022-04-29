package bnrand.part2.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import bnrand.part2.Crime

@Database(entities = [ Crime::class ], version=1)
@TypeConverters(CrimeTypeComverters::class)
abstract class CrimeDatabase : RoomDatabase() {

    abstract fun crimeDao(): CrimeDao
}