package com.example.anggotaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.anggotaapp.Config.NetworkModule
import com.example.anggotaapp.Model.action.ResponseAction
import kotlinx.android.synthetic.main.activity_input.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        btnSimpan.setOnClickListener {
            inputData(etNama.text.toString(), etNoHp.text.toString(), etAlamat.text.toString())
        }

        btnHapus.setOnClickListener{
            finish()
        }


    }
    private fun inputData(nama: String?, nohp: String?, alamat: String?){

        val input = NetworkModule.service().insertData(nama?: "", nohp?: "", alamat?: "")
        input.enqueue(object : Callback<ResponseAction>{
            override fun onResponse(call: Call<ResponseAction>,
                                    response: Response<ResponseAction>
            ) {
                Toast.makeText(applicationContext, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
                finish()
            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }

        })

    }

}

