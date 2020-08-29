package com.byfrunze.watermelon.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.byfrunze.watermelon.R
import com.byfrunze.watermelon.presenters.OvalWatermelonPresenter
import com.byfrunze.watermelon.views.WatermelonView
import kotlinx.android.synthetic.main.fragment_oval_watermelon.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class OvalWatermelonFragment : MvpAppCompatFragment(R.layout.fragment_oval_watermelon),
    WatermelonView {
    val STORAGE_NAME = "SETTINGS"

    @InjectPresenter
    lateinit var presenter: OvalWatermelonPresenter

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
        btn_review_oval.setOnClickListener {
            val sl = edit_text_sl_oval.text.toString()
            val bl = edit_text_bl_oval.text.toString()
            presenter.loadResults(weight = weight?.toFloat(), sl = sl, bl = bl)
        }

    }

    override fun startReviewFragment(text: String, imageId: Int) {
        val bundle = Bundle()
        bundle.putInt("image", imageId)
        bundle.putString("text", text)
        bundle.putInt("fragment", R.id.ovalWatermelonFragment)

        findNavController().navigate(R.id.reviewFragment, bundle)
    }
}