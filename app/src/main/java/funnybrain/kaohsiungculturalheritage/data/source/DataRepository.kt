package funnybrain.kaohsiungculturalheritage.data.source

import android.content.Context
import androidx.annotation.VisibleForTesting
import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import io.reactivex.functions.Consumer

class DataRepository (
        val remoteDataSource: DataSource,
        val localDataSource: DataSource, val context: Context) : DataSource {

    override fun getData(context: Context, callback: Consumer<List<DataItem>>, error: Consumer<Throwable>) {
//        remoteDataSource.getData(context, callback, error)
        localDataSource.getData(context, callback, error)
    }

    companion object {
        private var INSTANCE: DataRepository? = null

        @JvmStatic
        fun getInstance(remoteDataSource: DataSource, localDataSource: DataSource, context: Context): DataRepository {
            return INSTANCE ?: DataRepository(remoteDataSource, localDataSource, context.applicationContext).apply {
                INSTANCE = this
            }
        }

        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}