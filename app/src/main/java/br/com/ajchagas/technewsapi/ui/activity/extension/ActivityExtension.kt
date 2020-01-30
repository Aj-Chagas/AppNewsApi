package br.com.ajchagas.technewsapi.ui.activity.extension

import android.app.Activity
import android.widget.Toast
import br.com.ajchagas.technewsapi.R

fun Activity.mostraErro(mensagem: String) {
    Toast.makeText(
        this,
        mensagem,
        Toast.LENGTH_LONG
    ).show()
}