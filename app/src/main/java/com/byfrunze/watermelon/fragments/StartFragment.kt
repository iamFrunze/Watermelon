package com.byfrunze.watermelon.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.navigateUp
import com.byfrunze.watermelon.R
import com.byfrunze.watermelon.data.tableL
import com.byfrunze.watermelon.data.tableM
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_start.*


class StartFragment : Fragment(R.layout.fragment_start) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_circle_watermelon.setOnClickListener {
            val weight = edit_text_m.text.toString()

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