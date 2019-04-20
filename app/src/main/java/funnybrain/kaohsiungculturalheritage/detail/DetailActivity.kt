package funnybrain.kaohsiungculturalheritage.detail

import android.os.Bundle
import android.view.MenuItem
import funnybrain.kaohsiungculturalheritage.ActivityUtils
import funnybrain.kaohsiungculturalheritage.BaseActivity
import funnybrain.kaohsiungculturalheritage.R
import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import funnybrain.kaohsiungculturalheritage.main.SingleFrameLayoutUi
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class DetailActivity : BaseActivity() {

//    lateinit var mainUi: SingleFrameLayoutUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mainUi = SingleFrameLayoutUi()
//        mainUi.setContentView(this)
        SingleFrameLayoutUi().setContentView(this)
        setSupportActionBar(find(R.id.toolbar))
        val data = intent.getParcelableExtra<DataItem>(DetailFragment.ARG_DATA)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = data.title

        val f: DetailFragment = DetailFragment.newInstance(data)
        ActivityUtils.addFragmentToActivityWithTag(
                fragmentManager = supportFragmentManager,
                fragment = f,
                frameId = R.id.main_view,
                tag = "DetailFragment")
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
//            android.R.id.home -> NavUtils.navigateUpFromSameTask(this)
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
