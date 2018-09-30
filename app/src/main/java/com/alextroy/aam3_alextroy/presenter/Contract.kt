package com.alextroy.aam3_alextroy.presenter

import com.alextroy.aam3_alextroy.model.NewsItem

interface Contract {
    interface Data {
        fun getDataList(): List<NewsItem>
        fun getModelItem(position: Int): NewsItem
    }

    interface Presenter {
        fun getDataModel(): List<NewsItem>
        fun selectedItem(selectId: Int)
    }

    interface ActivityView {
        fun showItem(string: String)
    }
}