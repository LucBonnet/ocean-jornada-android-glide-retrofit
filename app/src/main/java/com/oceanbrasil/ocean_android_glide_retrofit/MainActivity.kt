package com.oceanbrasil.ocean_android_glide_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.ivAvatar)
        Glide.with(this).load("https://img.itdg.com.br/tdg/images/recipes/000/031/593/318825/318825_original.jpg").into(imageView)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GitHubService::class.java)

        val repos: Call<List<Repo?>?>? = service.listRepos("octocat")

        repos?.enqueue(object : Callback<List<Repo?>?> {
            override fun onResponse(call: Call<List<Repo?>?>, response: Response<List<Repo?>?>) {
                if (response.isSuccessful) {
                    val body = response.body()
                }
            }

            override fun onFailure(call: Call<List<Repo?>?>, t: Throwable) {

            }

        })
    }
}
