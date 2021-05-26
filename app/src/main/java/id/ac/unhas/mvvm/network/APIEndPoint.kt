package id.ac.unhas.mvvm.network

import id.ac.unhas.mvvm.model.DataAlquran
import retrofit2.Call
import retrofit2.http.GET
//https://api.npoint.io/99c279bb173a6e28359c/data
interface ApiEndPoint {
    @GET("data") //full url : https://api.kawalcorona.com/indonesia/provinsi
    fun getDataProvinsi(): Call<DataAlquran>
}