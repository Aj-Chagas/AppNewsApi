package br.com.ajchagas.technewsapi.ui.extension

import android.text.format.DateUtils
import java.text.SimpleDateFormat

fun String.formataData() : String {
    val ano = this.substring(0, 4)
    val mes = this.substring(5, 7)
    val dia = this.substring(8, 10)

    return "${dia}/${mes}/${ano}"
}

fun String.timeAgo() : String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val time = sdf.parse(this).time
    return DateUtils.getRelativeTimeSpanString(time, System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS).toString()
}