package com.example.smtlabstask.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smtlabstask.model.PhotosData
import com.example.smtlabstask.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel(){

    init {
        viewModelScope.launch {
            repository.getData()
        }
    }

    val photosLiveData: LiveData<PhotosData> get() = repository.photosLiveD
}