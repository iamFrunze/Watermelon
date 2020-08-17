package com.byfrunze.watermelon.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface WatermelonView : MvpView {
    fun changeText(text: String)
    fun chaneImage(id: Int)
}