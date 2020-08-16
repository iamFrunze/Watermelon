package com.byfrunze.watermelon.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.byfrunze.watermelon.R
import com.byfrunze.watermelon.data.tableL
import com.byfrunze.watermelon.utils.createMapCircle
import com.byfrunze.watermelon.utils.createMapOval
import kotlinx.android.synthetic.main.fragment_oval_watermelon.*
import java.text.DecimalFormat
import kotlin.math.abs
import kotlin.math.pow

class OvalWatermelonFragment : Fragment(R.layout.fragment_oval_watermelon) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val weight = arguments?.getFloat("weight")

        btn_review_oval.setOnClickListener {
            val sl = edit_text_sl_oval.text.toString()
            val bl = edit_text_bl_oval.text.toString()

            if (check(sl, bl))
                checkWatermelon(sl.toInt(), bl.toInt(), weight)
            else
                Toast.makeText(requireContext(), "Введите корректное значение", Toast.LENGTH_SHORT)
                    .show()
        }

    }

    private fun checkWatermelon(sl: Int, bl: Int, weight: Float?) {
        val d = DecimalFormat("#.##")
        val R1 = (sl / 6.2831).pow(2).toFloat()
        val R2 = (bl / 6.2831).toFloat()
        val V = (5.5851 * R1 * R2).toFloat()


        val mMap = createMapOval()
        val newV = d.format(V).toFloat()

        val keySet = mMap.keys

        var minV = findMin(newV, keySet)
        val indexOfL = mMap.getValue(minV)
        val L = tableL[indexOfL]

        when {
            L < 45 ->
                text_view_review_oval.text = "Э! Положи. Это не арбуз, это крупный виноград."
            L > 45 ->
                text_view_review_oval.text =
                    "О-О! Такой большой! Зачем он тебе? Этот арбуз что с детства лечили!"
        }
        val mCircleMap = createMapCircle()
        val perfectWeight = mCircleMap.getValue(L)
        val percent = (perfectWeight / 100 * 10)

        val goodWeightMinus = mCircleMap[L]?.minus(percent)
        val goodWeightPlus = mCircleMap[L]?.plus(percent)

        text_view_test_oval.text =
            "$goodWeightMinus - табличный вес минус 10%\n" +
                    "$goodWeightPlus - табличный вес плюс 10%\n" +
                    "$percent - процент\n" +
                    "$perfectWeight - масса по формуле\n" +
                    "$weight - веденная масса\n"
        when {
            (weight!! > goodWeightMinus!!) && (weight < goodWeightPlus!!) -> {
                text_view_review_oval.text =
                    "Да, скорее всего это спелый арбуз, берите. Надо попробовать на сколько он сладкий"
            }
            (weight < goodWeightMinus) -> {
                text_view_review_oval.text =
                    "Наверное это хороший арбуз, но съесть его надо сегодня, может быть переспелый"
            }
            (weight > goodWeightPlus!!) -> {
                text_view_review_oval.text = "Э! Положи арбуз. Пока он зеленый"

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
            Log.i("RESULT", "min $currentMin V - $v")
            if (currentMin < maxMin) {
                maxMin = currentMin
                index = i
                Log.i("RESULT", "min I $index")
            }
        }
        return index
    }
}