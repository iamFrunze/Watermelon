package com.byfrunze.watermelon.presenters

import com.byfrunze.watermelon.providers.OvalWatermelonProvider
import com.byfrunze.watermelon.views.WatermelonView
import moxy.MvpPresenter

class OvalWatermelonPresenter : MvpPresenter<WatermelonView>() {
    fun loadResults(weight: Float?, sl: String, bl: String) {
        OvalWatermelonProvider(this).loadReview(weight = weight, sl = sl, bl = bl)

    }

    fun answer(text: String, imageId: Int) {
        viewState.startReviewFragment(text = text, imageId = imageId)
    }


}