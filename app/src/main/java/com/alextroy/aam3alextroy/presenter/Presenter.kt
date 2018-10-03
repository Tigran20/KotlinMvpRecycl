package com.alextroy.aam3alextroy.presenter

import com.alextroy.aam3alextroy.model.DataUtils
import com.alextroy.aam3alextroy.model.NewsItem

class Presenter : Contract.Presenter {
    private var data: Contract.Data = DataUtils

    override fun getDataModel(): List<NewsItem> {
        return data.getDataList()
    }

}