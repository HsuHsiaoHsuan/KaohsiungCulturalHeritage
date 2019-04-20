package funnybrain.kaohsiungculturalheritage.main

import android.content.Context
import funnybrain.kaohsiungculturalheritage.BasePresenter
import funnybrain.kaohsiungculturalheritage.BaseView
import funnybrain.kaohsiungculturalheritage.data.model.DataItem

class MainContract {
    interface View : BaseView<Presenter> {
        fun getDataOk(data: List<DataItem>)

        fun getDataFail(msg: String)
    }

    interface Presenter : BasePresenter {
        fun getData(context: Context)
    }
}