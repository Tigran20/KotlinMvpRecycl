package com.alextroy.aam3alextroy.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alextroy.aam3alextroy.R
import com.alextroy.aam3alextroy.model.DataUtils
import com.alextroy.aam3alextroy.model.NewsItem
import com.alextroy.aam3alextroy.presenter.Contract
import com.alextroy.aam3alextroy.presenter.Presenter


class NewsListActivity : AppCompatActivity(), Contract.ActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_list)

        val news = ArrayList<NewsItem>()
        news.addAll(DataUtils.generateNews())
        init(news)
    }

    private fun showToast(model: String) {
        Toast.makeText(this, model, Toast.LENGTH_SHORT).show()
    }

    override fun showItem(string: String) {
        showToast(string)
    }

    private fun init(news: List<NewsItem>) {

        val presenter: Contract.Presenter? = Presenter(this)

        val rv = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = NewsAdapter(news, this)
        val dec = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        rv.addItemDecoration(dec)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        adapter.addAll(presenter!!.getDataModel())

        adapter.setOnItemClickListener(object : NewsAdapter.OnItemClickListener {
            override fun onClick(view: View, data: NewsItem) {
                val intent = AboutActivity.newIntent(this@NewsListActivity)
                startActivity(intent)
            }
        })
    }
}