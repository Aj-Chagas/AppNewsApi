package br.com.ajchagas.technewsapi.di.module

import br.com.ajchagas.technewsapi.repository.RepositoryNews
import br.com.ajchagas.technewsapi.retrofit.RetrofitConfig
import br.com.ajchagas.technewsapi.retrofit.service.ServiceNews
import br.com.ajchagas.technewsapi.retrofit.webClient.NewsWebClient
import br.com.ajchagas.technewsapi.ui.adapter.RecyclerViewListNewsAdapter
import br.com.ajchagas.technewsapi.ui.viewmodel.PageNewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<ServiceNews> {
        RetrofitConfig().serviceNews
    }

    single<NewsWebClient> {
        NewsWebClient(get())
    }

    single<RepositoryNews> {
        RepositoryNews(get())
    }


    factory<RecyclerViewListNewsAdapter> {
        RecyclerViewListNewsAdapter(get())
    }

    viewModel<PageNewsViewModel> {
        PageNewsViewModel(get())
    }

}
