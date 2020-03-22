package com.deepak.nasaapp

import android.content.Context
import android.content.res.AssetManager
import com.deepak.nasaapp.data.ImageProperty
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import java.io.IOException

/**
* loading json from assets folder
*/


fun processDataToList(jsonArray: JSONArray): ArrayList<ImageProperty>
        = Gson().fromJson(jsonArray.toString(), object : TypeToken<ArrayList<ImageProperty>>() {}.type)

/*fun <T> processDataToList(data:JSONArray):List<T>{
    return Gson().fromJson(data.toString(), object: TypeToken<List<T>>() {}.type)
}*/


fun loadJSONFromAsset(context: Context): String ? {

    var json: String? = null
    val charset = Charsets.UTF_8

    try{

        val asset  = context.assets.open("space.json")
        val buffer = ByteArray(asset.available())
        asset.read(buffer)
        asset.close()

        json = String(buffer, charset)
    }catch (exception: IOException){
        exception.printStackTrace()
        return null
    }
    return json
}