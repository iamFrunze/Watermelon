package com.byfrunze.watermelon.fragments

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.byfrunze.watermelon.R
import com.byfrunze.watermelon.presenters.CircleWatermelonPresenter
import com.byfrunze.watermelon.views.WatermelonView
import kotlinx.android.synthetic.main.fragment_circle_watermelon.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class CircleWatermelonFragment : MvpAppCompatFragment(R.layout.fragment_circle_watermelon),
    WatermelonView {

    @InjectPresenter
    lateinit var presenter: CircleWatermelonPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val weight = arguments?.getFloat("weight")

        btn_review_circle.setOnClickListener {
            val l = edit_text_l.text.toString()
            presenter.loadResults(weight = weight, l = l)

        }


    }

    override fun changeText(text: String) {
        text_view_review_circle.text = text
    }

    override fun chaneImage(id: Int) {
        image_view_circle.setImageDrawable(ResourcesCompat.getDrawable(resources, id, null))
    }

}