package com.example.smtlabstask

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smtlabstask.adapter.RecyclerVAdapter
import com.example.smtlabstask.model.PhotosData
import com.example.smtlabstask.repository.MainRepository
import com.example.smtlabstask.viewModel.MainViewModel
import com.example.smtlabstask.viewModel.MainViewModelFactory
import com.example.taskappstean.api.ApiService
import com.example.taskappstean.api.RetrofitHelper
import okhttp3.internal.format

class MainActivity : AppCompatActivity() {


    private lateinit var mainRepository: MainRepository
    private lateinit var mainViewModel: MainViewModel

    private var dataList = ArrayList<PhotosData>()

    private lateinit var adapter: RecyclerVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        mainRepository = MainRepository(apiService)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(mainRepository)).get(MainViewModel::class.java)



        mainViewModel.photosLiveData.observe(this) {

            Log.e("PhotoData>> ",it.toString())

            for (obj in it){
                val photosData = PhotosData()
                photosData.add(obj)
                dataList.add(photosData)
            }

            val recyclerview = findViewById<RecyclerView>(R.id.recyclerV)

            recyclerview.layoutManager = LinearLayoutManager(this)


            adapter = RecyclerVAdapter(dataList)

            recyclerview.adapter = adapter

        }


    }
}