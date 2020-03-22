package com.deepak.nasaapp.ui.overview

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deepak.nasaapp.ImageStatus
import com.deepak.nasaapp.data.ImageProperty
import com.deepak.nasaapp.loadJSONFromAsset
import com.deepak.nasaapp.processDataToList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject

class SpaceViewModel(application: Application) : AndroidViewModel(application) {

    // The internal MutableLiveData String that stores the most recent response
    private val _image = MutableLiveData<List<ImageProperty>>()

    // The external immutable LiveData for the response String
    val image: LiveData<List<ImageProperty>>
        get() = _image

    private val _status = MutableLiveData<ImageStatus>()
    val status: LiveData<ImageStatus>
        get() = _status

    private val _navigateToDetailFrag = MutableLiveData<ImageProperty>()
    val navigateToDetailFrag: LiveData<ImageProperty> = _navigateToDetailFrag

    // Coroutine to load json from assets
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    init {
        _status.value = ImageStatus.LOADING
        try {

            uiScope.launch {
                val jsonObject = JSONObject(loadJSONFromAsset(application))

                val spaceArray = jsonObject.getJSONArray("space")

                _status.value = ImageStatus.DONE
                _image.value = processDataToList(spaceArray)

                Log.i("SpaceVM", _image.value.toString())
            }

        } catch (exception: JSONException) {
            exception.printStackTrace()

            _status.value = ImageStatus.ERROR
        }


    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}