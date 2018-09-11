package funnybrain.kaohsiungculturalheritage.main

import funnybrain.kaohsiungculturalheritage.data.source.DataRepository
import io.reactivex.functions.Consumer

class MainPresenter(
        private val mDataRepository: DataRepository,
        private val mMainView: MainContract.View) : MainContract.Presenter {

    init {
        mMainView.setPresenter(this)
    }

    override fun getData() {
        mDataRepository.getItem(
                Consumer {
                    mMainView.getDataOk(it)
                },
                Consumer {
                    mMainView.getDataFail(it.localizedMessage)
                }
        )
    }
}