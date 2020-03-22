package com.deepak.nasaapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deepak.nasaapp.data.ImageProperty

class SpaceDetailViewModel(imageProperty: ImageProperty): ViewModel() {

  private val _selectedImage = MutableLiveData<ImageProperty>()
    val selectedImage: LiveData<ImageProperty> = _selectedImage

    init {
        _selectedImage.value = imageProperty
    }

}