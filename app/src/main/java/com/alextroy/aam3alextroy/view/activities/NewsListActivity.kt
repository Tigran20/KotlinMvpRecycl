package com.alextroy.aam3alextroy.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alextroy.aam3alextroy.R
import com.alextroy.aam3alextroy.model.DataUtils
import com.alextroy.aam3alextroy.model.NewsItem
import com.alextroy.aam3alextroy.presenter.Contract
import com.alextroy.aam3alextroy.presenter.Presenter
import com.alextroy.aam3alextroy.view.adapter.NewsAdapter


class NewsListActivity : AppCompatActivity() {

    private lateinit var presenter: Contract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_list)

        val news = ArrayList<NewsItem>()
        news.addAll(DataUtils.generateNews())
        init(news)
    }

    private fun init(news: List<NewsItem>) {
        presenter = Presenter()

        val rv = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = NewsAdapter(news, this)
        val dec = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        rv.addItemDecoration(dec)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        adapter.addAll(presenter.getDataModel())
    }
}