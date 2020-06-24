package fr.clementcaillaud.memokotlin.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import fr.clementcaillaud.memokotlin.R
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment()
{
    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        val contenuMemo = requireArguments().getString("contenu").toString()
        details.setText(contenuMemo)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
}
