package com.jaebin.mixded

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.jaebin.mixded.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private var mBinding:ActivityMainBinding?=null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            searchReposList(binding.EditText.text.toString())
            binding.EditText.setText("")

        }

    }

    fun searchReposList(userName:String) {
        var t_String = ""
        val call: Call<List<GitHubRepo>> = RetroFitClass.service.getReposList(userName)
        call.enqueue(
            object : Callback<List<GitHubRepo>> {
                override fun onResponse(call: Call<List<GitHubRepo>>, response: Response<List<GitHubRepo>>) {

                    if(response.isSuccessful){
                        val gitRepos = response.body()!!
                        for (i in 0 until gitRepos.size){
                            t_String+=" "+gitRepos[i].name+ "_" +"언어:" + gitRepos[i].lanuguage + "\n"
                        }
                        binding.textView.text=t_String
                    }

                }

                override fun onFailure(call: Call<List<GitHubRepo>>, t: Throwable) {

                }


            })

    }


}


