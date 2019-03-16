package funnybrain.kaohsiungculturalheritage.restful

import funnybrain.kaohsiungculturalheritage.restful.RestfulApiService.Companion.API_HOST
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import com.orhanobut.logger.Logger
import java.util.concurrent.TimeUnit


object RestfulApiBuilder {
    fun buildRestfulService(): RestfulApiService {

        val logging = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Logger.e(message)
            }
        })
        logging.level = HttpLoggingInterceptor.Level.BODY
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(logging)
                .build()

        val restful = Retrofit.Builder()
                .baseUrl(API_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()

        return restful.create(RestfulApiService::class.java)
    }
}