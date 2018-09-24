package funnybrain.kaohsiungculturalheritage.main

import android.os.Bundle
import funnybrain.kaohsiungculturalheritage.ActivityUtils
import funnybrain.kaohsiungculturalheritage.BaseActivity
import funnybrain.kaohsiungculturalheritage.R
import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import funnybrain.kaohsiungculturalheritage.data.source.DataRepository
import funnybrain.kaohsiungculturalheritage.detail.DetailActivity
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity(), MainFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DataItem?) {
        println(item!!.title)
        startActivity<DetailActivity>("DATA" to item)
    }

//    lateinit var mainUi: SingleFrameLayoutUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        mainUi = SingleFrameLayoutUi()
//        mainUi.setContentView(this)
//        SingleFrameLayoutUi().setContentView(this)

        val f: MainFragment = MainFragment.newInstance()
        f.setPresenter(MainPresenter(DataRepository.getInstance(), f))

        ActivityUtils
                .addFragmentToActivityWithTag(
                        fragmentManager = supportFragmentManager,
                        fragment = f,
                        frameId = R.id.main_view,
                        tag = "MainFragment")

//        DataRepository.getInstance().getItem(Consumer {
//            it.forEach {
//                println(it.title)
//            }
//        })
    }
}
