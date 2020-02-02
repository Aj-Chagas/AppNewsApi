package br.com.ajchagas.technewsapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.ajchagas.technewsapi.model.News
import br.com.ajchagas.technewsapi.retrofit.webClient.NewsWebClient
import kotlinx.coroutines.*
import java.io.IOException

class RepositoryNews(
    private val webclient : NewsWebClient
) {

    private val topHealinesNews = MutableLiveData<Resource<News?>?>()

    fun getTopHealinesNews(viewModelJob: Job = Job()): LiveData<Resource<News?>?> {
        return topHealinesNews.also { liveData ->
            CoroutineScope(Dispatchers.IO + viewModelJob).launch{
                val resource :  Resource<News?>? = try{
                    SucessoResource(dado = webclient.getNewTopHealines())
                } catch (e : IOException){
                    FalhaResourc(erro = e.message!!)
                }
                liveData.postValue(resource)
            }
        }
    }

    private val businessNews = MutableLiveData<Resource<News?>?>()

    fun getBusinessNews(viewModelJob: Job = Job()): LiveData<Resource<News?>?> {
        return businessNews.also {liveData ->
            CoroutineScope(Dispatchers.IO + viewModelJob).launch{
                val resource :  Resource<News?>? = try{
                    SucessoResource(dado = webclient.getBusinessNews())
                } catch (e : IOException){
                    FalhaResourc(erro = e.message!!)
                }
                liveData.postValue(resource)
            }
        }
    }

    private val entertainmentNews = MutableLiveData<Resource<News?>?>()

    fun getEntertainmentNews(viewModelJob: CompletableJob): LiveData<Resource<News?>?> {
        return entertainmentNews.also {liveData ->
            CoroutineScope(Dispatchers.IO + viewModelJob).launch{
                val resource :  Resource<News?>? = try{
                    SucessoResource(dado = webclient.getEntertainmentNews())
                } catch (e : IOException){
                    FalhaResourc(erro = e.message!!)
                }
                liveData.postValue(resource)
            }
        }
    }

    private val technologyNews = MutableLiveData<Resource<News?>?>()

    fun getTechnologyNews(viewModelJob: CompletableJob): LiveData<Resource<News?>?> {
        return technologyNews.also {liveData ->
            CoroutineScope(Dispatchers.IO + viewModelJob).launch{
                val resource :  Resource<News?>? = try{
                    SucessoResource(dado = webclient.getTechnologyNews())
                } catch (e : IOException){
                    FalhaResourc(erro = e.message!!)
                }
                liveData.postValue(resource)
            }
        }
    }
}
