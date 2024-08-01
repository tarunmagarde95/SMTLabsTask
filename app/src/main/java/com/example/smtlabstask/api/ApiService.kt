package com.example.taskappstean.api

import com.example.smtlabstask.model.PhotosData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun getData() : Response<PhotosData>

}