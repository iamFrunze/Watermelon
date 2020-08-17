package com.byfrunze.watermelon.providers

import com.byfrunze.watermelon.presenters.CircleWatermelonPresenter
import com.byfrunze.watermelon.utils.Images.*
import com.byfrunze.watermelon.utils.createMapCircle
import kotlin.math.pow

class CircleWatermelonProvider(private val presenter: CircleWatermelonPresenter) {


    fun loadReview(weight: Float?, l: String) {
        if (l.matches("[\\d]+".toRegex()))
            when {
                l.toInt() < 45 -> {
                    presenter.answer(
                        text = "Э! Положи. Это не арбуз, это крупный виноград.",
                        imageId = UNDER.id
                    )
                    return
                }
                l.toInt() > 99 -> {
                    presenter.answer(
                        text = "О-О! Такой большой! Зачем он тебе? Этот арбуз что с детства лечили!",
                        imageId = UNDER.id
                    )
                    return
                }
                else -> checkWatermelon(l.toInt(), weight)
            }
        else presenter.answer(text = "Введите корректные значения", imageId = DEFAULT.id)

    }

    private fun checkWatermelon(l: Int, weight: Float?) {
        val mMap = createMapCircle()
        val resM = 0.017 * l.toDouble().pow(3.toDouble()) / 1000
        val percent = (resM / 100 * 10).toFloat()

        val goodWeightMinus = mMap[l]?.minus(percent)
        val goodWeightPlus = mMap[l]?.plus(percent)

        return when {
            (weight!! > goodWeightMinus!!) && (weight < goodWeightPlus!!) -> {
                presenter.answer(
                    text = "Да, скорее всего это спелый арбуз, берите. Надо попробовать на сколько он сладкий",
                    imageId = GOOD.id
                )
                return
            }

            (weight < goodWeightMinus) -> {
                presenter.answer(
                    text = "Наверное это хороший арбуз, но съесть его надо сегодня, может быть переспелый",
                    imageId = OVERRIPE.id
                )
                return
            }

            (weight > goodWeightPlus!!) -> {
                presenter.answer(
                    text = "Э! Положи арбуз. Пока он зеленый",
                    imageId = GREEN.id
                )
                return
            }

            else -> presenter.answer(text = "Введите корректные значения", imageId = DEFAULT.id)
        }
    }
}