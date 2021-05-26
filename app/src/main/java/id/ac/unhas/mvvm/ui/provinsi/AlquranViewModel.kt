package id.ac.unhas.mvvm.ui.provinsi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//import id.ac.unhas.mvvm.model.DataProvinsiItem
import id.ac.unhas.mvvm.model.Quran


class AlquranViewModel(
    private val repository: AlquranRepository
) : ViewModel() {
    private var _alquran = ArrayList<Quran>()
    val alquran:ArrayList<Quran>
        get() = _alquran

    fun getProvinsisFromRepo(): MutableLiveData<ArrayList<Quran>> {
        return repository.getProvinsiFromApi()
    }

    override fun onCleared() {
        super.onCleared()
        _alquran.clear()
    }
}