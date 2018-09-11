package funnybrain.kaohsiungculturalheritage.data.source

import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import funnybrain.kaohsiungculturalheritage.restful.DataRequest
import funnybrain.kaohsiungculturalheritage.restful.RestfulApiBuilder
import funnybrain.kaohsiungculturalheritage.restful.RestfulApiService
import io.reactivex.functions.Consumer

class DataRepository {
    private val api: RestfulApiService = RestfulApiBuilder.buildRestfulService()

    companion object {
        private var INSTANCE: DataRepository? = null

        fun getInstance(): DataRepository =
                INSTANCE ?: synchronized(this) {
                    DataRepository()
                }
    }

    fun getItem(callback: Consumer<List<DataItem>>, error: Consumer<Throwable>) {
        DataRequest.performAsyncRequest(api.getData(), callback, error)
    }
}