package br.com.ajchagas.technewsapi.repository

import br.com.ajchagas.technewsapi.model.News

class RepositoryNews {
    fun buscaNoticias(
        quandoSucesso: (noticiasNovas: News) -> Unit,
        quandoFalha: (msg: String?) -> Unit
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
