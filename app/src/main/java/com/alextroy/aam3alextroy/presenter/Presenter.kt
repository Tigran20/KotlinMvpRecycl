package com.alextroy.aam3alextroy.presenter

import com.alextroy.aam3alextroy.model.DataUtils
import com.alextroy.aam3alextroy.model.NewsItem

class Presenter(view2: Contract.ActivityView) : Contract.Presenter {
    private val view: Contract.ActivityView = view2
    private var data: Contract.Data = DataUtils

    override fun getDataModel(): List<NewsItem> {
        return data.getDataList()
    }

    override fun selectedItem(selectId: Int) {
        val model = data.getModelItem(selectId).category.name
        view.showItem(model)
    }
}