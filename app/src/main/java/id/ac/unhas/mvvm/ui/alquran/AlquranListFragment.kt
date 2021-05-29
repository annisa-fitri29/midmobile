package id.ac.unhas.mvvm.ui.alquran


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.unhas.mvvm.R
import id.ac.unhas.mvvm.model.Quran

import kotlinx.android.synthetic.main.recyclerview_fragment.*

class AlquranListFragment : Fragment() {

    companion object {
        fun newInstance() = AlquranListFragment()
    }

    private lateinit var viewModel: AlquranViewModel
    private lateinit var viewModelFactory: AlquranViewModelFactory
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.recyclerview_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MainFragment","createView")

        viewModelFactory =AlquranViewModelFactory(AlquranRepository())
        viewModel = ViewModelProvider(this,viewModelFactory).get(AlquranViewModel::class.java)

        linearLayoutManager= LinearLayoutManager(context)
        recylerview_id.layoutManager = linearLayoutManager


        viewModel.getQuranFromRepo().observe(viewLifecycleOwner,{ data ->
            recylerview_id.also{
                recylerview_id.adapter = Adapter(data)
            }
        })


    }
    private fun generateDummyList(size: Int): List<Quran> {
        val list = ArrayList<Quran>()
        for (i in 0 until size) {

            val item = Quran("$i ", i,i,i,"Name test $i ","Name test $i ")
            list += item
        }
        return list
    }

}

