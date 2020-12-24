package com.example.anggotaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.anggotaapp.Adapter.DataAdapter
import com.example.anggotaapp.Config.NetworkModule
import com.example.anggotaapp.Model.getData.DataItem
import com.example.anggotaapp.Model.getData.ResponseGetData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener{
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }
        showData()

    }

private fun showData(){
    val listAnggota = NetworkModule.service().getData()
    listAnggota.enqueue(object :Callback<ResponseGetData>{
        override fun onResponse(
            call: Call<ResponseGetData>,
            response: Response<ResponseGetData>
        ) {
            if (response.isSuccessful){
                val item = response.body()?.data

                val adapter = DataAdapter(item, object : DataAdapter.OnClickListener{
                    override fun detail(item: DataItem?) {

                    }

                })

                list.adapter = adapter
            }
        }

        override fun onFailure(call: Call<ResponseGetData>, t: Throwable) {
            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
        }

    })
}

    override fun onResume() {
        super.onResume()
        showData()
    }

}
