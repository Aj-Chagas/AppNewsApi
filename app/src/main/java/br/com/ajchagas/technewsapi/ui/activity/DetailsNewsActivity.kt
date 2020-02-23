package br.com.ajchagas.technewsapi.ui.activity

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.ajchagas.technewsapi.R
import br.com.ajchagas.technewsapi.URL_KEY
import kotlinx.android.synthetic.main.activity_details_news.*
import android.webkit.WebView
import android.webkit.WebChromeClient
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T





class DetailsNewsActivity : AppCompatActivity() {

    private val webViewClient by lazy {
        WebViewClient()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_news)
        configuraWebView(getUrl())
        setupLoadingWebView(getUrl())
    }

    private fun getUrl(): String? {
        val intent = intent
        val url = intent.getStringExtra(URL_KEY)
        return url
    }

    private fun configuraWebView(url: String?) {
        if(url != null){
            val webView = details_news_webView
            webView.settings.loadsImagesAutomatically = true
            webView.settings.javaScriptEnabled = true
            webView.settings.domStorageEnabled = true
            webView.settings.setSupportZoom(true)
            webView.settings.builtInZoomControls = true
            webView.settings.displayZoomControls = false
            webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
            webView.webViewClient = webViewClient
            webView.loadUrl(url)

        }else{
            Toast.makeText(this, "Ops! Ocorreu um erro", Toast.LENGTH_LONG).show()
        }
    }

    private fun setupLoadingWebView(url: String?) {
        showLoading()
        details_news_webView.setWebChromeClient(object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {
                if (progress == 100)
                    closeLoading()
            }
        })
    }

    private fun closeLoading() {
        details_news_progress_bar.visibility = View.GONE
    }

    private fun showLoading() {
        details_news_progress_bar.visibility = View.VISIBLE
    }
}
