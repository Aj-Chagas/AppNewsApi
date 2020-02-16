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

    fun getHeathNews(): News? {
        return service.getHeathNews().execute().body()
    }

    fun getScienceNews(): News? {
        return service.getScienceNews().execute().body()
    }

    fun getSportNews(): News? {
        return service.getSportNews().execute().body()
    }
}