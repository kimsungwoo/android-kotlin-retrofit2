package kr.co.swkim.kotlin_sample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by swkim on 2017-02-01.
 */

public class Stats{
    @SerializedName("request")
    request mRequest;

    @SerializedName("response")
    response mResponse;
    public class request {

    }

    public class response {
        @SerializedName("status")
        int status;
        @SerializedName("httpStatus")
        int httpStatus;

        @SerializedName("data")
        data data;
    }


    public class data{
        @SerializedName("Stat")
        stat stat;
    }
    public class stat{
        @SerializedName("clicks")
        String click;
        @SerializedName("conversions")
        String conversion;
    }

    public response getResponse(){
        return this.mResponse;
    }

}
