package fr.clementcaillaud.memokotlin.memo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import fr.clementcaillaud.memokotlin.R
import fr.clementcaillaud.memokotlin.detail.DetailActivity
import fr.clementcaillaud.memokotlin.detail.DetailFragment
import kotlinx.android.synthetic.main.memo_item_liste.view.*
import org.parceler.Parcels


class MemoAdapter(listeMemos: MutableList<MemoDTO>, main: AppCompatActivity) : RecyclerView.Adapter<MemoAdapter.MemoViewHolder?>()
{
    private var listeMemos: MutableList<MemoDTO> = ArrayList()
    private val main: AppCompatActivity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder
    {
        val viewMemo: View = LayoutInflater.from(parent.context).inflate(R.layout.memo_item_liste, parent, false)
        return MemoViewHolder(viewMemo)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int)
    {
        holder.bind(listeMemos[position])
    }

    override fun getItemCount(): Int
    {
        return listeMemos.size
    }

    fun onItemDismiss(view: RecyclerView.ViewHolder)
    {
        if(view.adapterPosition > -1)
        {
            MemoBDDHelper.getBDD(view.itemView.context).memoDAO().delete(listeMemos[view.adapterPosition])
            listeMemos.removeAt(view.adapterPosition)
            notifyItemRemoved(view.adapterPosition)
        }
    }

    inner class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        init
        {
            //Clic sur un mémo de la liste
            itemView.setOnClickListener{ view ->
                val memo: MemoDTO = listeMemos[adapterPosition]

                //Mode paysage
                if(main.findViewById<View?>(R.id.FragmentLayout) != null)
                {
                    val fragment = DetailFragment()
                    //Passage des paramètres
                    val bundle = Bundle()
                    bundle.putString("contenu", memo.contenu)
                    fragment.arguments = bundle
                    //Ajout du fragment au layout de la main activity
                    val fragmentManager = main.supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.FragmentLayout, fragment, "detail_fragment")
                    fragmentTransaction.commit()
                }
                //Mode portrait
                else
                {
                    val intent = Intent(view.context, DetailActivity::class.java)
                    intent.putExtra("memo", Parcels.wrap(memo))
                    view.context.startActivity(intent)
                }
            }
        }

        fun bind(memo:MemoDTO) = with(itemView)
        {
            //Limitation de la taille du contenu du mémo, dans la liste
            if(memo.contenu.length > 50)
            {
                contenu_memo.text = memo.contenu.replaceRange(47, memo.contenu.length - 1, "...")
            }
            else
            {
                contenu_memo.text = memo.contenu
            }
        }
    }

    init
    {
        this.listeMemos = listeMemos
        this.main = main
    }
}