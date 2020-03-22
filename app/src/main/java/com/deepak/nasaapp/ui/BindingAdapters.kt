package com.deepak.nasaapp.ui

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.deepak.nasaapp.ImageStatus
import com.deepak.nasaapp.R
import com.deepak.nasaapp.data.ImageProperty
import com.deepak.nasaapp.ui.overview.SpaceImagesGridAdapter

@BindingAdapter("imgUrl")
fun bindImage(view: ImageView, url: String?){

    url?.let {
     val imgUri = url.toUri().buildUpon().scheme("https").build()

        Glide.with(view.context)
            .load(imgUri).apply { Log.i("Glide", "$imgUri") }
            .apply (
                RequestOptions().error(R.drawable.ic_broken_image)
                    .placeholder(R.drawable.loading_animation))
            .into(view)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ImageProperty>?){

    (recyclerView.adapter as SpaceImagesGridAdapter).submitList(data)
}

@BindingAdapter("imageStatus")
fun bindImageStatus(imageView: ImageView, status: ImageStatus){

  when(status){
      ImageStatus.LOADING -> {
          imageView.visibility = View.VISIBLE
          imageView.setImageResource(R.drawable.loading_animation)
      }
      ImageStatus.ERROR -> {
          imageView.visibility = View.VISIBLE
          imageView.setImageResource(R.drawable.ic_broken_image)
      }
      ImageStatus.DONE -> imageView.visibility = View.GONE
  }
}