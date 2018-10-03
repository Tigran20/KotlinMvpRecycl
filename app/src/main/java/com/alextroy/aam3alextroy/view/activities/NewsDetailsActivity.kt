package com.alextroy.aam3alextroy.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alextroy.aam3alextroy.R
import com.alextroy.aam3alextroy.model.NewsItem

class NewsDetailsActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var title: TextView
    private lateinit var context: Context
    private lateinit var data: List<NewsItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_detail)
    }


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, NewsDetailsActivity::class.java)
        }
    }
}