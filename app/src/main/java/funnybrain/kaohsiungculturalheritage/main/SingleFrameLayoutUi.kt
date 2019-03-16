package funnybrain.kaohsiungculturalheritage.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import funnybrain.kaohsiungculturalheritage.BaseActivity
import funnybrain.kaohsiungculturalheritage.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.themedToolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.themedAppBarLayout

class SingleFrameLayoutUi : AnkoComponent<BaseActivity> {

//    lateinit var toolBar: Toolbar

    override fun createView(ui: AnkoContext<BaseActivity>) = with(ui) {

//        include<View>(R.layout.framelayout)

        coordinatorLayout {
            lparams(width = matchParent, height = matchParent) {
                fitsSystemWindows = true
                backgroundDrawable = ColorDrawable(ContextCompat.getColor(context, R.color.background))
            }

            themedAppBarLayout(theme = R.style.AppTheme_AppBarOverlay) {
                lparams(width = matchParent, height = wrapContent)

                themedToolbar(theme = R.style.ToolbarStyle) {
                    id = R.id.toolbar
                    backgroundDrawable = ColorDrawable(ContextCompat.getColor(context, R.color.colorPrimary))
                    popupTheme = R.style.AppTheme_PopupOverlay
                    title = resources.getString(R.string.app_name)
                    setTitleTextColor(Color.WHITE)
                }.lparams(width = matchParent, height = dimenAttr(R.attr.actionBarSize))
            }

            frameLayout {
                lparams(width = matchParent, height = matchParent)
                id = R.id.main_view
            }.lparams(width = matchParent, height = matchParent) {
                behavior = AppBarLayout.ScrollingViewBehavior()
            }
        }

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