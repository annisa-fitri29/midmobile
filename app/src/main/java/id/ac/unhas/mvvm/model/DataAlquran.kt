package id.ac.unhas.mvvm.model

//URL JSON : https://api.kawalcorona.com/indonesia/provinsi
class DataAlquran : ArrayList<Quran>()
//https://api.npoint.io/99c279bb173a6e28359c/data
data class DataPovinsiItem(
    val attributes: Quran?
)
//DataProvinsiItem = Provinsi
data class Quran(
    val nama: String?,
    val ayat: Int?,
    val urut: Int?,
    val nomor: Int?,
    val asma: String?,
    val arti: String?
)
