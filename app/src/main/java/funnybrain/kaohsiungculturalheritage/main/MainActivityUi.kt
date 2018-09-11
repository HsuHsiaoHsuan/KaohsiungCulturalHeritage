package funnybrain.kaohsiungculturalheritage.main

import funnybrain.kaohsiungculturalheritage.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.matchParent

class MainActivityUi : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        frameLayout {
            lparams(width = matchParent, height = matchParent)
            id = R.id.main_view
        }
    }
}