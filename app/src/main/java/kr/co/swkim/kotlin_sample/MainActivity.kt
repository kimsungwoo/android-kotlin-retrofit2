package kr.co.swkim.kotlin_sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import butterknife.bindView
import kr.co.swkim.kotlin_sample.API.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val txtvHello: TextView by bindView(R.id.txtv_helloworld)
    val btnConfirm: Button by bindView(R.id.btn_confirm)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var txtvHello = findViewById(R.id.txtv_helloworld) as TextView

        txtvHello.text = "HelloWorld"
        btnConfirm.text = "클릭"
        btnConfirm.setOnClickListener {
            it ->
            Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
            callbackFunction()
            doNetwork()
        }

    }

    fun callbackFunction() {
        val a = (0..10)
                .filter { it % 2 == 0 }
                .map { it * it }
                .fold("") { s, i ->
                    (if (s != "") s + "_" else "") + i.toString()
                }
        println(a)
    }


    fun doNetwork() {
        var api = Service.hitRetro()

        api.currentWeather().enqueue(object : Callback<Stats> {
            override fun onResponse(call: Call<Stats>, response: Response<Stats>) {
                txtvHello.text = response.body().mResponse?.data?.arrData?.get(0)?.mStat?.click
                println(response.body().mResponse?.data?.arrData?.get(0)?.mStat?.click)
                println(response.body().mResponse?.data?.arrData?.get(0)?.mStat?.conversion)

                println("성공")
            }

            override fun onFailure(call: Call<Stats>, error: Throwable) {
                txtvHello.text = error.toString()
                println(error.toString())
                println("실패")
            }
        })
    }
}
