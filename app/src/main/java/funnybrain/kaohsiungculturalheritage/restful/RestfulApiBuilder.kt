package funnybrain.kaohsiungculturalheritage.restful

import funnybrain.kaohsiungculturalheritage.restful.RestfulApiService.Companion.API_HOST
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RestfulApiBuilder {
    fun buildRestfulService(): RestfulApiService {
        val restful = Retrofit.Builder()
                .baseUrl(API_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()

        return restful.create(RestfulApiService::class.java)
    }
}