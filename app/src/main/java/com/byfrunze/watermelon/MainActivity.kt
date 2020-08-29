package com.byfrunze.watermelon

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {
    lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this)

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        adView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.i("ADMOB", adError.message)
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        }
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
                    "Я понял(a)"
                ) { dialog, _ -> dialog?.dismiss() }
                .show()

        }
    }
}