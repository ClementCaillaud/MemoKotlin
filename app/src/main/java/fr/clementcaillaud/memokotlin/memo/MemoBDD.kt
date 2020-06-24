package fr.clementcaillaud.memokotlin.memo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities=[MemoDTO::class], version=1)
abstract class MemoBDD : RoomDatabase()
{
    abstract fun memoDAO(): MemoDAO
}