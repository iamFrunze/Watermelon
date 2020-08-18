package com.byfrunze.watermelon.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface WatermelonView : MvpView {
    fun startReviewFragment(text: String, imageId: Int)
}