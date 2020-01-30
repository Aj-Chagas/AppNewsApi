package br.com.ajchagas.technewsapi.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.ajchagas.technewsapi.model.News
import br.com.ajchagas.technewsapi.repository.RepositoryNews
import br.com.ajchagas.technewsapi.repository.Resource

class ListNewsViewModel(
    private val repository : RepositoryNews
) : ViewModel() {


    fun buscaNoticias() : LiveData<Resource<News>?>{
        return repository.buscaNoticias()
    }
}