package br.com.ajchagas.technewsapi.ui.reciclerview.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ajchagas.technewsapi.R
import br.com.ajchagas.technewsapi.model.Article
import br.com.ajchagas.technewsapi.ui.activity.extension.formataData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_noticia.view.*

class ListNewsAdapter(
    private val context:Context,
    private val listaDeNoticias : MutableList<Article> = mutableListOf(),
    var clickListener: (Article) -> Unit = {}
) : RecyclerView.Adapter<ListNewsAdapter.ViewHolderNews>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNews {
        val viewCriada = LayoutInflater.from(context).inflate(R.layout.item_noticia, parent, false)
        return ViewHolderNews(viewCriada)
    }

    override fun getItemCount() = listaDeNoticias.size


    override fun onBindViewHolder(holder: ViewHolderNews, position: Int) {
        val news = listaDeNoticias[position]
        holder.vincula(news, clickListener)

    }

    fun atualiza(listaDeNoticias: List<Article>) {
        notifyItemRangeRemoved(0, this.listaDeNoticias.size)
        this.listaDeNoticias.clear()
        this.listaDeNoticias.addAll(listaDeNoticias)
        notifyItemRangeInserted(0, this.listaDeNoticias.size)
    }


    inner class ViewHolderNews(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var article: Article

        fun vincula(article: Article, clickListener: (Article) -> Unit) {

            if(article.urlToImage != null){
                this.article = article

                itemView.item_noticia_textView_titulo.text = article.title
                itemView.item_noticia_textView_source.text = article.source.name
                itemView.item_noticia_data.text = article.publishedAt.formataData()
                Log.i("teste", article.urlToImage + article.title)

                val imageView = itemView.item_noticia_imageView_thumbnail

                Picasso.get().load(article.urlToImage).into(imageView)

                itemView.setOnClickListener { clickListener(article) }
            }
        }

    }
}
