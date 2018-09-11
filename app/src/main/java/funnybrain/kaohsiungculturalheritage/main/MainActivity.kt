package funnybrain.kaohsiungculturalheritage.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import funnybrain.kaohsiungculturalheritage.ActivityUtils
import funnybrain.kaohsiungculturalheritage.R
import funnybrain.kaohsiungculturalheritage.data.source.DataRepository
import funnybrain.kaohsiungculturalheritage.main.dummy.DummyContent
import io.reactivex.functions.Consumer
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity(), MainFragment.OnListFragmentInteractionListener {

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
    }

    lateinit var mainUi: MainActivityUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainUi = MainActivityUi()
        mainUi.setContentView(this)

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
