package fr.clementcaillaud.memokotlin.memo

import android.content.Context
import androidx.room.Room

class MemoBDDHelper(context: Context)
{
    companion object
    {
        private var bddHelper: MemoBDDHelper? = null
        private lateinit var bdd: MemoBDD

        @Synchronized
        fun getBDD(c: Context): MemoBDD
        {
            if(bddHelper == null)
            {
                bddHelper = MemoBDDHelper(c.applicationContext)
            }
            return bdd
        }
    }

    init
    {
        bdd = context.let{
            Room.databaseBuilder(it, MemoBDD::class.java, "memoKotlin.db").allowMainThreadQueries().build()
        }
    }
}