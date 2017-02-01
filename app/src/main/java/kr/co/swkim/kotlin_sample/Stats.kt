package kr.co.swkim.kotlin_sample

import com.google.gson.annotations.SerializedName

/**
 * Created by swkim on 2017-02-01.
 */
class Stats {
    @SerializedName("request")
    internal var mRequest: request? = null

    @SerializedName("response")
    var mResponse: response? = null
        internal set

    inner class request

    inner class response {
        @SerializedName("status")
        internal var status: Int = 0
        @SerializedName("httpStatus")
        internal var httpStatus: Int = 0

        @SerializedName("data")
        var data: responseData? = null
    }

    inner class responseData {
        internal var page: Int? = null
        internal var current: Int? = null
        @SerializedName("data")
        var arrData: List<data>? = null
    }

    inner class data {
        @SerializedName("Stat")
        var mStat: stat? = null
    }
    inner class stat {
        @SerializedName("clicks")
        var click: String? = null
        @SerializedName("conversions")
        var conversion: String? = null
    }
}