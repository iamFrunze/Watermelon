package com.byfrunze.watermelon.fragments

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import com.byfrunze.watermelon.R
import kotlinx.android.synthetic.main.fragment_review.*
import moxy.MvpAppCompatFragment

class ReviewFragment : MvpAppCompatFragment(R.layout.fragment_review) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textReview = arguments?.getString("text")
        val imageReview = arguments?.getInt("image")
        val fragmentId = arguments?.getInt("fragment")

        textReview?.let {
            text_view_review.text = it

        }
        imageReview?.let {
            image_view_review.setImageDrawable(ResourcesCompat.getDrawable(resources, it, null))
        }


        text_view_to_start.setOnClickListener {
            findNavController().navigate(R.id.startFragment)
        }

    }

}