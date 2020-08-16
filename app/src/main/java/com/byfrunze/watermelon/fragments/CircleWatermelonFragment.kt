package com.byfrunze.watermelon.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.byfrunze.watermelon.R
import com.byfrunze.watermelon.utils.createMapCircle
import kotlinx.android.synthetic.main.fragment_circle_watermelon.*
import kotlin.math.pow

class CircleWatermelonFragment : Fragment(R.layout.fragment_circle_watermelon) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val weight = arguments?.getFloat("weight")

        btn_review_circle.setOnClickListener {
            val l = edit_text_l.text.toString()

            if (l.matches("[\\d]+".toRegex()))
                when {
                    l.toInt() < 45 -> {
                        text_view_review.text = "Э! Положи. Это не арбуз, это крупный виноград."
                    }
                    l.toInt() > 99 -> {
                        text_view_review.text =
                            "О-О! Такой большой! Зачем он тебе? Этот арбуз что с детства лечили!"
                    }
                    else -> checkWatermelon(l.toInt(), weight)

                }
            else
                Toast.makeText(requireContext(), "Введите корректное значение", Toast.LENGTH_SHORT)
                    .show()
        }

    }



    private fun checkWatermelon(l: Int, weight: Float?) {
        val mMap = createMapCircle()
        val resM = 0.017 * l.toDouble().pow(3.toDouble()) / 1000
        val percent = (resM / 100 * 10).toFloat()

        val goodWeightMinus = mMap[l]?.minus(percent)
        val goodWeightPlus = mMap[l]?.plus(percent)

        text_view_test.text ="$goodWeightMinus - табличный вес минус 10%\n" +
                "$goodWeightPlus - табличный вес плюс 10%\n" +
                "$percent - процент\n" +
                "$resM - масса по формуле\n" +
                "$weight - веденная масса\n"

        when {
            (weight!! > goodWeightMinus!!) && (weight < goodWeightPlus!!) -> {
                text_view_review.text =
                    "Да, скорее всего это спелый арбуз, берите. Надо попробовать на сколько он сладкий"
            }
            (weight < goodWeightMinus) -> {
                text_view_review.text =
                    "Наверное это хороший арбуз, но съесть его надо сегодня, может быть переспелый"
            }
            (weight > goodWeightPlus!!) -> {
                text_view_review.text = "Э! Положи арбуз. Пока он зеленый"

            }
        }

    }

}