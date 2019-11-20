package br.com.ajchagas.technewsapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.ajchagas.technewsapi.model.News
import br.com.ajchagas.technewsapi.retrofit.webClient.NewsWebClient

class RepositoryNews(
    private val webclient : NewsWebClient = NewsWebClient()
) {
    private val noticiasDaApi = MutableLiveData<Resource<News>?>()

    fun buscaNoticias() : LiveData<Resource<News>?> {

        webclient.buscaNoticias(quandoSucesso = { novasNoticias ->
            noticiasDaApi.value = Resource(dado = novasNoticias)
        }, quandoFalha = {msgErro ->
/*O  live data sempre retorna sua ultima lista, portando é ideal verificar se o livedata atual é
 diferente de null, pois se for null, ou seja, se api falha a gente devolve o ultimo resulta e a msg de erro*/

            val resultadoAtual = noticiasDaApi.value
            val resultadoAtualizado = criaResourceDeFalha<News>(resultadoAtual, msgErro)
            noticiasDaApi.value = resultadoAtualizado
        })

        return noticiasDaApi
    }



}
