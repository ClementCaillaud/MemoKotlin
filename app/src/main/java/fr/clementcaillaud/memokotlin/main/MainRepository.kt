package fr.clementcaillaud.memokotlin.main

import fr.clementcaillaud.memokotlin.di.DIApplication
import fr.clementcaillaud.memokotlin.memo.MemoDAO
import fr.clementcaillaud.memokotlin.memo.MemoDTO
import javax.inject.Inject

class MainRepository
{
    @Inject
    lateinit var memoDAO: MemoDAO

    fun getLiveDataMemo(): List<MemoDTO>
    {
        return memoDAO.getListeMemos()
    }

    fun addMemo(memo: MemoDTO)
    {
        memoDAO.insert(memo)
    }

    fun deleteMemo(memo: MemoDTO)
    {
        memoDAO.delete(memo)
    }

    init
    {
        DIApplication.getAppComponent()?.inject(this)
    }
}