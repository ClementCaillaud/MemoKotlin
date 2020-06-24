package fr.clementcaillaud.memokotlin.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import fr.clementcaillaud.memokotlin.R
import fr.clementcaillaud.memokotlin.memo.MemoDTO
import org.parceler.Parcels

class DetailActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val memo = Parcels.unwrap<MemoDTO>(intent.getParcelableExtra("memo"))

        val fragment = DetailFragment()
        val bundle = Bundle()
        bundle.putString("contenu", memo.contenu)
        fragment.arguments = bundle

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.conteneur_fragment, fragment, "transactionFragment")
        fragmentTransaction.commit()
    }
}
