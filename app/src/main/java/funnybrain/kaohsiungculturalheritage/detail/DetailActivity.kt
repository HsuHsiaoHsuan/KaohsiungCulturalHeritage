package funnybrain.kaohsiungculturalheritage.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NavUtils
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
        setSupportActionBar(find<Toolbar>(R.id.toolbar))
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val data = intent.getParcelableExtra<DataItem>(DetailFragment.ARG_DATA)

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
