package com.byfrunze.watermelon.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.byfrunze.watermelon.R
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.fragment_start.*


class StartFragment : Fragment(R.layout.fragment_start) {

    val STORAGE_NAME = "SETTINGS"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_circle_watermelon.setOnClickListener {
            val weight = edit_text_m.text.toString()
            val settings = requireContext().getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)
            val editor = settings.edit()
            editor.putString("weight", weight)
            editor.apply()

            if (weight.matches("^\\d+(\\.\\d+)*\$+".toRegex())) {
                val bundle = Bundle()
                bundle.putFloat("weight", weight.toFloat())
                findNavController().navigate(R.id.circleWatermelonFragment, bundle)
            } else
                Toast.makeText(requireContext(), "Введите корректное значение", Toast.LENGTH_SHORT)
                    .show()
        }

        btn_oval_watermelon.setOnClickListener {
            val weight = edit_text_m.text.toString()
            val settings = requireContext().getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)
            val editor = settings.edit()
            editor.putString("weight", weight)
            editor.apply()
            if (weight.matches("^\\d+(\\.\\d+)*\$+".toRegex())) {
                val bundle = Bundle()
                bundle.putFloat("weight", weight.toFloat())
                findNavController().navigate(R.id.ovalWatermelonFragment, bundle)
            } else
                Toast.makeText(requireContext(), "Введите корректное значение", Toast.LENGTH_SHORT)
                    .show()
        }


    }
}