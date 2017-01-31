package kr.co.swkim.kotlin_sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import butterknife.bindView

class MainActivity : AppCompatActivity() {
    val txtvHello: TextView by bindView(R.id.txtv_helloworld)
    val btnConfirm: Button by bindView(R.id.btn_confirm)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtvHello.text ="Hello"
        btnConfirm.text = "클릭"
        btnConfirm.setOnClickListener {
            it ->
            Toast.makeText(this,"clicked",Toast.LENGTH_LONG).show()
            callbackFunction()
        }
    }

    fun callbackFunction(){
        val a = (0..10)
                .filter { it % 2 == 0 }
                .map { it * it }
                .fold("") { s, i ->
                    (if (s != "") s + "_" else "") + i.toString()
                }
        println(a)
    }
}
