package br.com.ajchagas.technewsapi.retrofit.webClient

import br.com.ajchagas.technewsapi.model.News
import br.com.ajchagas.technewsapi.retrofit.service.ServiceNews

class NewsWebClient(
    private val service : ServiceNews
) {

    fun getNewTopHealines(): News? {
        return service.getTopHealinesNews().execute().body()
    }

    fun getBusinessNews(): News? {
        return service.getBusinessNews().execute().body()
    }

    fun getEntertainmentNews(): News? {
        return service.getEntertainmentNews().execute().body()
    }

    fun getTechnologyNews(): News? {
        return service.getTechnologyNews().execute().body()
    }
}