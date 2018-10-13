package funnybrain.kaohsiungculturalheritage.detail

import android.os.Bundle
import funnybrain.kaohsiungculturalheritage.ActivityUtils
import funnybrain.kaohsiungculturalheritage.BaseActivity
import funnybrain.kaohsiungculturalheritage.R
import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import funnybrain.kaohsiungculturalheritage.main.SingleFrameLayoutUi
import org.jetbrains.anko.setContentView

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SingleFrameLayoutUi().setContentView(this)
//        setContentView(R.layout.framelayout)

        val data = intent.getParcelableExtra<DataItem>(DetailFragment.ARG_DATA)

        val f: DetailFragment = DetailFragment.newInstance(data)
        ActivityUtils.addFragmentToActivityWithTag(
                fragmentManager = supportFragmentManager,
                fragment = f,
                frameId = R.id.main_view,
                tag = "DetailFragment")


    }
}
