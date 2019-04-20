package funnybrain.kaohsiungculturalheritage.data

import android.content.Context
import funnybrain.kaohsiungculturalheritage.data.source.DataRepository
import funnybrain.kaohsiungculturalheritage.data.source.local.LocalDataSource
import funnybrain.kaohsiungculturalheritage.data.source.remote.RemoteDataSource

object Injection {
    fun provideDataRepository(context: Context): DataRepository {
        return DataRepository.getInstance(RemoteDataSource.getInstance(), LocalDataSource.getInstance(), context)
    }
}