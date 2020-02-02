package br.com.ajchagas.technewsapi.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.ajchagas.technewsapi.model.News
import br.com.ajchagas.technewsapi.repository.RepositoryNews
import br.com.ajchagas.technewsapi.repository.Resource
import kotlinx.coroutines.Job

class PageViewModel(
    private val repository : RepositoryNews
) : ViewModel() {

    private val viewModelJob = Job()

    fun getTopHeadlinesNews() : LiveData<Resource<News?>?>{
        return repository.getTopHealinesNews(viewModelJob)
    }

    fun getBusinessNews(): LiveData<Resource<News?>?> {
        return repository.getBusinessNews(viewModelJob)
    }

    fun getEntertainmentNews(): LiveData<Resource<News?>?> {
        return repository.getEntertainmentNews(viewModelJob)
    }


    fun getTechnologyNews(): LiveData<Resource<News?>?> {
        return repository.getTechnologyNews(viewModelJob)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}