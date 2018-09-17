package funnybrain.kaohsiungculturalheritage.main

import funnybrain.kaohsiungculturalheritage.BaseActivity
import funnybrain.kaohsiungculturalheritage.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.matchParent

class SingleFrameLayoutUi : AnkoComponent<BaseActivity> {

    override fun createView(ui: AnkoContext<BaseActivity>) = with(ui) {
        frameLayout {
            lparams(width = matchParent, height = matchParent)
            id = R.id.main_view
        }
    }
}