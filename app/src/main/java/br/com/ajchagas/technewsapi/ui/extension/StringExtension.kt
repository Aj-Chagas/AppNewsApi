package br.com.ajchagas.technewsapi.ui.extension

fun String.formataData() : String {
    val ano = this.substring(0, 4)
    val mes = this.substring(5, 7)
    val dia = this.substring(8, 10)

    return "${dia}/${mes}/${ano}"
}