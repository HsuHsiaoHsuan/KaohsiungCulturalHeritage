package funnybrain.kaohsiungculturalheritage.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import funnybrain.kaohsiungculturalheritage.BaseActivity
import funnybrain.kaohsiungculturalheritage.R
import org.jetbrains.anko.*

class SingleFrameLayoutUi : AnkoComponent<BaseActivity> {

    lateinit var toolBar: Toolbar

    override fun createView(ui: AnkoContext<BaseActivity>) = with(ui) {

        include<View>(R.layout.framelayout)

//        verticalLayout {
//
//            lparams(width = matchParent, height = matchParent)
//
//            toolBar = toolbar {
//                lparams(width = matchParent, height = wrapContent)
//                id = R.id.toolbar
//                backgroundDrawable = ColorDrawable(resources.getColor(R.color.colorPrimary))
//                setTitleTextColor(Color.WHITE)
//            }
//
//            frameLayout {
//                lparams(width = matchParent, height = matchParent)
//                id = R.id.main_view
//            }
//        }

    }
}