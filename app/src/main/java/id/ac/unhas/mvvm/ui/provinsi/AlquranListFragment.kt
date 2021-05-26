package id.ac.unhas.mvvm.ui.provinsi


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.mvvm.R
//import id.ac.unhas.mvvm.model.DataProvinsiItem
//import id.ac.unhas.mvvm.model.Provinsi
import id.ac.unhas.mvvm.model.Quran

class AlquranListFragment : Fragment() {

    companion object {
        fun newInstance() = AlquranListFragment()
    }

    private lateinit var viewModel: AlquranViewModel
    private lateinit var viewModelFactory: ProvinsiViewModelFactory

    private lateinit var recyclerView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        viewModelFactory =ProvinsiViewModelFactory(AlquranRepository())

        viewModel = ViewModelProvider(this,viewModelFactory).get(AlquranViewModel::class.java)
        return inflater.inflate(R.layout.provinsilist_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MainFragment","createView")
        recyclerView = view.findViewById(R.id.recycler_view_provinsi)

        viewModel.getProvinsisFromRepo().observe(viewLifecycleOwner, Observer<ArrayList<Quran>> { dataAlquran ->
            recyclerView.adapter = context?.let {
                ArrayAdapter(
                    it,
                    R.layout.listview_item_provinsi,
                    toListOfStrings(dataAlquran)
                )
            }
        })
    }

    private fun toListOfStrings(dataAlquran: List<Quran?>?) : Array<String?> {
        val listItems = arrayOfNulls<String>(dataAlquran?.size ?: 0)

        dataAlquran?.forEachIndexed { index, quran ->
            listItems[index] = "Nama: ${quran?.nama.toString()}\n"+
                               "asma: ${quran?.asma.toString()}\n"+
                               "Surah ke: ${quran?.nomor.toString()}"
        }

        return listItems
    }

}