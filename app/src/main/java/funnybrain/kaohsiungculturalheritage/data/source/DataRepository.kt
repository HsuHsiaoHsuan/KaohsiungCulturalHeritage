package funnybrain.kaohsiungculturalheritage.data.source

import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import funnybrain.kaohsiungculturalheritage.restful.DataRequest
import funnybrain.kaohsiungculturalheritage.restful.RestfulApiBuilder
import io.reactivex.functions.Consumer

object DataRepository {
    private var api = RestfulApiBuilder.buildRestfulService()

    fun getItem(callback: Consumer<List<DataItem>>, error: Consumer<Throwable>) {
        DataRequest.performAsyncRequest(api.getData(), callback, error)
    }
}