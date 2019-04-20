package funnybrain.kaohsiungculturalheritage.data.source.local

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import com.orhanobut.logger.Logger
import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import funnybrain.kaohsiungculturalheritage.data.source.DataSource
import io.reactivex.functions.Consumer
import kotlinx.coroutines.*

class LocalDataSource : DataSource {

    override fun getData(context: Context, callback: Consumer<List<DataItem>>, error: Consumer<Throwable>) = runBlocking<Unit> {
        launch {
            val jsonString = context.assets.open("kaohsiung.json").bufferedReader().use {
                it.readText()
            }

            try {
                val itemType = object : TypeToken<List<DataItem>>() {}.type
                val items = Gson().fromJson<List<DataItem>>(jsonString, itemType)
                callback.accept(items)
            } catch (e: JsonParseException) {
                Logger.e(e.localizedMessage)
                error.accept(e)
            }

        }
    }

    companion object {
        private var INSTANCE: LocalDataSource? = null

        @JvmStatic
        fun getInstance(): LocalDataSource {
            if (INSTANCE == null) {
                synchronized(LocalDataSource::javaClass) {
                    INSTANCE = LocalDataSource()
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