package funnybrain.kaohsiungculturalheritage.restful

import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import io.reactivex.Observable
import retrofit2.http.GET

interface RestfulApiService {

    @GET("public/OD_Heritage.ashx")
    fun getData(): Observable<List<DataItem>>

    companion object {
        val API_HOST = "http://opendata.khcc.gov.tw/"
    }
}

// http://opendata.khcc.gov.tw/public/OD_Heritage.ashx