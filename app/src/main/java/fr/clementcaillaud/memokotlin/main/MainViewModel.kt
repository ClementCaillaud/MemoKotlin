package fr.clementcaillaud.memokotlin.main

import androidx.lifecycle.ViewModel
import fr.clementcaillaud.memokotlin.main.MainRepository
import fr.clementcaillaud.memokotlin.memo.MemoDTO

class MainViewModel : ViewModel()
{
    private lateinit var mainRepository: MainRepository

    fun init(mainRepository: MainRepository)
    {
        this.mainRepository = mainRepository
    }

    fun getLiveDataMemo(): List<MemoDTO>?
    {
        return mainRepository.getLiveDataMemo()
    }

    fun insertMemo(memo: MemoDTO)
    {
        mainRepository.addMemo(memo)
    }
}