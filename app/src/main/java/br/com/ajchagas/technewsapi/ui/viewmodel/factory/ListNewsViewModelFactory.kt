package br.com.ajchagas.technewsapi.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.ajchagas.technewsapi.repository.RepositoryNews
import br.com.ajchagas.technewsapi.ui.viewmodel.ListNewsViewModel

class ListNewsViewModelFactory(
    private val repository: RepositoryNews
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListNewsViewModel(repository) as T
    }
}