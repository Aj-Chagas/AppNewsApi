package br.com.ajchagas.technewsapi.retrofit.webClient

import br.com.ajchagas.technewsapi.model.News
import br.com.ajchagas.technewsapi.retrofit.RetrofitConfig
import br.com.ajchagas.technewsapi.retrofit.service.ServiceNews
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val REQUISICAO_NAO_SUCEDIDA: String = "Requisição não sucedida"

class NewsWebClient(
    private val service : ServiceNews = RetrofitConfig().serviceNews
) {


    fun <T> executaRequisicao(
        call: Call<T>,
        quandoSucesso: (noticiasNovas: T?) -> Unit,
        quandoFalha: (erro: String) -> Unit
    ){
        call.enqueue(object : Callback<T>{
            override fun onFailure(call: Call<T>, t: Throwable) {
                t.message?.let { quandoFalha(it) }
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                if(response.isSuccessful){
                    quandoSucesso(response.body())
                }else{
                    quandoFalha(REQUISICAO_NAO_SUCEDIDA)
                }
            }

        })
    }

    fun buscaNoticias(
        quandoSucesso : (noticiasNovas: News?) -> Unit,
        quandoFalha: (erro: String) -> Unit
    ){
        executaRequisicao(
            service.getNewsApi(),
            quandoSucesso,
            quandoFalha)
    }


}