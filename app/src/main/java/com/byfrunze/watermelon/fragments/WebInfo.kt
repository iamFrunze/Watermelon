package com.byfrunze.watermelon.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.byfrunze.watermelon.R
import kotlinx.android.synthetic.main.fragment_web.*

class WebInfo : Fragment(R.layout.fragment_web) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webViewClient: WebViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                view.loadUrl(request.url.toString())
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
        webView.webViewClient = webViewClient
        webView.loadUrl("https://yandex.ru")

    }
}