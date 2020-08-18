package com.byfrunze.watermelon.providers

import android.util.Log
import com.byfrunze.watermelon.data.tableL
import com.byfrunze.watermelon.presenters.OvalWatermelonPresenter
import com.byfrunze.watermelon.utils.Images.*
import com.byfrunze.watermelon.utils.createMapCircle
import com.byfrunze.watermelon.utils.createMapOval
import java.text.DecimalFormat
import kotlin.math.abs
import kotlin.math.pow

class OvalWatermelonProvider(private val presenter: OvalWatermelonPresenter) {


    fun loadReview(weight: Float?, sl: String, bl: String) {
        if (check(sl, bl))
            checkWatermelon(sl.toInt(), bl.toInt(), weight)
        else
            presenter.answer(text = "Введите корректное значение", imageId = DEFAULT.id)
    }

    private fun checkWatermelon(sl: Int, bl: Int, weight: Float?) {
        val d = DecimalFormat("#.##")
        val R1 = (sl / 6.2831).pow(2).toFloat()
        val R2 = (bl / 6.2831).toFloat()
        val V = (5.5851 * R1 * R2).toFloat()


        val mMap = createMapOval()
        val newV = d.format(V).toFloat()

        val keySet = mMap.keys
        var indexOfL = 0
        val minV = findMin(newV, keySet)
        if (mMap.containsKey(minV))
            indexOfL = mMap.getValue(minV)
        else {
            presenter.answer(text = "Введите корректные значения", imageId = DEFAULT.id)
            return
        }


        val L = tableL[indexOfL]

        Log.i("RESULT", "1 $L - L\n" +
                " $minV - minV \n" +
                " $indexOfL - indexOfL")

        when {
            L < 45 -> {
                presenter.answer(
                    text = "Э! Положи. Это не арбуз, это крупный виноград.",
                    imageId = UNDER.id
                )
                return
            }

            L > 99 -> {
                presenter.answer(
                    text = "О-О! Такой большой! Зачем он тебе? Этот арбуз что с детства лечили!",
                    imageId = UNDER.id
                )
                return
            }
        }
        val mCircleMap = createMapCircle()
        val perfectWeight = mCircleMap.getValue(L)
        val percent = (perfectWeight / 100 * 10)

        val goodWeightMinus = mCircleMap[L]?.minus(percent)
        val goodWeightPlus = mCircleMap[L]?.plus(percent)

        Log.i("RESULT", "$L - L \n $minV - minV \n $indexOfL - indexOfL \n " +
                "$perfectWeight - perfect weight")

        when {
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
            else -> {
                presenter.answer(
                    text = "Введите корректные значения",
                    imageId = DEFAULT.id
                )
                return
            }
        }


    }

    private fun check(sl: String, bl: String): Boolean {
        return sl.matches("[\\d]+".toRegex()) && bl.matches("[\\d]+".toRegex())
    }

    private fun findMin(v: Float, currentV: Set<Float>): Float {
        var currentMin = 0f
        var maxMin = 100_000f
        var index = 0f

        for (i in currentV) {
            currentMin = abs(v - i)
            if (currentMin < maxMin) {
                maxMin = currentMin
                index = i
            }
        }
        return index
    }
}