package br.com.ajchagas.technewsapi.ui.adapter

import android.content.Context
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ajchagas.technewsapi.R
import br.com.ajchagas.technewsapi.model.Article
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item.view.news_item_imageView_thumbnail
import kotlinx.android.synthetic.main.news_item.view.news_item_source
import kotlinx.android.synthetic.main.news_item.view.news_item_title
import kotlinx.android.synthetic.main.news_item_2.view.*
import java.text.SimpleDateFormat
import java.util.*


class RecyclerViewListNewsAdapter(
    private val context:Context,
    private val listOfNews : MutableList<Article> = mutableListOf(),
    var clickListener: (Article) -> Unit = {}
) : RecyclerView.Adapter<RecyclerViewListNewsAdapter.ViewHolderNews>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNews {
        val viewCriada = LayoutInflater.from(context).inflate(R.layout.news_item_2, parent, false)
        return ViewHolderNews(viewCriada)
    }

    override fun getItemCount() = listOfNews.size

    override fun onBindViewHolder(holder: ViewHolderNews, position: Int) {
        val news = listOfNews[position]
        holder.bindView(news, clickListener)

    }

    fun update(listaDeNoticias: List<Article>) {
        notifyItemRangeRemoved(0, this.listOfNews.size)
        this.listOfNews.clear()
        this.listOfNews.addAll(listaDeNoticias)
        notifyItemRangeInserted(0, this.listOfNews.size)
    }


    inner class ViewHolderNews(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var article: Article

        fun bindView(article: Article, clickListener: (Article) -> Unit) {

            if(article.urlToImage != null){
                this.article = article
                setupTitle(article)
                itemView.news_item_description.text = article.description
                itemView.news_item_author.text = article.author
                setupHoursAgo(article)
                setupSource(article)
                setupThumbnail(article)
                itemView.setOnClickListener { clickListener(article) }
            }
        }

        private fun setupHoursAgo(article: Article) {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val time = sdf.parse(article.publishedAt).getTime()

            itemView.news_item_hours_ago.text =  DateUtils.getRelativeTimeSpanString(time, System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS)
        }

        private fun setupThumbnail(article: Article) {
            val imageView = itemView.news_item_imageView_thumbnail
            Picasso
                .get()
                .load(article.urlToImage)
                .fit()
                .centerCrop()
                .placeholder(R.drawable.ic_cloud_download_black_24dp)
                .error(R.drawable.ic_error_black_24dp)
                .into(imageView)
        }

        private fun setupSource(article: Article) {
            itemView.news_item_source.text = article.source.name
        }

        private fun setupTitle(article: Article) {
            itemView.news_item_title.text = article.title
        }

    }
}
