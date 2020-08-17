package com.byfrunze.watermelon

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab_info.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage(
                    "Есть старый и проверенный веками способ определить спелость арбуза. " +
                            "Необходимо бросить его в воду. Если арбуз утонет, значит он еще зеленый. Если останется плавать," +
                            " то созрел. Но, на рынке нет бассейна. Однако есть современная наука и современные гаджеты, которые помогают с помощью сложных" +
                            " вычислений быстро узнать про арбуз всё необходимое. Следует помнить, что эти методы хороши исключительно для арбузов выращенных естественным путем. " +
                            "Как современная химия влияет на традиционные способы не известно. Информация взята из открытых источников, переработана и дополнена. " +
                            "Данный сервис сделан исключительно для собственного удобства. Дабы избавить мозг от сложных расчетов. \n" +
                            "Эффективность метода 91,7%."
                )
                .setPositiveButton(
                    "Я понял"
                ) { dialog, _ -> dialog?.dismiss() }
                .show()

        }
    }
}