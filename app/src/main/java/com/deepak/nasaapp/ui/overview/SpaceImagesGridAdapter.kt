package com.deepak.nasaapp.ui.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.deepak.nasaapp.data.ImageProperty
import com.deepak.nasaapp.databinding.GridViewItemBinding
import com.deepak.nasaapp.ui.overview.ImagePropertyViewHolder.Companion.from

class SpaceImagesGridAdapter: ListAdapter<ImageProperty, ImagePropertyViewHolder>(
    DiffUtilCallBack
) {

    companion object DiffUtilCallBack : DiffUtil.ItemCallback<ImageProperty>(){

        override fun areItemsTheSame(oldItem: ImageProperty, newItem: ImageProperty): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ImageProperty, newItem: ImageProperty): Boolean {
            return  oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = from(parent)


    override fun onBindViewHolder(holder: ImagePropertyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ImagePropertyViewHolder(val gridViewItemBinding: GridViewItemBinding):
    RecyclerView.ViewHolder(gridViewItemBinding.root){

    companion object{

        fun from(parent: ViewGroup) =
            ImagePropertyViewHolder(
                GridViewItemBinding
                    .inflate(LayoutInflater.from(parent.context))
            )

    }

     fun bind(imageProperty: ImageProperty){
        gridViewItemBinding.property = imageProperty
         gridViewItemBinding.executePendingBindings()
     }
}


