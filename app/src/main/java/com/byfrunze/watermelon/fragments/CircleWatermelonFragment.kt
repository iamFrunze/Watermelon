package com.byfrunze.watermelon.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.byfrunze.watermelon.R
import com.byfrunze.watermelon.presenters.CircleWatermelonPresenter
import com.byfrunze.watermelon.views.WatermelonView
import kotlinx.android.synthetic.main.fragment_circle_watermelon.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class CircleWatermelonFragment : MvpAppCompatFragment(R.layout.fragment_circle_watermelon),
    WatermelonView {
    val STORAGE_NAME = "SETTINGS"

    @InjectPresenter
    lateinit var presenter: CircleWatermelonPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // val weight = arguments?.getFloat("weight")
        val sharedPref = requireContext().getSharedPreferences(
            STORAGE_NAME, Context.MODE_PRIVATE
        )
        val editor = sharedPref.edit()

        val weight = sharedPref.getString("weight", "0")
        editor.apply()
        Log.i("RES", "$weight")

        btn_review_circle.setOnClickListener {
            val l = edit_text_l.text.toString()
            presenter.loadResults(weight = weight?.toFloat(), l = l)
        }


    }


    override fun startReviewFragment(text: String, imageId: Int) {
        val bundle = Bundle()
        bundle.putInt("image", imageId)
        bundle.putString("text", text)
        bundle.putInt("fragment", R.id.circleWatermelonFragment)
        findNavController().navigate(R.id.reviewFragment, bundle)
    }
}