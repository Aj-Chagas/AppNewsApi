package br.com.ajchagas.technewsapi.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.ajchagas.technewsapi.model.News
import br.com.ajchagas.technewsapi.repository.RepositoryNews

class ListNewsViewModel(
    private val repository : RepositoryNews
) : ViewModel() {

    fun buscaNoticias(quandoSucesso: (noticiasNovas : News) -> Unit,
                      quandoFalha: (msg: String?) -> Unit) {

        repository.buscaNoticias(quandoSucesso, quandoFalha)
    }
}