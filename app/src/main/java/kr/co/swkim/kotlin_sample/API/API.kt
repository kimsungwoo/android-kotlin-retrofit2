package kr.co.swkim.kotlin_sample.API

import kr.co.swkim.kotlin_sample.Stats
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by swkim on 2017-02-01.
 */

interface API {
    interface GETDATA {
        @GET("json?NetworkId=adwayskorea&NetworkToken=NETwU6uln8Fw3KPSI6pSbwTa3jLyRT&Target=Report&Method=getStats&fields[]=Stat.clicks&fields[]=Stat.conversions&filters[Stat.offer_id][conditional]=EQUAL_TO&filters[Stat.offer_id][values]=1048")
        fun currentWeather(): Call<Stats>
//        fun currentWeather(@Path("data_start") dataStart: String,
//                           @Path("data_end") dataEnd: String): Call<Stats>
    }

    companion object {
        val BASE_URL = "http://api.hasoffers.com/Apiv3/"
    }
}
