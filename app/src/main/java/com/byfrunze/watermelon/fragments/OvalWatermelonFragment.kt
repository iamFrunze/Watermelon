package com.byfrunze.watermelon.fragments

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.byfrunze.watermelon.R
import com.byfrunze.watermelon.presenters.OvalWatermelonPresenter
import com.byfrunze.watermelon.views.WatermelonView
import kotlinx.android.synthetic.main.fragment_oval_watermelon.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class OvalWatermelonFragment : MvpAppCompatFragment(R.layout.fragment_oval_watermelon),
    WatermelonView {

    @InjectPresenter
    lateinit var presenter: OvalWatermelonPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val weight = arguments?.getFloat("weight")

        btn_review_oval.setOnClickListener {
            val sl = edit_text_sl_oval.text.toString()
            val bl = edit_text_bl_oval.text.toString()
            presenter.loadResults(weight = weight, sl = sl, bl = bl)
        }

    }

    override fun changeText(text: String) {
        text_view_review_oval.text = text
    }

    override fun chaneImage(id: Int) {
        image_view_oval.setImageDrawable(ResourcesCompat.getDrawable(resources, id, null))
    }

}