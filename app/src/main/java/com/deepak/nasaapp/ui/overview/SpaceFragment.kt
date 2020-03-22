package com.deepak.nasaapp.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.deepak.nasaapp.databinding.FragmentOverviewBinding

class SpaceFragment: Fragment() {


    private val viewModel : SpaceViewModel by lazy {
         ViewModelProviders.of(this).get(SpaceViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentOverviewBinding.inflate(inflater)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.imageGrid.adapter =
            SpaceImagesGridAdapter()

        return binding.root
    }
}