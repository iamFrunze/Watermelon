package com.byfrunze.watermelon.presenters

import com.byfrunze.watermelon.providers.CircleWatermelonProvider
import com.byfrunze.watermelon.views.WatermelonView
import moxy.MvpPresenter

class CircleWatermelonPresenter : MvpPresenter<WatermelonView>() {
    fun loadResults(weight: Float?, l: String) {
        CircleWatermelonProvider(this).loadReview(weight = weight, l = l)
    }

    fun answer(text: String, imageId: Int) {
        viewState.startReviewFragment(text = text, imageId = imageId)
    }


}