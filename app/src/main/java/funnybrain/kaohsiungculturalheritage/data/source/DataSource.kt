package funnybrain.kaohsiungculturalheritage.data.source

import android.content.Context
import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import io.reactivex.functions.Consumer

interface DataSource {
    fun getData(context: Context, callback: Consumer<List<DataItem>>, error: Consumer<Throwable>)
}