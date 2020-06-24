package fr.clementcaillaud.memokotlin.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import fr.clementcaillaud.memokotlin.R
import fr.clementcaillaud.memokotlin.memo.ItemTouchHelperCallback
import fr.clementcaillaud.memokotlin.memo.MemoAdapter
import fr.clementcaillaud.memokotlin.memo.MemoDTO
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    private lateinit var mainViewModel: MainViewModel
    private lateinit var memoAdapter: MemoAdapter
    private var listeMemos: MutableList<MemoDTO>? = ArrayList()
    private lateinit var itemTouchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ViewModel
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.init(MainRepository())
        listeMemos = mainViewModel.getLiveDataMemo()?.toMutableList()
        //Adapter
        memoAdapter = MemoAdapter(listeMemos!!, this)
        //Recycler view
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this)
        itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(memoAdapter))
        itemTouchHelper.attachToRecyclerView(recyclerview)
        recyclerview.adapter = memoAdapter
    }

    fun ajouterMemo(v: View)
    {
        val nouveauMemo = MemoDTO(inputMemo!!.text.toString())
        listeMemos?.add(nouveauMemo)
        mainViewModel.insertMemo(nouveauMemo)
        recyclerview.adapter?.notifyDataSetChanged()
        inputMemo.text.clear()
    }
}
