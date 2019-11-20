package br.com.ajchagas.technewsapi.ui.activity

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.ajchagas.technewsapi.R
import kotlinx.android.synthetic.main.activity_details_news.*


class DetailsNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_news)


        val intent = intent
        val url = intent.getStringExtra("url")
        val titleNews = intent.getStringExtra("title")
        title = titleNews


        configuraWebView(url)
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
            webView.webViewClient = WebViewClient()
            webView.loadUrl(url)
        }else{
            Toast.makeText(this, "Não foi possível entrar nesse site", Toast.LENGTH_LONG).show()
        }

    }
}
