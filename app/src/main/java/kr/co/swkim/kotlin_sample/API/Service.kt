package kr.co.swkim.kotlin_sample.API

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by swkim on 2017-02-01.
 */
object Service {
    fun hitRetro(): API.GETDATA {

        val builder = Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API.BASE_URL)


        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val request = chain.request()
                            .newBuilder()
                            .build()
                    chain.proceed(request)
                }
                .addInterceptor(logging).build()
        builder.client(client)

        return builder
                .build()
                .create(API.GETDATA::class.java)
    }
}
