package com.example.smtlabstask.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.smtlabstask.model.PhotosData
import com.example.taskappstean.api.ApiService

class MainRepository(private val apiService: ApiService) {

    private val photosMutableLiveData = MutableLiveData<PhotosData>()
    val photosLiveD: LiveData<PhotosData> get() = photosMutableLiveData


    suspend fun getData() {
        val result = apiService.getData()
        if (result.body() != null) {
            photosMutableLiveData.postValue(result.body())
        }

    }








}