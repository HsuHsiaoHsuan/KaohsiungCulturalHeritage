package funnybrain.kaohsiungculturalheritage.data.source.remote

import android.content.Context
import androidx.annotation.VisibleForTesting
import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import funnybrain.kaohsiungculturalheritage.data.source.DataSource
import funnybrain.kaohsiungculturalheritage.restful.DataRequest
import funnybrain.kaohsiungculturalheritage.restful.RestfulApiBuilder
import io.reactivex.functions.Consumer

class RemoteDataSource : DataSource {
    private var api = RestfulApiBuilder.buildRestfulService()

    override fun getData(context: Context, callback: Consumer<List<DataItem>>, error: Consumer<Throwable>) {
        DataRequest.performAsyncRequest(api.getData(), callback, error)
    }

    companion object {
        private var INSTANCE: RemoteDataSource? = null

        @JvmStatic
        fun getInstance(): RemoteDataSource {
            if (INSTANCE == null) {
                synchronized(RemoteDataSource::javaClass) {
                    INSTANCE = RemoteDataSource()
                }
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}